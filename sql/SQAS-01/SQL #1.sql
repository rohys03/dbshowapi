with dep as
(
  select /*+ inline */ *
  from   gv$object_dependency c
  where  to_owner = upper( :owner )
  and    to_name = upper( :table_name )
),
sqlarea as --> SQL_FULLTEXT �����ϸ� �ӵ� ��
(
  select inst_id, sql_id, address, hash_value
  from   (
           select /*+ no_merge */ a.*,
                  row_number( ) over( partition by sql_id order by executions desc ) sql_rn                     --> SQL_ID �ߺ�����
           from   (
                    select /*+ no_merge */ a.*,
                           row_number( ) over( partition by plan_hash_value order by executions desc ) phv_rn   --> PLAN_HASH_VALUE �ߺ����� ( �Ʒ� �ζ��κ�� ��ġ�� �ӵ� ��  )
                    from   (
                             select /*+ no_merge */ inst_id, sql_id, plan_hash_value, executions, address, hash_value
                             from   gv$sqlarea a
                             where  force_matching_signature != 0                                               --> force_matching_signature = 0 �̸� "INSERT VALUES" �ۿ� ����
                             and    parsing_schema_name not in ( 'SYS', 'SYSMAN', 'DBSNMP', 'SYSTEM', 'EXFSYS' )
                             and    not regexp_like( nvl( module, '-' ), 'Orange|SQL Developer|SQLGate|Data Pump|TOAD|golden|ERwin|PL.SQL Developer|SQL Loader|sqlplus|SQL.Plus' )
                             and    instr( upper( sql_fulltext ), upper( :table_name ) ) > 0  
                             --and    command_type in ( 2, 6, 7, 26, 189, 191 )                                 --> DML
                             --and    instr( upper( sql_fulltext ), 'SY_CO_DETAIL' ) > 0
                           ) a
                  ) a
           where  phv_rn = 1
         ) a
  where  sql_rn = 1
)
select /*+ ordered use_hash(b) no_swap_join_inputs(b) */
       b.inst_id,
       b.sql_id, 
       b.plan_hash_value,
       b.parsing_schema_name,
       b.module,
       case when b.program_id = 0 then null else b.program_id end as program_id,
       b.executions,
       round( b.buffer_gets / decode( b.executions, 0, 1, b.executions ) ) as "Blocks/Exec",
       b.last_active_time,
       dbms_lob.substr( sql_fulltext, 2000, 1      ) as substr_sql_text
from   sqlarea a,
       gv$sqlarea b
where  a.inst_id = b.inst_id
and    a.sql_id = b.sql_id
and    exists (
                select /*+ unnest hash_sj push_subq swap_join_inputs(c)  */ 'x'
                from   dep c
                where  a.address = c.from_address
                and    a.hash_value = c.from_hash
              )
;

  -- ��ȸ O : "SELECT *        FROM VW_EMP" --> VIEW        ���ο��� EMP ���̺� ��ȸ
  -- ��ȸ X : "SELECT COUNT(*) FROM EMP"    --> FN_EMP �Լ� ���ο��� EMP ���̺� ��ȸ
  
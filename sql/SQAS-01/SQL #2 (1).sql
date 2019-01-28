with dep as
(
  select /*+ inline */ *
  from   gv$object_dependency c
  where  to_owner = upper( :owner )
  and    to_name = upper( :table_name )
),
sqlarea as --> SQL_FULLTEXT 추출하면 속도 ↓
(
  select inst_id, sql_id, address, hash_value
  from   (
           select /*+ no_merge */ a.*,
                  row_number( ) over( partition by sql_id order by executions desc ) sql_rn                     --> SQL_ID 중복제거
           from   (
                    select /*+ no_merge */ a.*,
                           row_number( ) over( partition by plan_hash_value order by executions desc ) phv_rn   --> PLAN_HASH_VALUE 중복제거 ( 아래 인라인뷰와 합치면 속도 ↓  )
                    from   (
                             select /*+ no_merge */ inst_id, sql_id, plan_hash_value, executions, address, hash_value
                             from   gv$sqlarea a
                             where  force_matching_signature != 0                                               --> force_matching_signature = 0 이면 "INSERT VALUES" 밖에 없다
                             and    parsing_schema_name not in ( 'SYS', 'SYSMAN', 'DBSNMP', 'SYSTEM', 'EXFSYS' )
                             and    not regexp_like( nvl( module, '-' ), 'Orange|SQL Developer|SQLGate|Data Pump|TOAD|golden|ERwin|PL.SQL Developer|SQL Loader|sqlplus|SQL.Plus' )
                             and    instr( upper( sql_fulltext ), upper( :table_name ) ) > 0  
                             --and    command_type in ( 2, 6, 7, 26, 189, 191 )                                 --> DML
                             and    exists ( select /*+ unnest hash_sj */ 'x' 
                                             from   gv$sql_plan b 
                                             where  a.sql_id = b.sql_id 
                                             and    a.plan_hash_value = b.plan_hash_value
                                             and    ( instr( upper( access_predicates ), upper( :col ) ) > 0 or 
                                                      instr( upper( filter_predicates ), upper( :col ) ) > 0 ) )
                           ) a
                  ) a
           where  phv_rn = 1
         ) a
  where  sql_rn = 1
)
select /*+ ordered use_hash(b c) no_swap_join_inputs(b) no_swap_join_inputs(c) */
       b.inst_id,
       b.sql_id, 
       b.plan_hash_value,
       b.parsing_schema_name,
       b.module,
       --case when b.program_id = 0 then null else b.program_id end as program_id,
       c.object_name,
       b.executions,   
       round( b.buffer_gets / decode( b.executions, 0, 1, b.executions ) ) as "Blocks/Exec",
       b.last_active_time,
       dbms_lob.substr( sql_fulltext, 2000, 1      ) as as substr_sql_text
from   sqlarea a,
       gv$sqlarea b,
       dba_objects c
where  a.inst_id = b.inst_id
and    a.sql_id = b.sql_id
and    exists (
                select /*+ unnest hash_sj push_subq swap_join_inputs(c)  */ 'x'
                from   dep c
                where  a.address = c.from_address
                and    a.hash_value = c.from_hash
              )
and    b.program_id = c.object_id( + )
;
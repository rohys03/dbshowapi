SELECT DEPTH,TYPE,OWNER,NAME,PATH FROM (
select '1' as DEPTH,
       status,
       object_type type,
       owner, object_name name,
       0 rn       ,
       OBJECT_NAME PATH
from   dba_objects
where  1 = 1
and    object_name = upper( :table_name )
and    owner = upper( :owner )
and    object_type not in ( 'SYNONYM' )   
union all
select to_char(lv),
       min( status ) status,
       type,
       owner,
       name,
       min( rn ) rn,
       PATH
from   (
         select d.lv,
                o.object_type type,
                o.owner,
                lpad( ( case when lv = 1 then '' else ' �� ' end ), ( ( lv ) * 2 ), '    ') || o.object_name name,
                d.rn,
                o.status,
                PATH
         from   (
                  select object_id,
                         referenced_object_id,
                         level + 1 lv ,
                         rownum rn
                         , 'MT_CUPN'|| SYS_CONNECT_BY_PATH((select object_name from dba_objects o  where o.object_id = d.object_id), ' / ') "PATH"
                  from   public_dependency d
                  connect by prior object_id = referenced_object_id
                  start with referenced_object_id in (
                                                       select object_id
                                                       from   dba_objects
                                                       where  1 = 1
                                                       and    object_name = upper( :table_name )
                                                       and    owner = upper( :owner )
                                                       and    object_type not in ( 'SYNONYM' )
                                                     )
                ) d,
                dba_objects o
         where  d.object_id = o.object_id
         --and    o.object_type != 'SYNONYM'
       )
group by lv,
         type,
         owner,
         name      , path
         
order by rn
)
WHERE STATUS <> 'INVALID'
;

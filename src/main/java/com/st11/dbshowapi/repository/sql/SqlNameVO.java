package com.st11.dbshowapi.repository.sql;

import lombok.Data;

import java.sql.Date;

/*
SqlNameVO is Dauser.da_Sqlname_list join Dauser.da_sqlname_stats
 */
@Data
public class SqlNameVO extends SqlNameStatsVO {
    String sqlName;
    String repSqlId;
    String parsingSchemaName;
    String module;
    Date LastActiveTime;
}

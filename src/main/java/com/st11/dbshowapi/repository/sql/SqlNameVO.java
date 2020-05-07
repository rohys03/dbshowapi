package com.st11.dbshowapi.repository.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;


@Data
@EqualsAndHashCode(callSuper=false)
public class SqlNameVO extends SqlNameStatsVO {
    int dbId;
    long sqlNameNo;
    String sqlName;
    String repSqlId;
    String parsingSchemaName;
    String module;
    String owner;
    String tableName;
    Date LastActiveTime;
    Date createDt;
    Date updateDt;
}

package com.st11.dbshowapi.repository.sql;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;


@Data
@EqualsAndHashCode(callSuper=false)
public class SqlIdVO extends SqlNameStatsVO {
    int dbId;
    long sqlNameNo;
    String sqlName;
    String sqlId;
    String parsingSchemaName;
    String module;
    String owner;
    String tableName;
    String programId;
    Date LastActiveTime;
    Date createDt;
    Date updateDt;
}

package com.st11.dbshowapi.repository.sql;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class SqlNameMappVO {
    private String clctDy;
    private String partCd;
    private int dbId;
    private long sqlNameNo;
    private String sqlName;
    private String sqlId;
    private int rnk;
    private int instId;
    private String sqlText;
    private String module;
    private Timestamp lastActiveTime;
    private long executions;
    private long bufferGets;
    private long elapsedTime;
    private long diskReads;
    private long commandType;
    private String parsingSchemaName;
    private long cpuTime;
    private String repSqlId;
}

package com.st11.dbshowapi.repository.sql;

import lombok.Data;

@Data
public class SqlAreaVO {
    private int instId;
    private String sqlId;
    private String planHashValue;
    private String parsingSchemaName;
    private String module;
    private String programId;
    private String executions;
    private String bufferGets;
    private String rowsProcessed;
    private String cpuTime;
    private String elapsedTime;
    private String blockPerExec;
    private String lastActiveTime;
    private String firstLoadTime;
    private String commandType;
    private String sqlName;
    private String sqlNameNo;
    private String sqlText;
    private String sqlFullText;
}

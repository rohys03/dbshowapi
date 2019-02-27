package com.st11.dbshowapi.repository.sql;

import lombok.Data;

import java.sql.Date;

@Data
public class TopSqlVO {
    private Date histDt;
    private int instId;
    private String schema;
    private String sqlId;
    private String module;
    private String service;
    private String firstLoadTime;
    private long bgetsRank;
    private long cpuRank;
    private long elapRank;
    private long execRank;
    private long diskReadRank;
    private long bgetsRatio;
    private long cpuRatio;
    private long elapRatio;
    private long execRatio;
    private long diskReadRatio;
    private long executions;
    private long bgets;
    private long diskRead;
    private long elapTime;
    private long cpuTime;
    private String sqlText;
}

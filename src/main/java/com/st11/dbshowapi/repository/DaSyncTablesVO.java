package com.st11.dbshowapi.repository;

import lombok.Data;

import java.sql.Date;

@Data
public class DaSyncTablesVO {
    private String sourceDb;
    private String tableOwner;
    private String tableName;
    private String targetDb;
    private String hostname;
    private Date updateDt;
}

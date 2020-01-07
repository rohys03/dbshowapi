package com.st11.dbshowapi.repository.object;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DaSyncTableVO {
    private String sourceDb;
    private String owner;
    private String tableName;
    private String targetDb;
    private String hostname;
    private Timestamp updateDt;
}

package com.st11.dbshowapi.repository.object;

import lombok.Data;

import java.sql.Date;

@Data
public class DaSyncTableVO {
    private String sourceDb;
    private String tableOwner;
    private String tableName;
    private String targetDb;
    private String hostname;
    private Date updateDt;
}

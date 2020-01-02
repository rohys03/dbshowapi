package com.st11.dbshowapi.repository.dbshowapi;

import lombok.Data;

@Data
public class DaStatMngAllVO {
    private String dbId;
    private String dbNm;
    private String daSqlFullText;
    private String daSqlarea;
    private String daObjects;
    private String daSyncTables;
    private String daSqlnameDtlInfo;
    private String daSqlnameList;
    private String daSqlnameMapp;
}

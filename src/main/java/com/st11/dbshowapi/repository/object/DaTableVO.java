package com.st11.dbshowapi.repository.object;

import lombok.Data;

@Data
public class DaTableVO {
    private String dbName;
    private String dbId;
    private String tableOwner;
    private String tableName;
    private String logicalAreaCd1;
    private String logicalAreaCd2;
    private String physicalAreaCd1;
    private String tableComments;
    private String tableCreateDt;
    private String standardObjectYn;
}

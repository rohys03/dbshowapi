package com.st11.dbshowapi.repository.object;

import lombok.Data;

@Data
public class DaTableVO {
    private String dbName;
    private String dbId;
    private String owner;
    private String tableName;
    private String logicalAreaCd;
    private String logicalAreaCd2;
    private String physicalAreaCd;
    private String tableComments;
    private String tableCreateDt;
    private String standardObjectYn;
    private String subjAreaCd;
}

package com.st11.dbshowapi.repository.dam;

import lombok.Data;

@Data
public class DamEntityVO {

    private String subjFieldId;
    private String modelId;
    private String tableName;
    private String entityName;
    private String entityShareType;
    private String entityStandardType;
    private String entityType;
    private String subjAreaNamePath;
    private String modifyDt;

}

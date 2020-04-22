package com.st11.dbshowapi.repository.object;

import lombok.Data;
import java.sql.Timestamp;

@Data
public class DaDamTabColsVO {

    private String tableName;
    private String entityName;
    private String columnName;
    private String attributeName;
    private String seq;
    private String securityYn;

    private String structName;
    private String modelId;
    private String subjFieldId;

    private Timestamp createDt;
    private Timestamp updateDt;
}

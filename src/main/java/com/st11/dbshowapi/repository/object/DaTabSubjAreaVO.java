package com.st11.dbshowapi.repository.object;

import lombok.Data;

import java.util.Date;

@Data
public class DaTabSubjAreaVO {
    private String subjAreaCd;
    private String subjAreaName;
    private String subjAreaEngName;
    private String hgrnkSubjAreaCd;
    private String phsclSubjAreaCd;
    private String phsclSubjAreaName;
    private Integer areaDepth;
    private String subjAreaDesc;
    private String useYn;
    private Date createDt;

    private String logicalAreaCd;
    private String logicalAreaCd2;

    private Integer tableCount;
    private Integer sqlCount;
}

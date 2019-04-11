package com.st11.dbshowapi.repository.dbshowapi;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DaStatMngVO {

    private String dbNm;
    private String statNm;
    private String clctDy;
    private String clctRsltCd;
    private String partCd;
    private Timestamp createDt;
    private Timestamp updateDt;

}

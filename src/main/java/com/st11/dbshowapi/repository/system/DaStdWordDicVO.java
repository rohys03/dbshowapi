package com.st11.dbshowapi.repository.system;

import lombok.Data;

import java.util.Date;

@Data
public class DaStdWordDicVO {
    int wordNo;
    String WordClfNm;
    String basiWordNm;
    String engWordNm;
    String engAbrvtNm;
    String wordDesc;
    String subjAreaNm;
    String useYn;
    Date createDt;

}

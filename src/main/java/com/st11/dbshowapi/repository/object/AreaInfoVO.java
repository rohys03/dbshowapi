package com.st11.dbshowapi.repository.object;

import lombok.Data;

@Data
public class AreaInfoVO {
    private String areaCd1;
    private String areaCd2;
    private String allInstanceCnt;
    private String db1Cnt;
    private String db2Cnt;
    private String db3Cnt;
    private String otherInstanceCnt;
}

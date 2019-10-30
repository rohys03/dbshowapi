package com.st11.dbshowapi.repository.sql;

import lombok.Data;

@Data
public class SqlAreaDiffVO extends SqlAreaVO {

    private String rank;
    private String rank2;
    private String executions2;
    private String bufferGets2;
    private String rowsProcessed2;
    private String cpuTime2;
    private String elapsedTime2;
    private String statRatio;
    private String objectNm;

}

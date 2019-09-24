package com.st11.dbshowapi.repository.system;

import lombok.Data;

@Data
public class DbKpiStatVO {
    /*
        db1 : Maindb;
        db2 : Dpdb;
        db3 : Mpdb;
        db4 : Cartdb;
        db5 : Prmtdb;
     */

    private String clctMon;
    private String clctWk;
    private String clctMonthWeek;
    private String clctDy;
    private String bgnClctDy;
    private String endClctDy;

    private int db1SqlCnt;
    private int db2SqlCnt;
    private int db3SqlCnt;
    private int db4SqlCnt;
    private int db5SqlCnt;

    private double db1ExecutionRt;
    private double db2ExecutionRt;
    private double db3ExecutionRt;
    private double db4ExecutionRt;
    private double db5ExecutionRt;

    private double db1BufferGetRt;
    private double db2BufferGetRt;
    private double db3BufferGetRt;
    private double db4BufferGetRt;
    private double db5BufferGetRt;

    private double db1CpuTimeRt;
    private double db2CpuTimeRt;
    private double db3CpuTimeRt;
    private double db4CpuTimeRt;
    private double db5CpuTimeRt;

    private double db1ElapseTimeRt;
    private double db2ElapseTimeRt;
    private double db3ElapseTimeRt;
    private double db4ElapseTimeRt;
    private double db5ElapseTimeRt;

}

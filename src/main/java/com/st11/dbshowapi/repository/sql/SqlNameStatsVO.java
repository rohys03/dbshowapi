package com.st11.dbshowapi.repository.sql;

import lombok.Data;

import java.util.Date;

@Data
public class SqlNameStatsVO {
    String clctDy;
    int dbId;
    long sqlNameNo;
    long currTotalExec;
    long prevTotalExec;
    long execDiff;
    long currTotalBget;
    long prevTotalBget;
    long bgetDiff;
    long currTotalCpu;
    long prevTotalCpu;
    long cpuDiff;
    long currTotalElap;
    long prevTotalElap;
    long elapDiff;
    long currClctDy;
    long prevClctDy;
    Date createDt;
}

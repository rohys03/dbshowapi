package com.st11.dbshowapi.repository.system;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

import java.util.List;

@Repository
@Mapper
@Resource(name="dadbSessionFactory")
public interface DbKpiStatMapper {

    String SELECT_VW_DB_KPI_STATS_WEEKLY =
            "SELECT * FROM ( SELECT * FROM DAUSER.VW_DB_KPI_STATS_WEEKLY" +
                    " ORDER BY CLCT_MON DESC, CLCT_WK DESC ) WHERE ROWNUM <= #{row}";
    String SELECT_VW_DB_KPI_STATS_DAILY =
            "SELECT * FROM ( SELECT * FROM DAUSER.VW_DB_KPI_STATS_DAILY" +
                    " ORDER BY CLCT_DY DESC ) WHERE ROWNUM <= #{row}";

    @Select(SELECT_VW_DB_KPI_STATS_WEEKLY)
    @Results(value = {
            @Result(property="clctMon", column="clct_mon"),
            @Result(property="clctWk", column="clct_Wk"),
            @Result(property="clctMonthWeek", column="clct_MonWk"),
            @Result(property="bgnClctDy", column="bgn_Clct_Dy"),
            @Result(property="endClctDy", column="end_Clct_Dy"),

            @Result(property="db1SqlCnt", column="maindb_sql_cnt"),
            @Result(property="db2SqlCnt", column="dpdb_sql_cnt"),
            @Result(property="db3SqlCnt", column="mpdb_sql_cnt"),
            @Result(property="db4SqlCnt", column="cartdb_sql_cnt"),
            @Result(property="db5SqlCnt", column="prmtdb_sql_cnt"),

            @Result(property="db1ExecutionRt", column="maindb_exec_rt"),
            @Result(property="db2ExecutionRt", column="dpdb_exec_rt"),
            @Result(property="db3ExecutionRt", column="mpdb_exec_rt"),
            @Result(property="db4ExecutionRt", column="cartdb_exec_rt"),
            @Result(property="db5ExecutionRt", column="prmtdb_exec_rt"),

            @Result(property="db1BufferGetRt", column="maindb_bget_Rt"),
            @Result(property="db2BufferGetRt", column="dpdb_bget_Rt"),
            @Result(property="db3BufferGetRt", column="mpdb_bget_Rt"),
            @Result(property="db4BufferGetRt", column="cartdb_bget_Rt"),
            @Result(property="db5BufferGetRt", column="prmtdb_bget_Rt"),

            @Result(property="db1CpuTimeRt", column="maindb_cpu_Rt"),
            @Result(property="db2CpuTimeRt", column="dpdb_cpu_Rt"),
            @Result(property="db3CpuTimeRt", column="mpdb_cpu_Rt"),
            @Result(property="db4CpuTimeRt", column="cartdb_cpu_Rt"),
            @Result(property="db5CpuTimeRt", column="prmtdb_cpu_Rt"),

            @Result(property="db1ElapseTimeRt", column="maindb_ela_Rt"),
            @Result(property="db2ElapseTimeRt", column="dpdb_ela_Rt"),
            @Result(property="db3ElapseTimeRt", column="mpdb_ela_Rt"),
            @Result(property="db4ElapseTimeRt", column="cartdb_ela_Rt"),
            @Result(property="db5ElapseTimeRt", column="prmtdb_ela_Rt")
    })
    List<DbKpiStatVO> getDbKpiStatsWeekly(@Param("row") int page);

    @Select(SELECT_VW_DB_KPI_STATS_DAILY)
    @Results(value = {
            @Result(property="clctDy", column="clct_dy"),

            @Result(property="db1SqlCnt", column="maindb_sql_cnt"),
            @Result(property="db2SqlCnt", column="dpdb_sql_cnt"),
            @Result(property="db3SqlCnt", column="mpdb_sql_cnt"),
            @Result(property="db4SqlCnt", column="cartdb_sql_cnt"),
            @Result(property="db5SqlCnt", column="prmtdb_sql_cnt"),

            @Result(property="db1ExecutionRt", column="maindb_exec_rt"),
            @Result(property="db2ExecutionRt", column="dpdb_exec_rt"),
            @Result(property="db3ExecutionRt", column="mpdb_exec_rt"),
            @Result(property="db4ExecutionRt", column="cartdb_exec_rt"),
            @Result(property="db5ExecutionRt", column="prmtdb_exec_rt"),

            @Result(property="db1BufferGetRt", column="maindb_bget_Rt"),
            @Result(property="db2BufferGetRt", column="dpdb_bget_Rt"),
            @Result(property="db3BufferGetRt", column="mpdb_bget_Rt"),
            @Result(property="db4BufferGetRt", column="cartdb_bget_Rt"),
            @Result(property="db5BufferGetRt", column="prmtdb_bget_Rt"),

            @Result(property="db1CpuTimeRt", column="maindb_cpu_Rt"),
            @Result(property="db2CpuTimeRt", column="dpdb_cpu_Rt"),
            @Result(property="db3CpuTimeRt", column="mpdb_cpu_Rt"),
            @Result(property="db4CpuTimeRt", column="cartdb_cpu_Rt"),
            @Result(property="db5CpuTimeRt", column="prmtdb_cpu_Rt"),

            @Result(property="db1ElapseTimeRt", column="maindb_ela_Rt"),
            @Result(property="db2ElapseTimeRt", column="dpdb_ela_Rt"),
            @Result(property="db3ElapseTimeRt", column="mpdb_ela_Rt"),
            @Result(property="db4ElapseTimeRt", column="cartdb_ela_Rt"),
            @Result(property="db5ElapseTimeRt", column="prmtdb_ela_Rt")
    })
    List<DbKpiStatVO> getDbKpiStatsDaily(@Param("row") int page);

}

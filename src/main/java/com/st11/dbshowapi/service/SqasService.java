package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.sql.*;

import java.util.HashMap;
import java.util.List;

public interface SqasService {
    List<SqlAreaVO> getSqlAreaListAll();
    List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inParam);

    List<SqlAreaVO> getSqlAreaDetail(HashMap<String, Object> inParam);

    List<TopSqlVO> getTopSqlList(HashMap<String, Object> inParam);

    List<SqlNameVO> getSqlName(HashMap<String, Object> inParam);
    List<SqlNameVO> getSqlNameList(HashMap<String, Object> inParam);
    List<SqlNameStatsVO> getSqlNameStats(HashMap<String, Object> inParam);
    List<SqlNameStatsVO> getSqlNameStatsHist(HashMap<String, Object> inParam);

    List<SqlNameMappVO> getSqlNameMapp(HashMap<String, Object> inParam);
    List<SqlNameMappVO> getSqlNameMappSummary(HashMap<String, Object> inParam);
}

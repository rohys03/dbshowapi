package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.sql.SqlAreaVO;
import com.st11.dbshowapi.repository.sql.SqlNameStatsVO;
import com.st11.dbshowapi.repository.sql.SqlNameVO;
import com.st11.dbshowapi.repository.sql.TopSqlVO;

import java.util.HashMap;
import java.util.List;

public interface SqasService {
    List<SqlAreaVO> getSqlAreaListAll();
    List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inParam);

    List<SqlAreaVO> getSqlAreaDetail(HashMap<String, Object> inParam);

    List<TopSqlVO> getTopSqlList(HashMap<String, Object> inParam);

    List<SqlNameVO> getSqlName(HashMap<String, Object> inParam);
    List<SqlNameStatsVO> getSqlNameStats(HashMap<String, Object> inParam);
}

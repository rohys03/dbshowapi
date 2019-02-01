package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.SqlAreaVO;
import com.st11.dbshowapi.repository.TopSqlVO;

import java.util.HashMap;
import java.util.List;

public interface SqasService {
    List<SqlAreaVO> getSqlAreaListAll();
    List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inParam);

    List<SqlAreaVO> getSqlAreaDetail(HashMap<String, Object> inParam);

    List<TopSqlVO> getTopSqlList(HashMap<String, Object> inParam);
}

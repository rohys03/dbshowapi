package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.SqlAreaVO;

import java.util.HashMap;
import java.util.List;

public interface SqasService {
    List<SqlAreaVO> getSqlAreaListAll();
    List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inParam);
}

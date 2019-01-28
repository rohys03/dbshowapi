package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.RefObjectVO;
import com.st11.dbshowapi.repository.SqlAreaVO;

import java.util.HashMap;
import java.util.List;

public interface SystemInfoService {

    List<RefObjectVO> getRefObjectList(HashMap<String, Object> inparam);
}

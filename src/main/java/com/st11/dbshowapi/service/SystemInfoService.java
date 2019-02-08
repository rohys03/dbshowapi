package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.DaSyncTablesVO;
import com.st11.dbshowapi.repository.RefObjectVO;

import java.util.HashMap;
import java.util.List;

public interface SystemInfoService {

    List<RefObjectVO> getRefObjectList(HashMap<String, Object> inparam);

    List<DaSyncTablesVO> getSyncTableList(HashMap<String, Object> inparam);
}

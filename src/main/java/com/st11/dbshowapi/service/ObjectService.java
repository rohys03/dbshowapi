package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.object.AreaInfoVO;
import com.st11.dbshowapi.repository.object.DaSyncTableVO;
import com.st11.dbshowapi.repository.object.DaTableVO;
import com.st11.dbshowapi.repository.object.RefObjectVO;

import java.util.HashMap;
import java.util.List;

public interface ObjectService {

    List<RefObjectVO> getRefObjectList(HashMap<String, Object> inparam);

    List<DaSyncTableVO> getSyncTableList(HashMap<String, Object> inparam);

    List<DaTableVO> getTableList(HashMap<String, Object> inparam);

    List<AreaInfoVO> getAreaCdList(HashMap<String, Object> inparam);
}

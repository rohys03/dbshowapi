package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.object.AreaInfoVO;
import com.st11.dbshowapi.repository.object.DaSyncTableVO;
import com.st11.dbshowapi.repository.object.DaTabSubjAreaVO;
import com.st11.dbshowapi.repository.object.DaTableVO;

import java.util.HashMap;
import java.util.List;

public interface ObjectService {


    List<DaSyncTableVO> getSyncTableList(HashMap<String, Object> inparam);

    List<DaTableVO> getTableList(HashMap<String, Object> inparam);

    List<AreaInfoVO> getAreaCdList(HashMap<String, Object> inparam);

    List<DaTabSubjAreaVO> getDaTabSubjAreaList(HashMap<String, Object> inparam);
}

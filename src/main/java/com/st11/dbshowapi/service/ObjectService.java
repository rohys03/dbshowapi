package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.object.*;

import java.util.HashMap;
import java.util.List;

public interface ObjectService {

    List<DaSyncTableVO> getSyncTableList(HashMap<String, Object> inparam);

    List<DaTableVO> getTableList(HashMap<String, Object> inparam);
    DaTableVO getDaTabModification(HashMap<String, Object> inparam);

    List<AreaInfoVO> getAreaCdList(HashMap<String, Object> inparam);

    List<DaTabSubjAreaVO> getDaTabSubjAreaList(HashMap<String, Object> inparam);

    List<DaDamTabColsVO> getDaDamTabColumns(HashMap<String, Object> inparam);
}

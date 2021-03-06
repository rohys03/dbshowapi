package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.object.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ObjectServiceImpl implements ObjectService {

    @Autowired
    DaObjectMapper daObjectMapper;

    @Override
    public List<DaSyncTableVO> getSyncTableList(HashMap<String, Object> inparam) {
        return daObjectMapper.getSyncTableList(inparam);
    }

    @Override
    public List<DaTableVO> getTableList(HashMap<String, Object> inparam) {
        return daObjectMapper.getTableList(inparam);
    }

    @Override
    public DaTableVO getDaTabModification(HashMap<String, Object> inparam) {
        return daObjectMapper.getDaTabModification(inparam);
    }

    @Override
    public List<AreaInfoVO> getAreaCdList(HashMap<String, Object> inparam) {
        return daObjectMapper.getAreaCdList(inparam);
    }

    @Override
    public List<DaTabSubjAreaVO> getDaTabSubjAreaList(HashMap<String, Object> inparam) {
        return daObjectMapper.getDaTabSubjAreaList(inparam);
    }

    @Override
    public List<DaDamTabColsVO> getDaDamTabColumns(HashMap<String, Object> inparam) {
        return daObjectMapper.getDaDamTabColumns(inparam);
    }

}

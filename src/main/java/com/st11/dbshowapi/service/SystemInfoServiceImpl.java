package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.object.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Autowired
    DaObjectMapper daTableMapper;

    @Override
    public List<RefObjectVO> getRefObjectList(HashMap<String, Object> inparam) {
        return daTableMapper.getRefObjectList(inparam);
    }
    @Override
    public List<DaSyncTableVO> getSyncTableList(HashMap<String, Object> inparam) {
        return daTableMapper.getSyncTableList(inparam);
    }

    @Override
    public List<DaTableVO> getTableList(HashMap<String, Object> inparam) {
        return daTableMapper.getTableList(inparam);
    }
}

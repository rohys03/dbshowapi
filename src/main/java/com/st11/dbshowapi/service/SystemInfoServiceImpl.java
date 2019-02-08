package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.DaSyncTablesMapper;
import com.st11.dbshowapi.repository.DaSyncTablesVO;
import com.st11.dbshowapi.repository.RefObjectMapper;
import com.st11.dbshowapi.repository.RefObjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SystemInfoServiceImpl implements SystemInfoService {

    @Autowired
    RefObjectMapper refObjectMapper;

    @Autowired
    DaSyncTablesMapper daSyncTablesMapper;

    @Override
    public List<RefObjectVO> getRefObjectList(HashMap<String, Object> inparam) {
        return refObjectMapper.getRefObjectList(inparam);
    }
    @Override
    public List<DaSyncTablesVO> getSyncTableList(HashMap<String, Object> inparam) {
        return daSyncTablesMapper.getSyncTableList(inparam);
    }

}

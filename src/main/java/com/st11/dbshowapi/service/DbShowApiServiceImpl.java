package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dbshowapi.DaStatMngVO;
import com.st11.dbshowapi.repository.dbshowapi.DbShowApiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DbShowApiServiceImpl implements DbShowApiService {

    @Autowired
    DbShowApiMapper dbShowApiMapper;

    @Override
    public List<DaStatMngVO> getDaStatMngList (HashMap<String, Object> inParam) {
        return dbShowApiMapper.getDaStatMngList(inParam);
    }

    @Override
    public List<DaStatMngVO> getLastDaStatMng(String dbName, String statName) {
        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("dbName", dbName);
        inParam.put("statName", statName);
        return dbShowApiMapper.getLastDaStatMng(inParam);
    }


    @Override
    public DaStatMngVO getLastDaStatMng2(String dbName, String statName) {
        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("dbName", dbName);
        inParam.put("statName", statName);
        return dbShowApiMapper.getLastDaStatMng2(inParam);
    }

}

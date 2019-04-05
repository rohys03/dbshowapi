package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dbshowapi.DbShowApiMapper;
import com.st11.dbshowapi.repository.sql.*;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SqasServiceImpl implements SqasService {

    @Autowired
    DaSqlMapper daSqlMapper;

    @Autowired
    DbShowApiMapper dbShowApiMapper;

    @Override
    public List<SqlAreaVO> getSqlAreaListAll() {
        return daSqlMapper.getSqlAreaListAll();
    }

    @Override
    public List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inParam) {
//        System.out.println("/sqasServiceImpl/owner:"+ owner + "/name:" + name + "/commandType:" + commandType);
        return daSqlMapper.getSqlAreaList(inParam);
    }

    @Override
    public List<SqlAreaVO> getSqlAreaDetail(HashMap<String, Object> inParam) {
//        System.out.println("/sqasServiceImpl/owner:"+ owner + "/name:" + name + "/commandType:" + commandType);
        return daSqlMapper.getSqlAreaDetail(inParam);
    }

    @Override
    public List<TopSqlVO> getTopSqlList(HashMap<String, Object> inParam) {
        return daSqlMapper.getTopSqlList(inParam);
    }


    @Override
    public List<SqlNameVO> getSqlName(HashMap<String, Object> inParam) {
        if (!inParam.containsKey("clctDy")) inParam.put("clctDy", dbShowApiMapper.getMaxClctDyByStatName("TMALL", "DA_DB_STAT"));
        System.out.println("[getSqlName]" + inParam.toString());

        return daSqlMapper.getSqlName(inParam);
    }

    @Override
    public List<SqlNameStatsVO> getSqlNameStats(HashMap<String, Object> inParam) {

        return daSqlMapper.getSqlNameStats(inParam);
    }
}

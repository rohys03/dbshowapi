package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.SqlAreaMapper;
import com.st11.dbshowapi.repository.SqlAreaVO;
import com.st11.dbshowapi.repository.TopSqlMapper;
import com.st11.dbshowapi.repository.TopSqlVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SqasServiceImpl implements SqasService {

    @Autowired
    SqlAreaMapper sqlAreaMapper;

    @Autowired
    TopSqlMapper topSqlMapper;

    @Override
    public List<SqlAreaVO> getSqlAreaListAll() {
        return sqlAreaMapper.getSqlAreaListAll();
    }

    @Override
    public List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inParam) {
//        System.out.println("/sqasServiceImpl/owner:"+ owner + "/name:" + name + "/commandType:" + commandType);
        return sqlAreaMapper.getSqlAreaList(inParam);
    }

    @Override
    public List<SqlAreaVO> getSqlAreaDetail(HashMap<String, Object> inParam) {
//        System.out.println("/sqasServiceImpl/owner:"+ owner + "/name:" + name + "/commandType:" + commandType);
        return sqlAreaMapper.getSqlAreaDetail(inParam);
    }

    @Override
    public List<TopSqlVO> getTopSqlList(HashMap<String, Object> inParam) {
        return topSqlMapper.getTopSqlList(inParam);
    }
}

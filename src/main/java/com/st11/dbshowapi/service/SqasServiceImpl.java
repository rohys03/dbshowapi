package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.SqlAreaMapper;
import com.st11.dbshowapi.repository.SqlAreaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SqasServiceImpl implements SqasService {

    @Autowired
    SqlAreaMapper sqlAreaMapper;

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

}

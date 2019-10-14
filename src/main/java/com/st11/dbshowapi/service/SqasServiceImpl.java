package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.sql.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class SqasServiceImpl implements SqasService {

    @Autowired
    DaSqlMapper daSqlMapper;


    @Autowired
    DbShowApiService dbShowApiService;

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

//    @Override
//    public List<TopSqlVO> getTopSqlList(HashMap<String, Object> inParam) {
//        return daSqlMapper.getTopSqlList(inParam);
//    }


    @Override
    public List<SqlNameVO> getSqlNameList(HashMap<String, Object> inParam) {
//        System.out.println("[getSqlName1]" + inParam.toString());
        if (!inParam.containsKey("clctDy")) inParam.put("clctDy", dbShowApiService.getLastDaStatMng("TMALL", "DA_DB_STATS").get(0).getClctDy());

        return daSqlMapper.getSqlNameList(inParam);
    }
    @Override
    public List<SqlNameVO> getSqlName(HashMap<String, Object> inParam) {
        return daSqlMapper.getSqlName(inParam);
    }

    @Override
    public List<SqlNameStatsVO> getSqlNameStats(HashMap<String, Object> inParam) {

        return daSqlMapper.getSqlNameStats(inParam);
    }
    @Override
    public List<SqlNameStatsVO> getSqlNameStatsHist(HashMap<String, Object> inParam) {

        return daSqlMapper.getSqlNameStatsHist(inParam);
    }


    @Override
    public List<SqlNameMappVO> getSqlNameMapp(HashMap<String, Object> inParam){
        return daSqlMapper.getSqlNameMapp(inParam);
    }

    @Override
    public SqlNameMappVO getSqlNameMappSummary(HashMap<String, Object> inParam){
        if (!inParam.containsKey("clctDy")) {
            String clctDy = dbShowApiService.getLastDaStatMng("PMETA", "DA_SQLNAME_MAPP").get(0).getClctDy();
            inParam.put("clctDy", clctDy);
            inParam.put("partCd", clctDy.substring(6,8));
        }
        return daSqlMapper.getSqlNameMappSummary(inParam);
    }

    @Override
    public List<SqlAreaDiffVO> getTopSqlDayList(HashMap<String, Object> inParam) {
        return daSqlMapper.getTopSqlDayList(inParam);
    }

}

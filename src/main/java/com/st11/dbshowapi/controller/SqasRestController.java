package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.sql.SqlAreaVO;
import com.st11.dbshowapi.repository.sql.TopSqlVO;
import com.st11.dbshowapi.service.SqasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
public class SqasRestController {

    @Autowired
    SqasService sqasService;

    @RequestMapping(value = {"sqlApplicationList/{dbName}/{commandType}/{owner}/{tableName}"})
    public List<SqlAreaVO> sqlApplicationList(
            @PathVariable final String dbName, @PathVariable final String commandType,
            @PathVariable final String owner, @PathVariable final String tableName) {

        List<SqlAreaVO> sqlareaList = null;
        System.out.println("/api/sqlListByObject/owner:"+ owner + "/name:" + tableName + "/commandType:" + commandType);

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("owner", owner);
        inParam.put("name", tableName);
        inParam.put("commandType", commandType);

        if (tableName != null && owner != null) {
            sqlareaList = sqasService.getSqlAreaList(inParam);
        } else {
            sqlareaList = sqasService.getSqlAreaListAll();
        }

        return sqlareaList;
    }

    @RequestMapping(value = {"sqlDetail/{dbName}/{searchType}/{searchString}"})
    public List<SqlAreaVO> sqlDetail(
            @PathVariable final String dbName, @PathVariable final String searchType,
            @PathVariable final String searchString) {
        System.out.println("/api/sqlDetail/dbName:"+ dbName + "/searchType:" + searchType + "/searchString:" + searchString);

        List<SqlAreaVO> sqlAreaDetail = null;

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("dbName", dbName);
        inParam.put("searchType", searchType);
        inParam.put("searchString", searchString);

        System.out.println("inparam1: " + inParam.toString());

        if (searchType != null && searchString != null) {
            sqlAreaDetail = sqasService.getSqlAreaDetail(inParam);
            System.out.println("inparam3: " + inParam.toString() + " sqlId: " + sqlAreaDetail.size());
        } else {
            return null;
        }

        return sqlAreaDetail;
    }
    @RequestMapping(value = {"topSqlList/{dbName}/{instId}/{date}/{orderColumn}"})
    public List<TopSqlVO> topSqlList(
            @PathVariable final String dbName, @PathVariable final String instId,
            @PathVariable final String date, @PathVariable final String orderColumn) {
        System.out.println("/api/topSqlList/dbName:"+ dbName + "/instId:" + instId + "/date:" + date + "/orderColumn:" + orderColumn);

        List<TopSqlVO> topsqlList = null;

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("dbName", dbName);
        inParam.put("instId", instId);
        inParam.put("date", date);
        inParam.put("orderColumn", orderColumn);

        System.out.println("inparam1: " + inParam.toString());

        if (dbName != null && instId != null) {
            topsqlList = sqasService.getTopSqlList(inParam);
            System.out.println("inparam2: " + inParam.toString() + " listSize: " + topsqlList.size());
        } else {
            return null;
        }

        return topsqlList;
    }
}

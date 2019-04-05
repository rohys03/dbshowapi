package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.object.DaTableVO;
import com.st11.dbshowapi.repository.sql.SqlAreaVO;
import com.st11.dbshowapi.repository.sql.SqlNameStatsVO;
import com.st11.dbshowapi.repository.sql.SqlNameVO;
import com.st11.dbshowapi.repository.sql.TopSqlVO;
import com.st11.dbshowapi.service.SqasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = {"topSqlList"})
    public List<TopSqlVO> topSqlList(
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "instId", required = false) final String instId,
            @RequestParam(value = "clctDy") final String clctDy,
            @RequestParam(value = "orderColumn") final String orderColumn) {
        System.out.println("/api/topSqlList/dbName:"+ dbName + "/instId:" + instId + "/clctDy:" + clctDy + "/orderColumn:" + orderColumn);

        List<TopSqlVO> topsqlList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbName != null) inParam.put("dbName", dbName);
        if (instId != null) inParam.put("instId", instId);
        if (clctDy != null) inParam.put("clctDy", clctDy);
        if (orderColumn != null) inParam.put("orderColumn", orderColumn);

        System.out.println("inparam1: " + inParam.toString());
        topsqlList = sqasService.getTopSqlList(inParam);
        System.out.println("inparam2: " + inParam.toString() + " listSize: " + topsqlList.size());

        return topsqlList;
    }

    @GetMapping(value = {"sqlNameStats"})
    public List<SqlNameStatsVO> sqlNameStats(
            @RequestParam(value = "clctDy", required = false) final String clctDy,
            @RequestParam(value = "sqlName") final String sqlName) {

        List<SqlNameStatsVO> sqlNameStatsVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (clctDy != null) inParam.put("clctDy", clctDy);
        if (sqlName != null) inParam.put("sqlName", sqlName);

        System.out.println("/api/sqlNameStats/:" + inParam.toString());
        sqlNameStatsVOList = sqasService.getSqlNameStats(inParam);

        return sqlNameStatsVOList;
    }

    @GetMapping(value = {"sqlName"})
    public List<SqlNameVO> sqlName(
            @RequestParam(value = "clctDy") final String clctDy,
            @RequestParam(value = "sqlName", required = false) final String sqlName,
            @RequestParam(value = "logicalAreaCd1", required = false) final String logicalAreaCd1,
            @RequestParam(value = "logicalAreaCd2", required = false) final String logicalAreaCd2) {

        List<SqlNameVO> sqlNameVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (clctDy != null) inParam.put("clctDy", clctDy);
        if (sqlName != null) inParam.put("sqlName", sqlName);
        if (logicalAreaCd1 != null) inParam.put("logicalAreaCd1", logicalAreaCd1);
        if (logicalAreaCd2 != null) inParam.put("logicalAreaCd2", logicalAreaCd2);

        System.out.println("/api/daTables/:" + inParam.toString());
        sqlNameVOList = sqasService.getSqlName(inParam);

        return sqlNameVOList;
    }

}

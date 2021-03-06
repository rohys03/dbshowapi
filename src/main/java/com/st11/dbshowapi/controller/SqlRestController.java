package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.sql.*;
import com.st11.dbshowapi.service.SqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

import static com.st11.dbshowapi.common.Dbshow.isNullOrEmpty;

@RestController
@RequestMapping("api")
public class SqlRestController {

    @Autowired
    SqlService sqlService;

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
            sqlareaList = sqlService.getSqlAreaList(inParam);
        } else {
            sqlareaList = sqlService.getSqlAreaListAll();
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
            sqlAreaDetail = sqlService.getSqlAreaDetail(inParam);
            System.out.println("inparam3: " + inParam.toString() + " sqlId: " + sqlAreaDetail.size());
        } else {
            return null;
        }

        return sqlAreaDetail;
    }


    @GetMapping(value = {"sqlIdList"})
    public List<SqlIdVO> sqlIdList(
            @RequestParam(value = "clctDy", required = false) final String clctDy,
            @RequestParam(value = "owner", required = false) final String owner,
            @RequestParam(value = "tableName", required = false) final String tableName,
            @RequestParam(value = "sqlId", required = false) final String sqlId
    ) {

        List<SqlIdVO> sqlIdVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (clctDy != null) inParam.put("clctDy", clctDy);
        if (owner != null) inParam.put("owner", owner);
        if (tableName != null) inParam.put("tableName", tableName);
        if (sqlId != null) inParam.put("sqlId", sqlId);

        System.out.println("/api/sqlIdList/:" + inParam.toString());
        sqlIdVOList = sqlService.getSqlIdList(inParam);

        return sqlIdVOList;
    }

    @GetMapping(value = {"sqlNameList"})
    public List<SqlNameVO> sqlNameList(
            @RequestParam(value = "clctDy", required = false) final String clctDy,
            @RequestParam(value = "owner", required = false) final String owner,
            @RequestParam(value = "tableName", required = false) final String tableName,
            @RequestParam(value = "sqlName", required = false) final String sqlName,
//            @RequestParam(value = "logicalAreaCd", required = false) final String logicalAreaCd,
//            @RequestParam(value = "logicalAreaCd2", required = false) final String logicalAreaCd2,
            @RequestParam(value = "subjAreaCd", required = false) final String subjAreaCd
    ) {

        List<SqlNameVO> sqlNameVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (clctDy != null) inParam.put("clctDy", clctDy);
        if (owner != null) inParam.put("owner", owner);
        if (tableName != null) inParam.put("tableName", tableName);
        if (sqlName != null) inParam.put("sqlName", sqlName);
//        if (logicalAreaCd != null) inParam.put("logicalAreaCd", logicalAreaCd);
//        if (logicalAreaCd2 != null) inParam.put("logicalAreaCd2", logicalAreaCd2);
        if (subjAreaCd != null) inParam.put("subjAreaCd", subjAreaCd);

        System.out.println("/api/sqlNameList/:" + inParam.toString());
        sqlNameVOList = sqlService.getSqlNameList(inParam);

        return sqlNameVOList;
    }

    @GetMapping(value = {"sqlName"})
    public List<SqlNameVO> sqlName(
            @RequestParam(value = "dbId", required = false) final int dbId,
            @RequestParam(value = "sqlNameNo", required = false) final long sqlNameNo,
            @RequestParam(value = "sqlName", required = false) final String sqlName) {

        List<SqlNameVO> sqlNameVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbId > 0) inParam.put("dbId", dbId);
        if (sqlNameNo > 0) inParam.put("sqlNameNo", sqlNameNo);
        if (sqlName != null) inParam.put("sqlName", sqlName);

        System.out.println("/api/sqlName/:" + inParam.toString());
        if (!inParam.isEmpty()) {
            sqlNameVOList = sqlService.getSqlName(inParam);
        }

        return sqlNameVOList;
    }

    @GetMapping(value = {"sqlNameStatsHist"})
    public List<SqlNameStatsVO> sqlNameStatsHist(
            @RequestParam(value = "clctDy") final String clctDy,
            @RequestParam(value = "dbId", required = false) final String dbId,
            @RequestParam(value = "sqlName", required = false) final String sqlName,
            @RequestParam(value = "sqlNameNo", required = false) final String sqlNameNo) {

        List<SqlNameStatsVO> sqlNameStatsVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (clctDy != null) inParam.put("clctDy", clctDy);
        if (dbId != null) inParam.put("dbId", dbId);
        if (sqlName != null) inParam.put("sqlName", sqlName);
        if (sqlNameNo != null) inParam.put("sqlNameNo", sqlNameNo);

        System.out.println("/api/sqlNameStatsHist/:" + inParam.toString());
        if (!inParam.isEmpty()) {
            sqlNameStatsVOList = sqlService.getSqlNameStatsHist(inParam);
        }
        System.out.println("sqlNameStatsVOList2: " + sqlNameStatsVOList.toString());

        return sqlNameStatsVOList;
    }

    @GetMapping(value = {"sqlNameMappSummary"})
    public SqlNameMappVO sqlNameMappSummary (
            @RequestParam(value = "clctDy", required = false) final String clctDy,
            @RequestParam(value = "dbId", required = false) final String dbId,
            @RequestParam(value = "sqlName", required = false) final String sqlName,
            @RequestParam(value = "sqlNameNo", required = false) final String sqlNameNo) {

//        List<SqlNameMappVO> SqlNameMappVOList = null;
        SqlNameMappVO sqlNameMappVO = new SqlNameMappVO();

        HashMap<String, Object> inParam = new HashMap<>();

        if (!isNullOrEmpty(clctDy)) {
            inParam.put("clctDy", clctDy);
            inParam.put("partCd", clctDy.substring(6,8));
        }
        if (dbId != null) inParam.put("dbId", dbId);
        if (sqlName != null) inParam.put("sqlName", sqlName);
        if (sqlNameNo != null) inParam.put("sqlNameNo", sqlNameNo);

        System.out.println("/api/sqlNameMappSummary/:" + inParam.toString());

        if (!inParam.isEmpty()) {
                sqlNameMappVO = sqlService.getSqlNameMappSummary(inParam);
        }

        SqlNameMappVO sql = (sqlNameMappVO == null) ? null : sqlNameMappVO;
//        System.out.println("[SQL]: " + sql);
        return sql;
    }

    @GetMapping(value = {"topSqlDayList"})
    public List<SqlAreaDiffVO> topSqlDayList(
            @RequestParam(value = "dbId", required = false) final int dbId,
            @RequestParam(value = "clctDy1") final String clctDy1,
            @RequestParam(value = "clctDy2", required = false) final String clctDy2,
            @RequestParam(value = "orderString", defaultValue = "EXEC_DIFF") final String orderString,
            @RequestParam(value = "ascending", required = false) final String ascending
    )
    {
        List<SqlAreaDiffVO> SqlAreaDiffVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbId > 0) inParam.put("dbId", dbId);
        if (clctDy1 != null) inParam.put("clctDy1", clctDy1);
        if (clctDy2 != null) inParam.put("clctDy2", clctDy2);
        if (orderString != null) inParam.put("orderString", orderString);
        if (ascending != null) inParam.put("ascending", ascending);

        System.out.println("/api/topSqlDayList/:" + inParam.toString());
        if (!inParam.isEmpty()) {
            SqlAreaDiffVOList = sqlService.getTopSqlDayList(inParam);
        }

        return SqlAreaDiffVOList;
    }

    @GetMapping(value = {"topSqlDayListByAwr"})
    public List<SqlAreaDiffVO> topSqlDayListByAwr(
            @RequestParam(value = "dbId", required = false) final int dbId,
            @RequestParam(value = "clctDy1") final String clctDy1,
            @RequestParam(value = "clctDy2", required = false) final String clctDy2,
            @RequestParam(value = "orderString", defaultValue = "EXEC_DIFF") final String orderString
    )
    {
        List<SqlAreaDiffVO> SqlAreaDiffVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbId > 0) inParam.put("dbId", dbId);
        if (clctDy1 != null) inParam.put("clctDy1", clctDy1);
        if (clctDy2 != null) inParam.put("clctDy2", clctDy2);
        if (orderString != null) inParam.put("orderString", orderString);

        System.out.println("/api/topSqlDayListByAwr/:" + inParam.toString());
        if (!inParam.isEmpty()) {
            SqlAreaDiffVOList = sqlService.getTopSqlDayListByAwr(inParam);
        }

        return SqlAreaDiffVOList;
    }
}

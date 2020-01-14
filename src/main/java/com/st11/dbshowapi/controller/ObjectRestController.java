package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.object.AreaInfoVO;
import com.st11.dbshowapi.repository.object.DaSyncTableVO;
import com.st11.dbshowapi.repository.object.DaTabSubjAreaVO;
import com.st11.dbshowapi.repository.object.DaTableVO;
import com.st11.dbshowapi.service.ObjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
public class ObjectRestController {

    @Autowired
    private ObjectService objectService;

    @GetMapping(value = {"daSyncData"})
    public List<DaSyncTableVO> daSyncData(
            @RequestParam(value = "tableName", required = false) final String tableName,
            @RequestParam(value = "hostName", required = false) final String hostName) {

        List<DaSyncTableVO> daSyncTablesVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("tableName", tableName);

        if (tableName != null) inParam.put("tableName", tableName);
        if (hostName != null) inParam.put("hostName", hostName);

        System.out.println("/api/daSyncData/tableName:" + inParam.toString());
        daSyncTablesVOList = objectService.getSyncTableList(inParam);

        return daSyncTablesVOList;
    }

    @GetMapping(value = {"daTableList"})
    public List<DaTableVO> daTableList(
            @RequestParam(value = "dbId", required = false) final String dbId,
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "tableName", required = false) final String tableName,
            @RequestParam(value = "subjAreaCd", required = false) final String subjAreaCd
    ) {

        List<DaTableVO> daTableVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbId != null) inParam.put("dbId", dbId);
        if (dbName != null) inParam.put("dbName", dbName);
        if (tableName != null) inParam.put("tableName", tableName);
        if (subjAreaCd != null) inParam.put("subjAreaCd", subjAreaCd);

        System.out.println("/api/daTableList/:" + inParam.toString());
        daTableVOList = objectService.getTableList(inParam);

        return daTableVOList;
    }

    @GetMapping(value = {"daTabModification"})
    public List<DaTableVO> daTabModification(
            @RequestParam(value = "dbId", required = false) final String dbId,
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "tableName", required = false) final String tableName
    ) {

        List<DaTableVO> daTableVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbId != null) inParam.put("dbId", dbId);
        if (dbName != null) inParam.put("dbName", dbName);
        if (tableName != null) inParam.put("tableName", tableName);

        System.out.println("/api/daTableList/:" + inParam.toString());
        daTableVOList = objectService.getDaTabModification(inParam);

        return daTableVOList;
    }


    @GetMapping(value = {"logicalArea"})
    public List<AreaInfoVO> logicalArea(
            @RequestParam(value = "logicAreaCd", required = false) final String logicAreaCd) {

        List<AreaInfoVO> areaInfoVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();
        if (logicAreaCd != null) inParam.put("logicAreaCd", logicAreaCd);

        System.out.println("/api/logicalArea/:" + logicAreaCd);
        areaInfoVOList = objectService.getAreaCdList(inParam);

        return areaInfoVOList;
    }

    @GetMapping(value = {"daTabSubjAreaList"})
    public List<DaTabSubjAreaVO> daTabSubjAreaList(
            @RequestParam(value = "subjAreaCd", required = false) final String subjAreaCd) {

        List<DaTabSubjAreaVO> daTabSubjAreaVOS = null;

        HashMap<String, Object> inParam = new HashMap<>();
        if (subjAreaCd != null) inParam.put("subjAreaCd", subjAreaCd);

        System.out.println("/api/logicalArea/:" + inParam.toString());

        daTabSubjAreaVOS = objectService.getDaTabSubjAreaList(inParam);

        return daTabSubjAreaVOS;
    }
}

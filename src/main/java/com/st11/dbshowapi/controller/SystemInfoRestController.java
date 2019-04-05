package com.st11.dbshowapi.controller;


import com.st11.dbshowapi.repository.object.AreaInfoVO;
import com.st11.dbshowapi.repository.object.DaSyncTableVO;
import com.st11.dbshowapi.repository.object.DaTableVO;
import com.st11.dbshowapi.repository.object.RefObjectVO;
import com.st11.dbshowapi.service.SystemInfoService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
public class SystemInfoRestController {

    @Autowired
    private SystemInfoService systemInfoService;

    @GetMapping(value = {"referencedObject/{dbName}/{objectType}/{owner}/{objectName}"})
    public List<RefObjectVO> referencedObject(
            @PathVariable final String dbName, @PathVariable final String objectType,
            @PathVariable final String owner, @PathVariable final String objectName) {

        List<RefObjectVO> refObjects = null;
        System.out.println("/api/referencedObject/dbName:"+ dbName + "/objectType:" + objectType + "/owner:"+ owner + "/objectName:" + objectName);

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("owner", owner);
        inParam.put("objectName", objectName);
        inParam.put("objectType", objectType);

        if (objectName != null && owner != null) {
            refObjects = systemInfoService.getRefObjectList(inParam);
        }

        return refObjects;
    }

//    @GetMapping(value = {"referencedObject"})
//    public List<RefObjectVO> referencedObject(
//            @RequestParam(value = "dbName", required = false) final String dbName,
//            @RequestParam(value = "objectType", required = false) final String objectType,
//            @RequestParam(value = "owner") final String owner,
//            @RequestParam(value = "objectName") final String objectName) {
//
//        List<RefObjectVO> refObjects = null;
//
//        HashMap<String, Object> inParam = new HashMap<>();
//
//        if (dbName != null) inParam.put("dbName", dbName);
//        if (objectType != null) inParam.put("objectType", objectType);
//        if (owner != null) inParam.put("owner", owner);
//        if (objectName != null) inParam.put("objectName", objectName);
//
//        System.out.println("/api/referencedObject/dbName:"+ inParam.toString());
//        refObjects = systemInfoService.getRefObjectList(inParam);
//
//        return refObjects;
//    }

//
//    @GetMapping(value = {"daSyncData/{tableName}"})
//    public List<DaSyncTableVO> daSyncData(
//            @PathVariable final String tableName) {
//
//        List<DaSyncTableVO> daSyncTablesVOList = null;
//        System.out.println("/api/daSyncData/tableName:" + tableName);
//
//        HashMap<String, Object> inParam = new HashMap<>();
//        inParam.put("tableName", tableName);
//
//        if (tableName != null) {
//            daSyncTablesVOList = systemInfoService.getSyncTableList(inParam);
//        }
//
//        return daSyncTablesVOList;
//    }
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
        daSyncTablesVOList = systemInfoService.getSyncTableList(inParam);

        return daSyncTablesVOList;
    }

    @GetMapping(value = {"daTables"})
    public List<DaTableVO> daTables(
            @RequestParam(value = "tableName", required = false) final String tableName,
            @RequestParam(value = "logicalAreaCd1", required = false) final String logicalAreaCd1,
            @RequestParam(value = "logicalAreaCd2", required = false) final String logicalAreaCd2) {

        List<DaTableVO> daTableVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();

        if (tableName != null) inParam.put("tableName", tableName);
        if (logicalAreaCd1 != null) inParam.put("logicalAreaCd1", logicalAreaCd1);
        if (logicalAreaCd2 != null) inParam.put("logicalAreaCd2", logicalAreaCd2);

        System.out.println("/api/daTables/:" + inParam.toString());
        daTableVOList = systemInfoService.getTableList(inParam);

        return daTableVOList;
    }


    @GetMapping(value = {"logicalArea"})
    public List<AreaInfoVO> logicalArea(
            @RequestParam(value = "logicAreaCd", required = false) final String logicAreaCd) {

        List<AreaInfoVO> areaInfoVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();
        if (logicAreaCd != null) inParam.put("logicAreaCd", logicAreaCd);

        System.out.println("/api/logicalAreaTables/:" + logicAreaCd);
        areaInfoVOList = systemInfoService.getAreaCdList(inParam);

        return areaInfoVOList;
    }
}

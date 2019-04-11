package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.dbshowapi.DaStatMngVO;
import com.st11.dbshowapi.repository.sql.TopSqlVO;
import com.st11.dbshowapi.service.DbShowApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/dbshow")
public class DbShowRestController {

    @Autowired
    DbShowApiService dbShowApiService;

    @GetMapping(value = {"getDaStatMngList"})
    public List<DaStatMngVO> getDaStatMngList(
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "statName", required = false) final String statName,
            @RequestParam(value = "clctDy", required = false) final String clctDy) {

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbName != null) inParam.put("dbName", dbName);
        if (statName != null) inParam.put("statName", statName);
        if (clctDy != null) inParam.put("clctDy", clctDy);

        return dbShowApiService.getDaStatMngList(inParam);
    }

    @GetMapping(value = {"getLastDaStatMng"})
    public List<DaStatMngVO> getLastDaStatMng(
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "statName", required = false) final String statName) {

        HashMap<String, Object> inParam = new HashMap<>();

        if (dbName != null) inParam.put("dbName", dbName);
        if (statName != null) inParam.put("statName", statName);

        System.out.println("[getLastDaStatMng()]inParam: " + inParam);
//        return dbShowApiService.getLastDaStatMng(inParam);
        return dbShowApiService.getLastDaStatMng(dbName, statName);

    }

}

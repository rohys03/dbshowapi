package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.jpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jpa")
public class JpaRestController {

    @Autowired
    DaStatMngRepository daStatMngRepository;

    @Autowired
    DaDbListRepository daDbListRepository;

    @Autowired
    DaSqlNameListRepository daSqlNameListRepository;

    @Autowired
    DaSqlFullTextRepository daSqlFullTextRepository;

    @GetMapping("/daStatMngLastUpdateDt")
    public List<DaStatMngVO> getDaStatMngLastUpdateDt(
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "statName", required = false) final String statName) {

        return daStatMngRepository.findFirstByDbNmAndStatNmOrderByClctDyDesc(dbName, statName);
    }

    @GetMapping("/daDbList")
    public List<DaDbListVO> getDaDbList(
            @RequestParam(value = "dbshowUseYn", required = false, defaultValue = "Y") final String dbshowUseYn
    ) {
        return daDbListRepository.findByDbshowUseYnOrderByDbId(dbshowUseYn);
    }

    @GetMapping("/daDbNm")
    public DaDbListVO getDaDbName(
            @RequestParam(value = "dbNm", required = false) final String dbName
    ) {
        return daDbListRepository.findByDbNm(dbName);
    }

    @GetMapping("/daSqlFullText")
    public DaSqlFullTextVO getDaSqlFullText(
            @RequestParam(value = "dbId", required = false) final String dbId,
            @RequestParam(value = "sqlId") final String sqlId) {
        return daSqlFullTextRepository.findFirstByDbIdAndSqlId(dbId, sqlId);
    }

    @GetMapping("/daSqlNameList")
    public List<DaSqlNameListVO> getDaSqlNameList(
            @RequestParam(value = "dbId", required = false) final String dbId,
            @RequestParam(value = "sqlName") final String sqlName) {

        System.out.println("[DBID] : "+ dbId + "[sqlname]: " + sqlName);
        if (dbId == null) {
            return daSqlNameListRepository.findBySqlNameContainingOrderBySqlNameAscDbIdAsc(sqlName);
        } else {
            return daSqlNameListRepository.findBySqlNameContainingAndDbIdOrderBySqlNameAscDbIdAsc(sqlName, dbId);
        }
    }
}

package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.jpa.DaDbListRepository;
import com.st11.dbshowapi.jpa.DaDbListVO;
import com.st11.dbshowapi.jpa.DaStatMngRepository;
import com.st11.dbshowapi.jpa.DaStatMngVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/jpa")
public class JpaRestController {

    @Autowired
    DaStatMngRepository daStatMngRepository;

    @Autowired
    DaDbListRepository daDbListRepository;

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
        return daDbListRepository.findByDbshowUseYn(dbshowUseYn);
    }

    @GetMapping("/daDbNm")
    public DaDbListVO getDaDbName(
            @RequestParam(value = "dbNm", required = false) final String dbNm
    ) {
        return daDbListRepository.findByDbNm(dbNm);
    }

}

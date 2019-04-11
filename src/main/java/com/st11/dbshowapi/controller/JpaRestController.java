package com.st11.dbshowapi.controller;

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

    @GetMapping("/daStatMngLastUpdateDt")
    public List<DaStatMngVO> getDaStatMngLastUpdateDt(
            @RequestParam(value = "dbName", required = false) final String dbName,
            @RequestParam(value = "statName", required = false) final String statName) {

        return daStatMngRepository.findFirstByDbNmAndStatNmOrderByClctDyDesc(dbName, statName);
    }
}

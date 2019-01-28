package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.jpa.MtCupnRepository;
import com.st11.dbshowapi.jpa.MtCupnVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/jpa")
public class JpaRestController {

    @Autowired
    MtCupnRepository mtCupnRepository;

    @GetMapping("/mtCupnList")
    public List<MtCupnVo> getMtCupnList() {

        List<MtCupnVo> mtCupnVoList = mtCupnRepository.findAll();
        return mtCupnVoList;
    }

}

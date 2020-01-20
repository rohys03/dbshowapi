package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.dam.DamEntityVO;
import com.st11.dbshowapi.service.DamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api/dam")
public class DamRestController {

    @Autowired
    private DamService damService;

    @GetMapping(value = {"entityList"})
    public List<DamEntityVO> damEntityList(
            @RequestParam(value = "tableName", required = false) final String tableName) {

        List<DamEntityVO> damEntityVOList = null;

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("tableName", tableName);

        if (tableName != null) inParam.put("tableName", tableName);

        System.out.println("/api/dam/entityList :" + inParam.toString());
        damEntityVOList = damService.getDamEntityList(inParam);

        return damEntityVOList;
    }
}

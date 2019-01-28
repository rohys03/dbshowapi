package com.st11.dbshowapi.controller;


import com.st11.dbshowapi.repository.RefObjectVO;
import com.st11.dbshowapi.service.SystemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("api")
public class SystemInfoRestController {

    @Autowired
    private SystemInfoService systemInfoService;

    @RequestMapping(value = {"referencdObject/{dbName}/{objectType}/{owner}/{objectName}"})
    public List<RefObjectVO> referencedObject(
            @PathVariable final String dbName, @PathVariable final String objectType,
            @PathVariable final String owner, @PathVariable final String objectName) {

        List<RefObjectVO> refObjects = null;
        System.out.println("/api/referencdObject/owner:"+ owner + "/name:" + objectName + "/commandType:" + objectType);

        HashMap<String, Object> inParam = new HashMap<>();
        inParam.put("owner", owner);
        inParam.put("objectName", objectName);
        inParam.put("objectType", objectType);

        if (objectName != null && owner != null) {
            refObjects = systemInfoService.getRefObjectList(inParam);
        }

        return refObjects;
    }

}

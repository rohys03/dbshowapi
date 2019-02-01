package com.st11.dbshowapi.controller;


import com.st11.dbshowapi.repository.RefObjectVO;
import com.st11.dbshowapi.service.SystemInfoService;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(value = {"getEncryptString/{string:.+}"})
    public List<String> getEncryptString (@PathVariable final String string) {
        System.out.println("/api/getEncryptString/string:"+ string);

        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWithMD5AndDES");
        pbeEnc.setPassword("purple");

        String enc = pbeEnc.encrypt(string); //암호화 할 내용
        System.out.println("enc = " + enc); //암호화 한 내용을 출력

        String des = pbeEnc.decrypt(enc);
        System.out.println("des = " + des);

        List<String> returnOjbects = new ArrayList<>();
        returnOjbects.add(enc);

        /*
        String[] stringList = {""};

        for (String string2 : stringList) {

            String enc2 = pbeEnc.encrypt(string2); //암호화 할 내용
            System.out.println("enc["+string2+"] = " + enc2); //암호화 한 내용을 출력

            String des2 = pbeEnc.decrypt(enc2);
            System.out.println("des["+string2+"] = " + des2);
        }
        */
        return returnOjbects;
    }
}

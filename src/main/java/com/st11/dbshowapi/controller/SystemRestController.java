package com.st11.dbshowapi.controller;

import com.st11.dbshowapi.repository.system.DaStdWordDicVO;
import com.st11.dbshowapi.repository.system.DbKpiStatVO;
import com.st11.dbshowapi.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class SystemRestController {

    @Autowired
    SystemService systemService;

    @GetMapping(value = {"dbKpiStatWeekly"})
    public List<DbKpiStatVO> getDbKpiStatWeekly(
            @RequestParam(value = "cnt", required = false) final String cnt) {
        return systemService.getDbKpiStatsWeekly(cnt);
    }


    @GetMapping(value = {"dbKpiStatDaily"})
    public List<DbKpiStatVO> getDbKpiStatDaily(
            @RequestParam(value = "cnt", required = false) final String cnt) {
        return systemService.getDbKpiStatsDaily(cnt);
    }

    @GetMapping(value = {"daStdWordDicList"})
    public List<DaStdWordDicVO> getDaStdWordDicList() {
        return systemService.getDaStdWordDicList();
    }

}

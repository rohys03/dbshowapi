package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.system.DbKpiStatMapper;
import com.st11.dbshowapi.repository.system.DbKpiStatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    DbKpiStatMapper dbKpiStatMapper;

    @Override
    public List<DbKpiStatVO> getDbKpiStatsWeekly(int page) {
        return dbKpiStatMapper.getDbKpiStatsWeekly(page);
    }

    @Override
    public List<DbKpiStatVO> getDbKpiStatsDaily(int page) {
        return dbKpiStatMapper.getDbKpiStatsDaily(page);
    }

}

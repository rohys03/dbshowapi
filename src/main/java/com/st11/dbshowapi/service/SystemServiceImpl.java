package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dbshowapi.DaStatMngVO;
import com.st11.dbshowapi.repository.system.DaStdWordDicMapper;
import com.st11.dbshowapi.repository.system.DaStdWordDicVO;
import com.st11.dbshowapi.repository.system.DbKpiStatMapper;
import com.st11.dbshowapi.repository.system.DbKpiStatVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SystemServiceImpl implements SystemService {

    @Autowired
    DbKpiStatMapper dbKpiStatMapper;
    @Autowired
    DaStdWordDicMapper daStdWordDicMapper;

    @Override
    public List<DbKpiStatVO> getDbKpiStatsWeekly(String page) {
        return dbKpiStatMapper.getDbKpiStatsWeekly(Integer.parseInt(page));
    }

    @Override
    public List<DbKpiStatVO> getDbKpiStatsDaily(String page) {
        return dbKpiStatMapper.getDbKpiStatsDaily(Integer.parseInt(page));
    }

    @Override
    public List<DaStdWordDicVO> getDaStdWordDicList(){
        return daStdWordDicMapper.getDaStdWordDicList();
    }
}

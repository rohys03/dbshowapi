package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dbshowapi.DaStatMngVO;
import com.st11.dbshowapi.repository.system.DaStdWordDicVO;
import com.st11.dbshowapi.repository.system.DbKpiStatVO;


import java.util.List;

public interface SystemService {
    List<DbKpiStatVO> getDbKpiStatsWeekly(String page);
    List<DbKpiStatVO> getDbKpiStatsDaily(String page);

    List<DaStdWordDicVO> getDaStdWordDicList();
}

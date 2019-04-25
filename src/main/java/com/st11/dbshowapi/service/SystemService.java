package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.system.DbKpiStatVO;


import java.util.List;

public interface SystemService {
    List<DbKpiStatVO> getDbKpiStatsWeekly(int page);
    List<DbKpiStatVO> getDbKpiStatsDaily(int page);

}

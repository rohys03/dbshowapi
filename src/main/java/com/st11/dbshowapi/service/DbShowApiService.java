package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dbshowapi.DaStatMngAllVO;
import com.st11.dbshowapi.repository.dbshowapi.DaStatMngVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface DbShowApiService {

    List<DaStatMngVO> getLastDaStatMng(String dbName, String statName);
    DaStatMngVO getLastDaStatMng2(String dbName, String statName);

    List<DaStatMngVO> getDaStatMngList (HashMap<String, Object> inParam);
    List<DaStatMngAllVO> getDaStatMngAll ();

}

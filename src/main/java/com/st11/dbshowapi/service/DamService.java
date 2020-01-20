package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dam.DamEntityVO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface DamService {
    List<DamEntityVO> getDamEntityList (HashMap<String, Object> inParam);
}

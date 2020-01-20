package com.st11.dbshowapi.service;

import com.st11.dbshowapi.repository.dam.DamEntityVO;
import com.st11.dbshowapi.repository.dam.DamMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DamServiceImpl implements DamService {

    @Autowired
    DamMapper damMapper;

    @Override
    public List<DamEntityVO> getDamEntityList(HashMap<String, Object> inParam) {
        return damMapper.getDamEntityList(inParam);
    }
}

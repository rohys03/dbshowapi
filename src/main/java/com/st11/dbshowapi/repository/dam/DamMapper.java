package com.st11.dbshowapi.repository.dam;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
@Resource(name="dadbSessionFactory")
public interface  DamMapper {

    List<DamEntityVO> getDamEntityList(HashMap<String, Object> inParam);
}

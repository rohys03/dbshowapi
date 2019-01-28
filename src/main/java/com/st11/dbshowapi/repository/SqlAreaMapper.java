package com.st11.dbshowapi.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
@Resource(name="maindbSessionFactory")
public interface SqlAreaMapper {
    List<SqlAreaVO> getSqlAreaListAll();
    List<SqlAreaVO> getSqlAreaList(HashMap<String, Object> inparam);

    List<SqlAreaVO> getSqlAreaDetail(HashMap<String, Object> inparam);
}

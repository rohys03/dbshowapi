package com.st11.dbshowapi.repository.dbshowapi;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
@Mapper
@Resource(name="dadbSessionFactory")
public interface DbShowApiMapper {

    @Select("select sys_context(#{userenv}, #{envKey}) from dual")
    String selectUserEnv(String userenv, String envKey);

}
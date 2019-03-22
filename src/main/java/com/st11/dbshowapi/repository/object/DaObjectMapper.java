package com.st11.dbshowapi.repository.object;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Repository
@Mapper
@Resource(name="dadbSessionFactory")
public interface DaObjectMapper {
    List<DaSyncTableVO> getSyncTableList(HashMap<String, Object> inParam);
    List<RefObjectVO> getRefObjectList(HashMap<String, Object> inparam);
    List<DaTableVO> getTableList(HashMap<String, Object> inparam);
    List<AreaInfoVO> getAreaCdList(HashMap<String, Object> inparam);
}


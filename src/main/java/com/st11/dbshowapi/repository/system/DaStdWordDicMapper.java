package com.st11.dbshowapi.repository.system;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
@Mapper
@Resource(name="dadbSessionFactory")
public interface DaStdWordDicMapper {

    String SELECT_DA_STD_WORD_DIC = "SELECT * FROM DAUSER.DA_STD_WORD_DIC ORDER BY WORD_NO";

    @Select(SELECT_DA_STD_WORD_DIC)
    @Results(value= {

            @Result(property="wordNo", column="word_no"),
            @Result(property="wordClfNm", column="Word_Clf_Nm"),
            @Result(property="basiWordNm", column="Basi_Word_Nm"),
            @Result(property="engWordNm", column="Eng_Word_Nm"),
            @Result(property="engAbrvtNm", column="Eng_Abrvt_Nm"),
            @Result(property="wordDesc", column="word_desc"),
            @Result(property="subjAreaNm", column="subj_area_nm"),
            @Result(property="useYn", column="use_yn"),
            @Result(property="createDt", column="create_dt")
    })
    List<DaStdWordDicVO> getDaStdWordDicList();

}

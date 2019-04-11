package com.st11.dbshowapi.jpa;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaStatMngRepository extends JpaRepository<DaStatMngVO, DaStatMngId> {
    List<DaStatMngVO> findFirstByDbNmAndStatNmOrderByClctDyDesc(String dbNm, String statNm);

}

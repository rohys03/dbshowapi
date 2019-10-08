package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaDbListRepository  extends JpaRepository<DaDbListVO, Integer> {
    List<DaDbListVO> findByDbshowUseYn(String dbshowUseYn);

    DaDbListVO findByDbNm(String dbNm);
}

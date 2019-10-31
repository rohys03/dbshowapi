package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaSqlNameListRepository extends JpaRepository<DaSqlNameListVO, String> {
    @Nullable
    List<DaSqlNameListVO> findBySqlNameContainingAndDbIdOrderBySqlNameAscDbIdAsc(String sqlName, String dbId);
    @Nullable
    List<DaSqlNameListVO> findBySqlNameContainingOrderBySqlNameAscDbIdAsc(String sqlName);
}

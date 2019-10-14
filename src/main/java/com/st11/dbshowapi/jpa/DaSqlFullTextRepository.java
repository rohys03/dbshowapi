package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DaSqlFullTextRepository extends JpaRepository<DaSqlFullTextVO, DaSqlFullTextId> {
    DaSqlFullTextVO findFirstByDbNmAndSqlId(String dbNm, String sqlId);
}

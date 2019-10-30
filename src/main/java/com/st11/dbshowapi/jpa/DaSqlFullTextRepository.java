package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface DaSqlFullTextRepository extends JpaRepository<DaSqlFullTextVO, DaSqlFullTextId> {
    @Nullable
    DaSqlFullTextVO findFirstByDbIdAndSqlId(String dbId, String sqlId);
}

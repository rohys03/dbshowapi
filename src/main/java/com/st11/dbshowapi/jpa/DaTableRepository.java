package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaTableRepository extends JpaRepository<DaTableVO, DaTableId> {
    @Nullable
    DaTableVO findFirstByDbIdAndOwnerAndTableName(String dbId, String owner, String tableName);

    @Nullable
    List<DaTableVO> findAllByLogicalAreaCd(String logicalAreaCd);

    @Nullable
    List<DaTableVO> findAllByLogicalAreaCdAndLogicalAreaCd2(String logicalAreaCd, String logicalAreaCd2);

    @Nullable
    List<DaTableVO> findAllBySubjAreaCd (String subjAreaCd);
}

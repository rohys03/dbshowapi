package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DaObjectRepository extends JpaRepository<DaObjectVO, DaObjectId> {
    @Nullable
    DaObjectVO findFirstByDbIdAndOwnerAndObjectNameAndObjectType(String dbId, String owner, String objectName, String objectType);

    @Nullable
    List<DaObjectVO> findAllByObjectNameAndObjectType(String objectName, String objectType);
}

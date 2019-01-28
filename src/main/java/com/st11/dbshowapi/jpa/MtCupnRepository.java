package com.st11.dbshowapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MtCupnRepository extends JpaRepository<MtCupnVo, Integer> {

}

package com.st11.dbshowapi.jpa;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name="DA_DB_LIST")
public class DaDbListVO {

    @Id
    @Column(name="DB_ID")
    private Integer dbId;

    @Column(name="DB_NM")
    private String dbNm;

    @Column(name="host_nm")
    private String hostNm;

    @Column(name="create_dt")
    private Date createDt;

    @Column(name="dqm_db_id")
    private String dqmDbId;

    @Column(name="dqm_db_nm")
    private String dqmDbNm;

    @Column(name="dbshow_Use_Yn")
    private String dbshowUseYn;

}

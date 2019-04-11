package com.st11.dbshowapi.jpa;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="DA_STAT_MNG")
@IdClass(DaStatMngId.class)
public class DaStatMngVO {

    @Id
    @Column(name="DB_NM")
    private String dbNm;

    @Id
    @Column(name="stat_nm")
    private String statNm;

    @Id
    @Column(name="clct_dy")
    private String clctDy;

    @Column(name="clct_rslt_cd")
    private String clctRsltCd;

    @Column(name="part_cd")
    private String partCd;

    @Column(name="create_dt")
    private Date createDt;

    @Column(name="update_dt")
    private Date updateDt;

}

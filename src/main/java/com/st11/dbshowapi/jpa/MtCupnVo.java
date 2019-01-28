package com.st11.dbshowapi.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="temp$0303_jpa")
public class MtCupnVo {

    @Id
    @Column(name="cupn_no")
    private int cupnNo;
    @Column(name="cupn_nm")
    private String cupnNm;
    @Column(name="dsc_amt")
    private int dscAmt;
    @Column(name="dsc_rt")
    private int dscRt;
    @Column(name="cupn_typ_cd")
    private String cupnTypCd;

}

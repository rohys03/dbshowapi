package com.st11.dbshowapi.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class DaStatMngId implements Serializable {
    @Column(name="DB_NM")
    private String dbNm;
    @Column(name="stat_nm")
    private String statNm;
    @Column(name="clct_dy")
    private String clctDy;

}

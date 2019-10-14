package com.st11.dbshowapi.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class DaSqlFullTextId implements Serializable {
    @Column(name="DB_NM")
    private String dbNm;
    @Column(name="SQL_ID")
    private String sqlId;
}

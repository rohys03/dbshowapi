package com.st11.dbshowapi.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class DaSqlFullTextId implements Serializable {
    @Column(name="SQL_ID")
    private String sqlId;
    @Column(name="DB_ID")
    private String dbId;

}

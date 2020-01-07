package com.st11.dbshowapi.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class DaTableId implements Serializable {
    @Column(name="DB_ID")
    private String dbId;

    @Column(name="OWNER")
    private String owner;
    @Column(name="TABLE_NAME")
    private String tableName;
}

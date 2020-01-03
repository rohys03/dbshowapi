package com.st11.dbshowapi.jpa;

import javax.persistence.Column;
import java.io.Serializable;

public class DaObjectId implements Serializable {
    @Column(name="DB_ID")
    private String dbId;

    @Column(name="OBJECT_ID")
    private String objectId;
}

package com.st11.dbshowapi.jpa;


import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name="DA_OBJECTS")
@IdClass(DaObjectId.class)
public class DaObjectVO {

    @Id
    @Column(name="DB_ID")
    private String dbId;

    @Id
    @Column(name="OBJECT_ID")
    private String objectId;

    @Column(name="OWNER")
    private String owner;

    @Column(name="OBJECT_NAME")
    private String objectName;

    @Column(name="OBJECT_TYPE")
    private String objectType;

    @Column(name="CREATED")
    private Date created;

    @Column(name="LAST_DDL_TIME")
    private Date lastDdlTime;

    @Column(name="STATUS")
    private String status;

    @Column(name="temporary")
    private String temporary;

}

package com.st11.dbshowapi.jpa;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="DA_TABLES")
@IdClass(DaTableId.class)
public class DaTableVO {

    @Id
    @Column(name="DB_ID")
    private String dbId;

    @Id
    @Column(name="owner")
    private String owner;

    @Id
    @Column(name="tableName")
    private String tableName;

    @Column(name="logic_Area_Cd")
    private String logicalAreaCd;

    @Column(name="logic_Area_Cd2")
    private String logicalAreaCd2;

    @Column(name="Phscl_Area_cd")
    private String physicalAreaCd;

    @Column(name="Table_comments")
    private String tableComments;

    @Column(name="Table_create_Dt")
    private String tableCreateDt;

    @Column(name="STD_OBJ_YN")
    private String standardObjectYn;
}

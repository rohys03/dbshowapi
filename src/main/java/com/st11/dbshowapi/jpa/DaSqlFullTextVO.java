package com.st11.dbshowapi.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="DA_SQL_FULLTEXT")
@IdClass(DaSqlFullTextId.class)
public class DaSqlFullTextVO {

    @Id
    @Column(name="DB_ID")
    private String dbId;

    @Id
    @Column(name="SQL_ID")
    private String sqlId;

    @Lob
    @Column(name="SQL_FULLTEXT")
    private String sqlFullText;

    @Column(name="PROGRAM_ID")
    private Integer programId;


}

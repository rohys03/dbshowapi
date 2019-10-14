package com.st11.dbshowapi.jpa;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="DA_SQL_FULLTEXT")
@IdClass(DaSqlFullTextId.class)
public class DaSqlFullTextVO {

    @Id
    @Column(name="DB_NM")
    private String dbNm;

    @Id
    @Column(name="SQL_ID")
    private String sqlId;

    @Lob
    @Column(name="SQL_FULLTEXT")
    private String sqlFullText;

}

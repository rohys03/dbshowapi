package com.st11.dbshowapi.jpa;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Data
@Entity
@Table(name="DA_SQLNAME_LIST")
public class DaSqlNameListVO {

    @Id
    @Column(name="SQL_NAME_NO")
    private String sqlNameNo;

    @Column(name="DB_ID")
    private String dbId;

    @Column(name="sql_Name")
    private String sqlName;

    @Column(name="rep_sql_id")
    private String repSqlId;

    @Column(name="parsing_schema_name")
    private String parsingSchemaName;

    @Column(name="module")
    private String module;

    @Column(name="last_active_time")
    private Date lastActiveTime;

    @Column(name="create_dt")
    private Date createDt;

    @Column(name="update_dt")
    private Date updateDt;

}

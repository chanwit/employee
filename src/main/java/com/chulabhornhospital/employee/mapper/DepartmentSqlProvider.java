package com.chulabhornhospital.employee.mapper;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.chulabhornhospital.employee.domain.Department;

public class DepartmentSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEPARTMENT
     *
     * @mbggenerated
     */
    public String insertSelective(Department record) {
        BEGIN();
        INSERT_INTO("PUBLIC.DEPARTMENT");
        
        if (record.getId() != null) {
            VALUES("ID", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getName() != null) {
            VALUES("NAME", "#{name,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.DEPARTMENT
     *
     * @mbggenerated
     */
    public String updateByPrimaryKeySelective(Department record) {
        BEGIN();
        UPDATE("PUBLIC.DEPARTMENT");
        
        if (record.getName() != null) {
            SET("NAME = #{name,jdbcType=VARCHAR}");
        }
        
        WHERE("ID = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}
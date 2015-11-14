package com.chulabhornhospital.employee.mapper.custom;

import com.chulabhornhospital.employee.domain.Employee;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Administrator on 10/26/2015.
 */
public interface EmployeeListMapper {

    @Select({
            "select",
            "ID, FIRST_NAME, LAST_NAME, GENDER, DOB, SALARY, NICK_NAME, BEING_HIRED",
            "from PUBLIC.EMPLOYEE",
            "limit #{limit}"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="FIRST_NAME", property="firstName", jdbcType=JdbcType.VARCHAR),
            @Result(column="LAST_NAME", property="lastName", jdbcType=JdbcType.VARCHAR),
            @Result(column="GENDER", property="gender", jdbcType=JdbcType.VARCHAR),
            @Result(column="DOB", property="dob", jdbcType=JdbcType.DATE),
            @Result(column="SALARY", property="salary", jdbcType=JdbcType.DECIMAL),
            @Result(column="NICK_NAME", property="nickName", jdbcType=JdbcType.VARCHAR),
            @Result(column="BEING_HIRED", property="beingHired", jdbcType=JdbcType.BOOLEAN)
    })
    List<Employee> list(@Param("limit") Long limit);

    @Select({
            "select",
            "ID, FIRST_NAME, LAST_NAME, GENDER, DOB, SALARY, NICK_NAME, BEING_HIRED",
            "from PUBLIC.EMPLOYEE",
            "where FIRST_NAME like #{query}",
            "   or LAST_NAME  like #{query}",
            "   or NICK_NAME  like #{query}"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
            @Result(column="FIRST_NAME", property="firstName", jdbcType=JdbcType.VARCHAR),
            @Result(column="LAST_NAME", property="lastName", jdbcType=JdbcType.VARCHAR),
            @Result(column="GENDER", property="gender", jdbcType=JdbcType.VARCHAR),
            @Result(column="DOB", property="dob", jdbcType=JdbcType.DATE),
            @Result(column="SALARY", property="salary", jdbcType=JdbcType.DECIMAL),
            @Result(column="NICK_NAME", property="nickName", jdbcType=JdbcType.VARCHAR),
            @Result(column="BEING_HIRED", property="beingHired", jdbcType=JdbcType.BOOLEAN)
    })
    List<Employee> search(@Param("query") String query);

}


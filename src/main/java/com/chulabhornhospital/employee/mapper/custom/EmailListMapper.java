package com.chulabhornhospital.employee.mapper.custom;

import com.chulabhornhospital.employee.domain.Email;
import com.chulabhornhospital.employee.domain.Employee;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


public interface EmailListMapper {

    @Select({
            "select",
            "ID, EMAIL_ADDRESS, EMPLOYEE_ID",
            "from PUBLIC.EMAIL",
            "where EMPLOYEE_ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="EMAIL_ADDRESS", property="emailAddress", jdbcType=JdbcType.VARCHAR),
            @Result(column="EMPLOYEE_ID", property="employeeId", jdbcType=JdbcType.BIGINT)
    })
    List<Email> listByEmployee(Long id);


    @Delete({
            "delete from PUBLIC.EMAIL",
            "where EMPLOYEE_ID = #{employeeId,jdbcType=BIGINT}"
    })
    int deleteByEmployeeId(@Param("employeeId") Long employeeId);
}

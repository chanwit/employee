package com.chulabhornhospital.employee.mapper.custom;

import com.chulabhornhospital.employee.domain.Telephone;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;


public interface TelListMapper {

    @Select({
            "select",
            "ID, TEL_NUMBER, EMPLOYEE_ID",
            "from PUBLIC.TELEPHONE",
            "where EMPLOYEE_ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="TEL_NUMBER", property="telNumber", jdbcType=JdbcType.VARCHAR),
            @Result(column="EMPLOYEE_ID", property="employeeId", jdbcType=JdbcType.BIGINT)
    })
    List<Telephone> listByEmployee(Long id);

}

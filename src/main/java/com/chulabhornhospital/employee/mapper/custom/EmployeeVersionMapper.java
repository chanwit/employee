package com.chulabhornhospital.employee.mapper.custom;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface EmployeeVersionMapper {

    @Select("select version from employee where id=#{id}")
    @ResultType(value = Long.class)
    Long getVersion(@Param("id") Long id);

}

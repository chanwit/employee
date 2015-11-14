package com.chulabhornhospital.employee.mapper.custom;

import com.chulabhornhospital.employee.domain.Department;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * Created by Administrator on 11/14/2015.
 */
public interface DepartmentListMapper {

    @Select({
            "select",
            "ID, NAME",
            "from PUBLIC.DEPARTMENT",
            "limit #{limit}"
    })
    @Results({
            @Result(column="ID", property="id", jdbcType= JdbcType.BIGINT, id=true),
            @Result(column="NAME", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<Department> list(@Param("limit") Long limit);

}

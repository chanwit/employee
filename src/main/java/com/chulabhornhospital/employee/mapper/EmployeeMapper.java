package com.chulabhornhospital.employee.mapper;

import com.chulabhornhospital.employee.domain.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface EmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbggenerated
     */
    @Delete({
        "delete from PUBLIC.EMPLOYEE",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbggenerated
     */
    @Insert({
        "insert into PUBLIC.EMPLOYEE (ID, FIRST_NAME, ",
        "LAST_NAME, GENDER, ",
        "DOB, SALARY, NICK_NAME, ",
        "BEING_HIRED, DEPARTMENT_ID)",
        "values (#{id,jdbcType=BIGINT}, #{firstName,jdbcType=VARCHAR}, ",
        "#{lastName,jdbcType=VARCHAR}, #{gender,jdbcType=BOOLEAN}, ",
        "#{dob,jdbcType=DATE}, #{salary,jdbcType=DECIMAL}, #{nickName,jdbcType=VARCHAR}, ",
        "#{beingHired,jdbcType=BOOLEAN}, #{departmentId,jdbcType=BIGINT})"
    })
    int insert(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbggenerated
     */
    @InsertProvider(type=EmployeeSqlProvider.class, method="insertSelective")
    int insertSelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbggenerated
     */
    @Select({
        "select",
        "ID, FIRST_NAME, LAST_NAME, GENDER, DOB, SALARY, NICK_NAME, BEING_HIRED, DEPARTMENT_ID",
        "from PUBLIC.EMPLOYEE",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="ID", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="FIRST_NAME", property="firstName", jdbcType=JdbcType.VARCHAR),
        @Result(column="LAST_NAME", property="lastName", jdbcType=JdbcType.VARCHAR),
        @Result(column="GENDER", property="gender", jdbcType=JdbcType.BOOLEAN),
        @Result(column="DOB", property="dob", jdbcType=JdbcType.DATE),
        @Result(column="SALARY", property="salary", jdbcType=JdbcType.DECIMAL),
        @Result(column="NICK_NAME", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="BEING_HIRED", property="beingHired", jdbcType=JdbcType.BOOLEAN),
        @Result(column="DEPARTMENT_ID", property="departmentId", jdbcType=JdbcType.BIGINT)
    })
    Employee selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbggenerated
     */
    @UpdateProvider(type=EmployeeSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Employee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.EMPLOYEE
     *
     * @mbggenerated
     */
    @Update({
        "update PUBLIC.EMPLOYEE",
        "set FIRST_NAME = #{firstName,jdbcType=VARCHAR},",
          "LAST_NAME = #{lastName,jdbcType=VARCHAR},",
          "GENDER = #{gender,jdbcType=BOOLEAN},",
          "DOB = #{dob,jdbcType=DATE},",
          "SALARY = #{salary,jdbcType=DECIMAL},",
          "NICK_NAME = #{nickName,jdbcType=VARCHAR},",
          "BEING_HIRED = #{beingHired,jdbcType=BOOLEAN},",
          "DEPARTMENT_ID = #{departmentId,jdbcType=BIGINT}",
        "where ID = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Employee record);
}
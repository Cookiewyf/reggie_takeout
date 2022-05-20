package com.cookie.reggie.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cookie.reggie.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
}

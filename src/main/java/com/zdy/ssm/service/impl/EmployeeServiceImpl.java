package com.zdy.ssm.service.impl;

import com.zdy.ssm.bean.Emp;
import com.zdy.ssm.mapper.EmpMapper;
import com.zdy.ssm.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmpMapper empMapper;
    @Override
    public List<Emp> getAllEmployees() {
        return empMapper.selectByExample(null);
    }
}

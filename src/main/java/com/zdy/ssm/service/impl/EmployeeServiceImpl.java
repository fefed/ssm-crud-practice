package com.zdy.ssm.service.impl;

import com.zdy.ssm.bean.Emp;
import com.zdy.ssm.bean.EmpExample;
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
        return empMapper.selectByExampleWithDept(null);
    }

    @Override
    public void saveEmployee(Emp emp) {
        empMapper.insertSelective(emp);
    }

    @Override
    public Boolean checkEmpName(String empName) {
        EmpExample empExample = new EmpExample();
        empExample.createCriteria().andEmpNameEqualTo(empName);
        int count = empMapper.countByExample(empExample);
        return count == 0;
    }

    @Override
    public Emp getEmployee(Integer empId) {
        return empMapper.selectByPrimaryKey(empId);
    }

    @Override
    public void updateEmployee(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }
}

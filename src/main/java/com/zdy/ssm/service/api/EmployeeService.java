package com.zdy.ssm.service.api;

import com.zdy.ssm.bean.Emp;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
public interface EmployeeService {
    List<Emp> getAllEmployees();

    void saveEmployee(Emp emp);

    Boolean checkEmpName(String empName);

    Emp getEmployee(Integer empId);

    void updateEmployee(Emp emp);

    void deleteEmployeeById(Integer empId);

    void deleteEmployeeBatch(List<Integer> empIdList);
}

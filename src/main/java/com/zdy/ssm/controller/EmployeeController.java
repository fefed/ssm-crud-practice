package com.zdy.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zdy.ssm.bean.Emp;
import com.zdy.ssm.service.api.EmployeeService;
import com.zdy.ssm.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/employee/page")
    public Msg getAllEmployees(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo) {
        // 输出测试参数接收的正确性
        System.out.println(pageNo);
        // 分页插件的使用
        PageHelper.startPage(pageNo, 5);
        List<Emp> empList = employeeService.getAllEmployees();
        PageInfo<Emp> pageInfo = new PageInfo<>(empList, 5);
        // 返回分页信息
        return Msg.success().add("pageInfo", pageInfo);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Msg saveEmployee(Emp emp) {
        // 插入Employee
        Integer affectedRows = employeeService.saveEmployee(emp);
        return Msg.success().add("affectedRows", affectedRows);
    }
}

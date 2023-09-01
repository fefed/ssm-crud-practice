package com.zdy.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zdy.ssm.bean.Emp;
import com.zdy.ssm.service.api.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/emps")
    public String getAllEmployees(@RequestParam(value = "pageNo", defaultValue = "1") Integer pageNo, Model model) {
        PageHelper.startPage(pageNo, 5);
        List<Emp> empList = employeeService.getAllEmployees();
        PageInfo<Emp> pageInfo = new PageInfo<>(empList, 5);
        model.addAttribute("pageInfo", pageInfo);
        return "list";
    }
}

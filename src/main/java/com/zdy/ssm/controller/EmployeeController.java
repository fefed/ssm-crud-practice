package com.zdy.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zdy.ssm.bean.Emp;
import com.zdy.ssm.service.api.EmployeeService;
import com.zdy.ssm.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @RequestMapping("/employee/checkName")
    public Msg checkEmpName(@RequestParam("empName") String empName) {
        //1、先判断用户名是否合法
        String regEx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})";
        if (!empName.matches(regEx)) {
            return Msg.fail().add("errorMsg", "用户名必须是2-5位中文或者6-16位英文和数字的组合");
        }
        //2、然后判断用户名是否已经存在
        Boolean valid = employeeService.checkEmpName(empName);
        if (valid)
            return Msg.success();
        else
            return Msg.fail().add("errorMsg", "用户名不可用");
    }

    // 后端校验，JSR303
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Msg saveEmployee(@Valid Emp emp, BindingResult result) {
        // 校验失败
        if (result.hasErrors()){
            // 将错误信息返回
            Map<String, Object> map = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        }else {
            // 插入Employee
            employeeService.saveEmployee(emp);
            return Msg.success();
        }
    }

    @RequestMapping("/employee/{id}")
    public Msg getEmployee(@PathVariable(value = "id") Integer empId) {
        Emp emp = employeeService.getEmployee(empId);
        return Msg.success().add("emp", emp);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public Msg updateEmployee(Emp emp, @PathVariable String id) {
        System.out.println(id + "员工更新");
        employeeService.updateEmployee(emp);
        return Msg.success();
    }
}

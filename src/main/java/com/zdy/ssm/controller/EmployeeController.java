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
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 张东亚
 * @version 1.0
 */
@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    // 获取所用用户
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

    // 检查用户名合法性
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
    public Msg saveEmployee(@Valid @RequestBody Emp emp, BindingResult result) {
        // 校验失败
        if (result.hasErrors()) {
            // 将错误信息返回
            Map<String, Object> map = new HashMap<>();
            for (FieldError error : result.getFieldErrors()) {
                map.put(error.getField(), error.getDefaultMessage());
            }
            return Msg.fail().add("errorFields", map);
        } else {
            // 插入Employee
            employeeService.saveEmployee(emp);
            return Msg.success();
        }
    }

    // 根据id获取用户
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public Msg getEmployee(@PathVariable(value = "id") Integer empId) {
        Emp emp = employeeService.getEmployee(empId);
        return Msg.success().add("emp", emp);
    }

    // 修改用户
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public Msg updateEmployee(@RequestBody Emp emp, @PathVariable String id) {
        System.out.println(id + "员工更新");
        employeeService.updateEmployee(emp);
        return Msg.success();
    }

    // 删除用户(根据id删除和批量删除合并）
    @RequestMapping(value = "/employee/{idStr}", method = RequestMethod.DELETE)
    public Msg deleteEmployeeById(@PathVariable("idStr") String empIdStr) {
        // 批量删除 or 单独删除
        if (empIdStr.contains("-")) {
            String[] idStrings = empIdStr.split("-");
            // 使用流转为List<Integer>
            List<Integer> empIdList = Arrays.stream(idStrings).map(Integer::parseInt).collect(Collectors.toList());
            employeeService.deleteEmployeeBatch(empIdList);
        } else {
            employeeService.deleteEmployeeById(Integer.parseInt(empIdStr));
        }
        return Msg.success();
    }
}

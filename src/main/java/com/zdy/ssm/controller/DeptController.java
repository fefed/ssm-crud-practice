package com.zdy.ssm.controller;

import com.zdy.ssm.bean.Dept;
import com.zdy.ssm.service.api.DeptService;
import com.zdy.ssm.utils.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@Controller
@RestController
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping("/department/all")
    public Msg getAllDept(){
        List<Dept> deptList = deptService.getAllDept();
        return Msg.success().add("deptInfo", deptList);
    }
}

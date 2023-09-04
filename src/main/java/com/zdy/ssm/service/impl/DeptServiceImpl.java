package com.zdy.ssm.service.impl;

import com.zdy.ssm.bean.Dept;
import com.zdy.ssm.mapper.DeptMapper;
import com.zdy.ssm.service.api.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;


    @Override
    public List<Dept> getAllDept() {
        return deptMapper.selectByExample(null);
    }
}

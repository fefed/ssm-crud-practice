package com.zdy.ssm.service.api;

import com.zdy.ssm.bean.Dept;
import com.zdy.ssm.mapper.DeptMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
public interface DeptService {
    List<Dept> getAllDept();
}

package com.zdy.ssm;

import com.zdy.ssm.bean.Dept;
import com.zdy.ssm.bean.Emp;
import com.zdy.ssm.mapper.DeptMapper;
import com.zdy.ssm.mapper.EmpMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author 张东亚
 * @version 1.0
 */
// *1、@RunWith(SpringJUnit4ClassRunner.class)导入SpringTest模块
// *2、@ContextConfiguration指定Spring配置文件的位置
// *3、@autowired要使用的组件即可自动装配
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CRUDTest {
    @Autowired
    EmpMapper empMapper;
    @Autowired
    DeptMapper deptMapper;
    @Autowired
    SqlSession sqlSession;

    @Test
    public void TestMapper(){
        //新增部门信息
        deptMapper.insertSelective(new Dept(null, "开发部"));
        deptMapper.insertSelective(new Dept(null, "测试部"));

        //插入一条员工数据
        empMapper.insertSelective(new Emp(null, "张三", "M", "zhangsan@qq.com", 1));
        empMapper.insertSelective(new Emp(null, "李四", "M", "lisi@163.com", 1));
        empMapper.insertSelective(new Emp(null, "王五", "M", "wangwu@sina.com", 1));

        //批量插入员工数据
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        for (int i = 0; i < 100; i++) {
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            mapper.insertSelective(new Emp(null, uid, "W", uid + "@gmail.com", 2));
        }
    }
}

package com.zdy.ssm;

import com.github.pagehelper.PageInfo;
import com.zdy.ssm.bean.Emp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @author 张东亚
 * @version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:spring.xml", "classpath:springmvc.xml"})
public class MvcTest {
    // 传入MVC的IOC容器
    @Autowired
    WebApplicationContext context;

    // 虚拟MVC请求，获取处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        // 使用mockMvc模拟发出请求，并获取返回值
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").
                param("pageNo", "1")).andReturn();
        // 从请求域中取出pageInfo
        PageInfo<Emp> pageInfo = (PageInfo) (result.getRequest().getAttribute("pageInfo"));
        System.out.println("当前页码：" + pageInfo.getPageNum());
        System.out.println("总页码：" + pageInfo.getPages());
        System.out.println("总记录数：" + pageInfo.getTotal());
        System.out.println("在页面需要连续显示的页码");
        for (int i : pageInfo.getNavigatepageNums()) {
            System.out.println(" " + i);
        }
        //获取员工数据
        List<Emp> list = pageInfo.getList();
        for (Emp employee : list) {
            System.out.println("ID：" + employee.getEmpId() + "==>Name:" + employee.getEmpName());
        }
    }
}

## SSM-CRUD 
### 项目简介
使用 SSM(Spring+SpringMVC+MyBatis) 框架实现极简的员工管理系统，适用于ssm初学者练手

### 实现功能
1、分页展示员工信息 

2、添加员工信息(前端校验+后端校验)

3、修改员工信息 

4、删除员工信息(单条删除+批量删除)

### 实现技术
1、数据库：MySQL8

2、后端框架
- 构建工具：Maven
- 数据访问：MyBatis + Druid 数据库连接池
- 表述层和业务层：Spring 5 + Spring MVC 
- 视图模板：thymeleaf

3、前端框架：BootStrap + Vue + Axios


### 实现效果
[![pPssy5R.png](https://s1.ax1x.com/2023/09/06/pPssy5R.png)](https://imgse.com/i/pPssy5R)


### 项目搭建过程
1、创建webapp类型的maven项目

2、搭建项目目录结构

[![pPsyWYn.png](https://s1.ax1x.com/2023/09/06/pPsyWYn.png)](https://imgse.com/i/pPsyWYn)

3、pom.xml引入依赖
- Spring/SpringMVC/ServletAPI
- MyBatis核心/Mybatis与Spring整合/MyBatis分页插件
- MySQL驱动/Druid连接池
- junit测试/日志/json处理/JSR303校验
- ……

4、配置web.xml
- 配置 监听器实现Spring启动加载 
- 配置 SpringMVC前端控制器 
- 配置 编码过滤器 / Hidden请求方法过滤器

5、配置表述层 => springmvc.xml
- 开启 controller包的组件扫描
- 配置 thymeleaf视图解析器 
- 配置 默认servlet处理器 
- 配置 view controller 
- 开启注解驱动 
- 配置文件上传解析器、拦截器interceptor、异常处理器……

6、配置ApplicationContext
- 创建数据库连接配置文件jdbc.properties
- 配置mybatis配置文件
- 配置spring.xml
  1. 开启 组件扫描,扫描业务层和数据访问层组件
  2. 引入 JDBC配置文件 
  3. 配置 数据源/连接池 
  4. 配置 SqlSessionFactoryBean,配置MyBatis 
  5. 开启 Mapper接口扫描 
  6. 配置 事务管理器

7、配置日志
- log4j.xml
- logback.xml

8、创建数据库
- 创建数据库并建表

9、Mybatis逆向工程
- 配置mybatis-generator => generatorConfig.xml
- Maven插件运行mybatis-generator，生成Mapper和对应的xml

10、引入前端框架
- Bootstrap、JQuery、Vue、Axios

11、开发
- 前端页面
- 后端controller和service

12、部署运行
- 配置Tomcat9服务器，部署运行

### 遇到的问题
1. springmvc.xml显示File is included in 4 contexts
   ```
   解决：进入Project Structure的Modules设置，删除IDEA自动检测的Application Servlet Context，手动添加当前配置文件
   ```
2. log4j.xml配置文件“http//jakarta.apache.org/log4j/”报错，URL未注册
   ```
   修改头部为：
   <?xml version="1.0" encoding="UTF-8" ?>
   <!DOCTYPE log4j:configuration SYSTEM "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
   <log4j:configuration debug="true">
   ```
3. generatorConfig.xml文件头部约束文件报错：URI is not registered (Settings | Languages & Frameworks | Schemas and DTDs) in applicationContext.xml
   ```
   直接Fetch external resource.将文件获取到本地
   ```
4. 定义视图控制器<mvc:view-controller path="/" view-name="index"/>视图名称爆红，Cannot resolve symbol 'index' 
   ```
   开启mvc注解驱动后，项目运行正常，不受影响；但是，爆红未解决
   ```
5. mybatis映射xml配置文件报错:＜statement＞ or DELIMITER expected, got ‘dept_id‘
   ```
   方法1. 报错属性的快速解决方案中打开Language Injection Setting, 删除XML Tag/Local Name中的sql，关闭对sql节点的语法检查
   方法2. 添加诸如<sql id="xx"> <if test="true"> 属性... </if> </sql>的语法，使之符合SQL标签语法
   ```
6. 前端使用Axios发送post请求(使用data传输数据)，后端使用@RequestParam接收不到参数
   ```
   原因：Axios在发送post请求时会自动帮我们把data域参数转化为json并放入请求体，传输类型为application/json；
   而@RequestParam只能从字符串中解析参数
   方法一：后端使用@RequestBody接收
   方法二：前端axios请求配置中data改为params，axios会将参数拼接为url后字符串
   ```
7. 响应Ajax请求时，返回对象，利用@ResponseBody注解和Jackson依赖自动转化为json对象，但是缺少属性
   ```
   该实现机制需要getter支持，所以必须在返回对象所对应的类中实现属性的get方法
   ```
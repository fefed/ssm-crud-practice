## 遇到的问题
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
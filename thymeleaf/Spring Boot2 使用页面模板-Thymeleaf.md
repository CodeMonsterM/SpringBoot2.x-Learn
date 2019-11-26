# Spring Boot-使用页面模板-Thymeleaf

#### 前言

Thymelean，是当前比较流行的模板框架，是Spring Boot官方推荐使用的模板框架

#### 使用

1. 在项目的**pom**文件中添加 ==**spring-boot-starter-thymeleaf**== 依赖

   ```java
           <!--thymeleaf依赖-->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-thymeleaf</artifactId>
           </dependency>
   ```

   

   > Thymeleaf对HTML的校验特别严格，比如标签没有结束可能会造成未知的困惑
   >
   > 因此我们还需要引入 **==nekohtml==** 依赖来避免这个“坑”

   ```java
           <!--引入nekohtml依赖：去除HTML严格校验-->
           <dependency>
               <groupId>net.sourceforge.nekohtml</groupId>
               <artifactId>nekohtml</artifactId>
               <version>1.9.22</version>
           </dependency>
   ```

   

2. 在==**application.properties**==配置文件中对Thymeleaf进行配置：编码格式，缓存设置，文件前后缀等

   ```properties
   #thymeleaf-编码设置
   spring.thymeleaf.encoding=utf-8
   #thymeleaf-缓存设置，开发时建议关闭，否则更改页面后不会实时展示效果
   spring.thymeleaf.cache=false
   #thymeleaf-去除HTML的严格校验
   spring.thymeleaf.mode=LEGACYHTML5
   #thymeleaf-模板文件前缀
   spring.thymeleaf.prefix=classpath:/templates/
   #thymeleaf-模板文件后缀
   spring.thymeleaf.suffix=.html
   ```

   

3. 创建IndexController和HTML进行测试

   **==IndexController==**

   ```java
   @Controller
   public class IndexController {
   
       @GetMapping("/")
       public String index(ModelMap modelMap){
           modelMap.addAttribute("MSG","Hello,MING !");
           return "index";
       }
   }
   ```

   ==**HTML**==

   ```html
   <!DOCTYPE html>
   <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
   <head>
       <meta charset="UTF-8">
       <title>index</title>
   </head>
   <body>
   <h1 th:text="${MSG}"></h1>
   </body>
   </html>
   ```

   

4. 访问<http://localhost:8080/>

   

![](https://i.loli.net/2019/11/26/P85Z7SeBqsmuMtI.png)

#### 总结

至此，Spring Boot整合Thymeleaf完成

#### Thymeleaf常用语法

1. th:text     设置当前元素的文本内容
2. th:value  设置当前元素的值
3. th:each    循环遍历元素，一般配合上面两个语法使用
4. th:attr      设置当前元素的属性
5. th:if |th:switch|th:case|th:unless 用作条件判断
6. th:insert|th:replace|th:include  代码块引入，一般用于提取公共文件，或者引用公共静态文件等

#### 遇到的“坑”

1. Error resolving template [index], template might not exist or might not be accessible by any of the configured

**解决方案：**

经过检查后发现是配置文件里的的模板前缀路径没设置正确

![](https://i.loli.net/2019/11/26/zAMqoh81wS6Ffta.png)

之前templates后少了一个 **==/==**
# Spring Boot-使用页面模板-FreeMarker

#### 前言

FreeMarker，与Thymeleaf相似的模板框架，无论是配置还是语法都相似

#### 使用

1. 在项目的**pom**文件中添加 ==**spring-boot-starter-freemarker**== 依赖

   ```java
           <!--thymeleaf依赖-->
           <dependency>
               <groupId>org.springframework.boot</groupId>
               <artifactId>spring-boot-starter-freemarker</artifactId>
           </dependency>
   ```

2. 在==**application.properties**==配置文件中对FreeMarker进行配置：编码格式，缓存设置，文件前后缀等

   ```properties
   #freemarker-编码设置
   spring.freemarker.encoding=utf-8
   #freemarker-缓存设置，开发时建议关闭，否则更改页面后不会实时展示效果
   spring.freemarker.cache=false
   #freemarker-模板文件前缀
   spring.freemarker.template-loader-path=classpath:/templates/
   #freemarker-模板文件后缀,注意这里后缀名是.ftl
   spring.freemarker.suffix=.ftl
   ```

   

3. 创建IndexController和在 src/resources/templates 下创建index.**ftl**进行测试

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

   ==**index.ftl**==

   ```html
   <!DOCTYPE html>
   <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml">
   <head>
       <meta charset="UTF-8">
       <title>index</title>
   </head>
   <body>
   <h1>${MSG}</h1>
   </body>
   </html>
   ```

   

4. 访问<http://localhost:8080/>

   

![](https://i.loli.net/2019/11/26/P85Z7SeBqsmuMtI.png)

#### 总结

至此，Spring Boot整合FreeMarker完成

#### FreeMarker常用语法

1. **${XXX}**    通用赋值格式

   - 后台返回键值对 a=string，可以使用${a?string} 
   - 后台返回键值对 a="2019-11-26 23:30",可以使用${a?string("EEE,MMM d,yy")}，输出：星期二，11月 26,19
   - 后台返回键值对 a=false，可以使用${a?string(“是”，“否”)}，输出：否

2. **#{XXX}或者#{XXX;format}**  数值赋值格式

      format 可以是以下格式（X 和 Y 为数字)

    - mX  小数部分最小X位

    - MX  小数部分最大X位

    - mXMY  小数部分最小X位，最大Y位

      

3. **常用内建函数**

   - html 对字符串进行HTML编码
   - lower_case  字符串转小写
   - upper_case  字符串转大写
   - trim     去除前后空格
   - size       获取集合元素数量
   - int        获取数字部分

4. **常用指令**

   - if  elseif else 分支控制语句
   - list    输出集合数据
   - import   导入变量
   - include   类似于包含指令

#### 遇到的“坑”

暂时没遇到
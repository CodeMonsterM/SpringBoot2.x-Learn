## Spring Boot使用WebJars

#### 前言

整合WebJar以便进行前端静态JavaScript和CSS

#### 使用

1. 添加pom依赖：bootstrap ,jquery

```java
        <!--引用Bootstrap-->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>bootstrap</artifactId>
            <version>3.3.7-1</version>
        </dependency>

        <!--引用jQuery-->
        <dependency>
            <groupId>org.webjars</groupId>
            <artifactId>jquery</artifactId>
            <version>3.3.1-1</version>
        </dependency>
```

2. 在src/recources/static文件夹下新建index.html

   ```html
   <!DOCTYPE html>
   <html lang="en">
   <head>
       <meta charset="UTF-8">
       <title>Title</title>
       <link rel="stylesheet" href="/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css">
       <script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
       <script src="/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js"></script>
   </head>
   <body>
       <div class="container">
           <br/>
           <div class="alert alert-success">
               <a href="#" class="close" data-dismiss="alert" aira-label="close">
                   x
               </a>
               Hello,<strong>Ming !</strong>
           </div>
       <br/>
           <button class="btn btn-primary btn-lg" id="btn">获取a标签内容</button>
       </div>
   </body>
   
   <script type="text/javascript">
       $("#btn").click(function () {
           alert($('.close').attr('href'));
       })
   
   </script>
   </html>
   ```

   

3. 访问 <http://localhost:8080/> 点击按钮变可弹出 并获取<a>标签的值

   ![](https://img04.sogoucdn.com/app/a/100520146/a8d42d04aff8971f30efa37003de0adf)



#### 总结

WebJars还提供了很多其他的依赖，具体使用可以查看官网

[WebJar]: https://www.webjars.org/	"WebJars"


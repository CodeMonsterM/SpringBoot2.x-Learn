package vip.acgcode.springboot.spring_boot_start_webflux.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;
import vip.acgcode.springboot.spring_boot_start_webflux.handle.HelloHandle;

/**
 * 定义路由信息，每个路由都会映射到对应的处理方法（功能类似于：@RequestMapping）
 * 当接收到对应Http请求后，通过RouterFunctions.route(RequestPredicate,HandlerFunction)
 *  提供一个路由器函数的默认实现
 */
@Configuration
public class HelloRouter {
    @Bean
    public RouterFunction<ServerResponse> routerHello(HelloHandle helloHandle){
        return RouterFunctions.route(
                RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)),
                helloHandle::hello);
    }
}

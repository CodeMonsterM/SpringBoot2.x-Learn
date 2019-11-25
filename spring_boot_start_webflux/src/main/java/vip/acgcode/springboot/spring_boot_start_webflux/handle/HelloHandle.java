package vip.acgcode.springboot.spring_boot_start_webflux.handle;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Component 用于将类实例化到Spring容器中
 */
@Component
public class HelloHandle {

    /**
     * Mono<ServerResponse> ---响应对象
     * ServerResponse：包含响应状态，响应头信息等
     * @param request
     * @return 字符串
     */
    public Mono<ServerResponse> hello(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).
                body(BodyInserters.
                        fromObject("Hello This is SpringBoot webFlux project!"));
    }
}

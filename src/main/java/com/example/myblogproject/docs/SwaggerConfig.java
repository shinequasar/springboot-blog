package com.example.myblogproject.docs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Want blog project",
                "내 블로그만들기 프로젝트 API 문서",
                "0.01",
                "https://github.com/shinequasar/springboot-blog.git",
                new Contact("Contact Me", "https://github.com/shinequasar/springboot-blog.git", "shinequasar@naver.com"),
                "Licenses",
                "https://github.com/shinequasar/springboot-blog.git",
                new ArrayList<>()
        );
    }

    @Bean
    public Docket apiV1(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(this.apiInfo())
                .groupName("myblog APIs")
                .select()
                .apis(RequestHandlerSelectors.
                        basePackage("com.example.myblogproject.controller")).build();
    }

    //여러 그룹을 지정하고 싶다면 이런식으로 여러개 만들명 ok
//    @Bean
//    public Docket apiV2(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(this.apiInfo())
//                .useDefaultResponseMessages(false)
//                .groupName("groupName2")
//                .select()
//                .apis(RequestHandlerSelectors.
//                        basePackage("javable.controller"))
//                .paths(PathSelectors.ant("/posts/**")).build();
//    }
}
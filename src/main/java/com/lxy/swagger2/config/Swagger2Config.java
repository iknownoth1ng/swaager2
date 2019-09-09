package com.lxy.swagger2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @program: swagger2-demo
 * @description:
 * @author: lxy
 * @create: 2019-09-07 18:30
 */
@Configuration
@EnableSwagger2//开启swagger2
public class Swagger2Config {
    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("lxy");

    }



    //配置了swagger2的docket的bean实例
    @Bean
    public Docket docket(Environment environment){
        //设置要显示的swaager环境
        Profiles profiles=Profiles.of("dev","test");
        //判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);
        System.out.println(flag);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("jade")
                .enable(flag)
                .select()
                //RequestHandlerSelectors配置要扫描接口的方式
                //basePackage指定要扫描的包
                //any()；扫描全部
                //withClassAnnotation：扫描类上的注解
                //withMethodAnnotation：扫描方法上的注解
                .apis(RequestHandlerSelectors.basePackage("com.lxy.swagger2.controller"))
                //过滤路径
                .paths(PathSelectors.any())
                .build();
    }
    //配置了swagger2的信息
    private ApiInfo apiInfo(){
        //作者信息
        Contact contact=new Contact("lxy",
                "http://www.baidu.com",
                "000@qq.com");
        return new ApiInfo(
                "swaggerAPI文档",
                "我的第一次swagger尝试",
                "v1.0",
                "http://www.google.com",
                contact,
                "Apache2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}

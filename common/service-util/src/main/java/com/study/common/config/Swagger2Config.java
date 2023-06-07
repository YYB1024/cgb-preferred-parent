package com.study.common.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * swagger2配置
 *
 * @author yangyanbin
 * @date 2023/06/07
 * @since 20230607
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private Set<String> produces() {
        Set<String> produces = new HashSet<>();
        produces.add("application/json");
        return produces;
    }

    private Class[] ignoredParameterTypes() {
        return new Class[]{HttpSession.class, HttpServletRequest.class, HttpServletResponse.class};
    }

    private List<RequestParameter> globalRequestParameters(){
        //添加head参数start
        List<RequestParameter> pars = new ArrayList<>();
        pars.add(new RequestParameterBuilder().name("token")
                .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder.model(modelSpecificationBuilder -> modelSpecificationBuilder.scalarModel(ScalarType.STRING)))
                .description("token")
                .in(ParameterType.HEADER).required(false).build());

        pars.add(new RequestParameterBuilder().name("user_id")
                .query(simpleParameterSpecificationBuilder -> simpleParameterSpecificationBuilder.model(modelSpecificationBuilder -> modelSpecificationBuilder.scalarModel(ScalarType.STRING)))
                .description("用户id，本地测试使用")
                .in(ParameterType.HEADER).required(false).build());
        //添加head参数end
        return pars;
    }

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("webApi")
                .apiInfo(webApiInfoConfig())
                .produces(produces())
                .ignoredParameterTypes(ignoredParameterTypes())
                .globalRequestParameters(globalRequestParameters())
                .select()
                .paths(PathSelectors.regex("/api/.*"))
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .apis(RequestHandlerSelectors.basePackage("com.stuty"))
                .build();
    }

    private ApiInfo webApiInfoConfig() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("API 文档")
                .license("license by odbpo")
                .version("1.0")
                .build();
    }



}

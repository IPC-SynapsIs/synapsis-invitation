package org.synapsis.invitation.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.synapsis.invitation.bean.Invitation;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@ComponentScan(basePackageClasses = {
        Invitation.class
})
public class SwaggerConfig {
    @Bean
    public Docket api() {
        ApiInfo info = new ApiInfo(
                "Synapsis Invitation Microservice",
                "Synapsis Invitation Microservice allowing users to send invitation to other people",
                "1.0.0",
                "http://terms-of-service.url",
                "Marvell IKOUNGA <marvell.ikounga@gmail.com>",
                "License", "http://www.apache.org/licenses/LICENSE-2.0");
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(info)
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.synapsis.invitation.resource"))
                .paths(PathSelectors.any())
                .build();
    }

}
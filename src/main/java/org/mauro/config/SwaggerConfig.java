package org.mauro.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    private final String buildVersion;
    private final String projectName;
    private final String projectDescription;

    public SwaggerConfig(final @Value("${info.app.version}") String buildVersion,
                         final @Value("${info.app.name}") String projectName,
                         final @Value("${info.app.description}") String projectDescription) {
        this.buildVersion = buildVersion;
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("api-v1")
                .apiInfo(new ApiInfoBuilder()
                                 .version(buildVersion)
                                 .title(projectName)
                                 .description(projectDescription)
                                 .build())
                .useDefaultResponseMessages(false)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/template/v1/.*"))
                .build();
    }
}

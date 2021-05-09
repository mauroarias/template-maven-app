package org.mauro.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
    public OpenAPI api() {
        final Info info = new Info().title(projectName).description(projectDescription).version(buildVersion);
//        final Components components = new Components().addSecuritySchemes("basicSchema", new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic"));
//        return new OpenAPI().components(components).info(info);
        return new OpenAPI().info(info);
    }

//    @Bean
//    public GroupedOpenApi groupedOpenApi() {
//        return GroupedOpenApi.builder().setGroup("v1").pathsToMatch("template/v1").build();
//    }
//
//    @Bean
//    public GroupedOpenApi groupedOpenApiCompany() {
//        return GroupedOpenApi.builder().setGroup("company").pathsToMatch("template/v1/company").build();
//    }
}

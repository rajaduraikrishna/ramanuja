import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import io.swagger.annotations.Api;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).useDefaultResponseMessages(false)
                .genericModelSubstitutes(ResponseEntity.class).select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfo("Distributed Key Value Store", "This is the system that provides the distribute key value store",
                "API ßTOS", "Terms of service", new Contact("Rajadurai Krishnamoorthy", "www.rajaduraikrishnamoorthy.org", "abc@xyz.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}   
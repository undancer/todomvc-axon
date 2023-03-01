package com.example.app.config

//import org.springframework.context.annotation.Bean
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.context.annotation.Configuration

//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spring.web.plugins.Docket
//import springfox.documentation.swagger2.annotations.EnableSwagger2

//@EnableSwagger2
@Configuration
class SwaggerConfig {

    private var logger: Logger = LoggerFactory.getLogger(SwaggerConfig::class.java)

//    @Bean
//    fun productApi(): Docket {
//        return Docket(DocumentationType.SWAGGER_2).select()
//            .apis(RequestHandlerSelectors.any())
//            .paths(PathSelectors.any())
//            .build()
//    }
}

package com.undancer.app.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.web.reactive.config.WebFluxConfigurer
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig {

    @Bean
    fun webMvcConfigurer(): WebMvcConfigurer = object : WebMvcConfigurer {
        override fun addCorsMappings(registry: org.springframework.web.servlet.config.annotation.CorsRegistry
        ) {
            val methods = HttpMethod.values().map { it.name }.toTypedArray()
            registry.addMapping("/**").allowedMethods(*methods)
        }
    }


    @Bean
    fun webFluxConfigurer(): WebFluxConfigurer = object : WebFluxConfigurer {
        override fun addCorsMappings(registry: org.springframework.web.reactive.config.CorsRegistry) {
            val methods = HttpMethod.values().map { it.name }.toTypedArray()
            registry.addMapping("/**").allowedMethods(*methods)
        }
    }

}
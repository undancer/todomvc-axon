package com.undancer.app.config

import org.springframework.http.HttpMethod
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


class WebMvcConfig : WebMvcConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        val methods = HttpMethod.values().map { it.name() }.toTypedArray()
        registry.addMapping("/**").allowedMethods(*methods)
    }
}

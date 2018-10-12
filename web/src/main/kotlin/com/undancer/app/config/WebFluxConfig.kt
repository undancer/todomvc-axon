package com.undancer.app.config

import org.springframework.http.HttpMethod
import org.springframework.web.reactive.config.CorsRegistry
import org.springframework.web.reactive.config.WebFluxConfigurer


class WebFluxConfig : WebFluxConfigurer {
    override fun addCorsMappings(registry: CorsRegistry) {
        val methods = HttpMethod.values().map { it.name }.toTypedArray()
        registry.addMapping("/**").allowedMethods(*methods)
    }
}
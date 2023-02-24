package com.undancer.app.config

import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@Import(
    WebMvcConfig::class,
    WebFluxConfig::class,
)
class WebConfig

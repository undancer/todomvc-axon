package com.example.app.config

import org.axonframework.eventsourcing.EventSourcingRepository
import org.axonframework.extensions.kotlin.eventSourcingRepositoryBuilder
import org.axonframework.extensions.kotlin.genericJpaRepositoryBuilder
import org.slf4j.Logger
import org.slf4j.LoggerFactory


/**
 * org.axonframework.eventhandling.tokenstore
 * org.axonframework.eventhandling.deadletter.jpa
 * org.axonframework.modelling.saga.repository.jpa
 * org.axonframework.eventsourcing.eventstore.jpa
 */
//@Configuration
class AxonConfig {

    private var logger: Logger = LoggerFactory.getLogger(AxonConfig::class.java)


    fun fun0() {
        genericJpaRepositoryBuilder<Any>().build()
        eventSourcingRepositoryBuilder<Any>().build<EventSourcingRepository<Any>>()
    }

//    fun eventStorageEngine(): EventStorageEngine {
//        var fff = eventSourcingRepositoryBuilder<Any>().build<EventSourcingRepository<Any>>()
//        return JpaEventStorageEngine.builder()
//            .build()
//    }

//    @Bean
//    fun moduleConfig() = ModuleConfiguration { config ->
//        logger.info("module: {}", config.queryGateway())
//        logger.info("module: {}", config.commandGateway())
////        logger.info("module: {}", config.eventGateway())
//    }

//    fun ChainingConverter(){
//        return ChainingConverter()
//    }

}

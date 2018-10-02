package com.undancer.app.config

import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider
import org.axonframework.common.jpa.EntityManagerProvider
import org.axonframework.common.transaction.TransactionManager
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
class AxonConfig {

    @Autowired
    lateinit var transactionManager: PlatformTransactionManager

    @Bean
    fun eventStorageEngineJpa(): EventStorageEngine {
        return JpaEventStorageEngine(entityManagerProvider(), transactionManager())
    }

    @Bean
    fun entityManagerProvider(): EntityManagerProvider {
        return ContainerManagedEntityManagerProvider()
    }

    fun transactionManager(): TransactionManager {
        return SpringTransactionManager(transactionManager)
    }

}

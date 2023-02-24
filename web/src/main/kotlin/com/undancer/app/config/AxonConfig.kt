package com.undancer.app.config

import com.fasterxml.jackson.databind.ObjectMapper
import jakarta.annotation.Resource
import jakarta.persistence.EntityManager
import org.axonframework.common.jpa.EntityManagerProvider
import org.axonframework.common.transaction.TransactionManager
import org.axonframework.eventhandling.TrackingEventProcessor
import org.axonframework.eventhandling.TrackingEventProcessorConfiguration
import org.axonframework.eventhandling.tokenstore.TokenStore
import org.axonframework.eventhandling.tokenstore.jpa.JpaTokenStore
import org.axonframework.eventsourcing.eventstore.EventStorageEngine
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine
import org.axonframework.serialization.Serializer
import org.axonframework.serialization.json.JacksonSerializer
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager
import org.axonframework.springboot.util.jpa.ContainerManagedEntityManagerProvider
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.transaction.PlatformTransactionManager

@Configuration
@EntityScan(
    basePackages = [
        "org.axonframework.eventsourcing.eventstore.jpa",
        "org.axonframework.eventhandling.tokenstore.jpa",
        "org.axonframework.modelling.saga.repository.jpa",
        "com.undancer.app.entity"
    ]
)
class AxonConfig {

    @Resource
    lateinit var objectMapper: ObjectMapper

    @Resource
    lateinit var transactionManager: PlatformTransactionManager

    @Resource
    lateinit var entityManager: EntityManager

    @Bean
    fun eventStorageEngineJpa(): EventStorageEngine {
        return JpaEventStorageEngine.builder()
            .entityManagerProvider(entityManagerProvider())
            .transactionManager(transactionManager())
            .eventSerializer(jacksonSerializer())
            .snapshotSerializer(jacksonSerializer())
            .build()
    }

    @Bean
    fun tokenStoreJpa(): TokenStore {
        return JpaTokenStore.builder()
            .entityManagerProvider(entityManagerProvider())
            .serializer(jacksonSerializer())
//            .claimTimeout(Duration.ofSeconds(30))
            .build()
    }

    fun trackingEventProcessor(): TrackingEventProcessor {
        return TrackingEventProcessor.builder()
            .trackingEventProcessorConfiguration(TrackingEventProcessorConfiguration.forSingleThreadedProcessing())
            .build()
    }

    @Bean
    fun entityManagerProvider(): EntityManagerProvider {
        return ContainerManagedEntityManagerProvider()
            .also { it.entityManager = entityManager }
    }

    fun transactionManager(): TransactionManager {
        return SpringTransactionManager(transactionManager)
    }

    fun jacksonSerializer(): Serializer {
        return JacksonSerializer.builder()
            .objectMapper(objectMapper)
            .build()
    }

}

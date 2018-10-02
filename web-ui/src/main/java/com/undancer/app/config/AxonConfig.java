package com.undancer.app.config;

import org.axonframework.common.jpa.ContainerManagedEntityManagerProvider;
import org.axonframework.common.jpa.EntityManagerProvider;
import org.axonframework.common.transaction.TransactionManager;
import org.axonframework.eventsourcing.eventstore.EventStorageEngine;
import org.axonframework.eventsourcing.eventstore.jpa.JpaEventStorageEngine;
import org.axonframework.spring.messaging.unitofwork.SpringTransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class AxonConfig {

    @Autowired
    PlatformTransactionManager transactionManager;

    @Bean
    public EventStorageEngine eventStorageEngineJpa() {
        return new JpaEventStorageEngine(entityManagerProvider(), transactionManager());
    }

    public EntityManagerProvider entityManagerProvider() {
        return new ContainerManagedEntityManagerProvider();
    }

    public TransactionManager transactionManager() {
        return new SpringTransactionManager(transactionManager);
    }

}

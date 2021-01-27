package com.tcs.service.configs

import io.eventuate.tram.consumer.common.NoopDuplicateMessageDetector
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration

@Configuration

@Import(TramEventsPublisherConfiguration::class, TramMessageProducerJdbcConfiguration::class,
    NoopDuplicateMessageDetector::class)
class CommandConfig {
}
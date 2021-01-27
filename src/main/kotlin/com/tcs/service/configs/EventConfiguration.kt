package com.tcs.service.configs

import com.tcs.service.service.Consumer
import com.tcs.service.service.Producer
import io.eventuate.tram.events.subscriber.DomainEventDispatcher
import io.eventuate.tram.events.subscriber.DomainEventDispatcherFactory
import io.eventuate.tram.spring.consumer.kafka.EventuateTramKafkaMessageConsumerConfiguration
import io.eventuate.tram.spring.events.subscriber.TramEventSubscriberConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import


@Configuration
@Import(EventuateTramKafkaMessageConsumerConfiguration::class, TramEventSubscriberConfiguration::class)
class EventConfiguration {


    @Bean
    fun EventConsumer(): Consumer? {
        return Consumer()
    }

    @Bean
    fun domainEventDispatcher(consumer: Consumer, domainEventDispatcherFactory: DomainEventDispatcherFactory): DomainEventDispatcher? {
        return domainEventDispatcherFactory.make("PostECMRConsumer", consumer.domainEventHandlers())
    }
}
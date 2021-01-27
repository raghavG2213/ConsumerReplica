package com.tcs.service.service

import com.tcs.service.events.DummyEvent
import com.tcs.service.events.PostEcmrEvent
import com.tcs.service.model.Dummy
import com.tcs.service.model.PostECMR
import io.eventuate.common.jdbc.EventuateCommonJdbcOperations
import io.eventuate.common.jdbc.EventuateSchema
import io.eventuate.tram.events.common.DomainEvent
import io.eventuate.tram.events.common.DomainEventNameMapping
import io.eventuate.tram.events.publisher.DomainEventPublisher
import io.eventuate.tram.events.publisher.DomainEventPublisherImpl
import io.eventuate.tram.messaging.common.ChannelMapping
import io.eventuate.tram.messaging.common.MessageInterceptor
import io.eventuate.tram.messaging.producer.common.MessageProducerImpl
import io.eventuate.tram.messaging.producer.jdbc.MessageProducerJdbcImpl
import org.bson.codecs.IdGenerator
import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional
class Producer {

@Autowired
lateinit var  domainEventPublisher: DomainEventPublisher


    fun create(dummy: Dummy) {
        publishTodoEvent(dummy, DummyEvent(dummy.ShipmentId))
    }

    fun publishTodoEvent(Dummy: Dummy, vararg domainEvents: DomainEvent) {
        domainEventPublisher.publish(Dummy::class.java, Dummy.ShipmentId, listOf(*domainEvents))
    }

}
package com.tcs.service.service

import com.tcs.service.events.DummyEvent
import com.tcs.service.model.Dummy
import io.eventuate.tram.events.subscriber.DomainEventEnvelope
import io.eventuate.tram.events.subscriber.DomainEventHandlers
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder
import org.apache.logging.log4j.kotlin.logger
import org.springframework.stereotype.Service
import java.lang.Thread.sleep

@Service
class Consumer {

    fun domainEventHandlers(): DomainEventHandlers {


        return DomainEventHandlersBuilder
                .forAggregateType(Dummy::class.java.name)
                .onEvent(DummyEvent::class.java) { dee: DomainEventEnvelope<DummyEvent> -> run {
                    val dummyEvent: DummyEvent = dee.event

                    val logger = logger()

                    logger.info("EVENT REGISTERED")

                    sleep(75000)
                    logger.info(dummyEvent.ShipmentId)

                }

                }.build()
    }
}

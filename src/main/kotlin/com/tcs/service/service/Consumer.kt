package com.tcs.service.service

import com.tcs.service.constant.URLPath.BASE_URI
import com.tcs.service.edt.model.PrepareECMR
import com.tcs.service.edt.model.PreECMR
import com.tcs.service.model.ASN
import com.tcs.service.model.Dummy
import com.tcs.service.model.PostECMR
import com.tcs.service.utility.Utility
import io.eventuate.tram.events.subscriber.DomainEventEnvelope
import io.eventuate.tram.events.subscriber.DomainEventHandlers
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired
import java.lang.Thread.sleep

@Service
class Consumer {

    @Autowired
    lateinit var producer: Producer

    @Autowired
    lateinit var prepareJson: PrepareJson


//    fun domainEventHandlers(): DomainEventHandlers {

//        return DomainEventHandlersBuilder
//                .forAggregateType(PostECMR::class.java.name)
//                .onEvent(PostEcmrEvent::class.java) { dee: DomainEventEnvelope<PostEcmrEvent> ->
//                    val postEcmrEvent: PostEcmrEvent = dee.event
//                    println("dee.message.payload")
//                    println(postEcmrEvent)
//                }.build()
//    }
//
    fun domainEventHandlers(): DomainEventHandlers {

        return DomainEventHandlersBuilder
                .forAggregateType(PrepareECMR::class.java.name)
                .onEvent(PreECMR::class.java) { dee: DomainEventEnvelope<PreECMR> -> run {
                    val pre: PreECMR = dee.event

                    println("EVENT REGISTERED")

                    sleep(75000)
                    println(pre.shipment_id)

                    producer.create(Dummy(pre.shipment_id))
                }

                }.build()
    }
}

package com.tcs.service.events

import io.eventuate.tram.events.common.DomainEvent

class DummyEvent : DomainEvent {

    var ShipmentId: String = ""


    constructor() {}
    constructor(message: String) {
        this.ShipmentId = message

    }
}

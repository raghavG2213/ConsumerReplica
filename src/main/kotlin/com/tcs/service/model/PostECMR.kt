package com.tcs.service.model

import javax.persistence.*

//@Entity
//@Table(name="ecmr")
class PostECMR (message: String) {
    var ShipmentId: String = ""

    init {
        this.ShipmentId = message
    }

}
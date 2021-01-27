package com.tcs.service.edt.model

import javax.persistence.Id


data class PrepareECMR(
        @Id
        val shipment_id: String
)
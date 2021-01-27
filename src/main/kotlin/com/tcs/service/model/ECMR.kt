package com.tcs.service.model

import org.springframework.data.mongodb.core.mapping.Document
import java.util.*
import javax.persistence.Id


@Document(collection = "ecmr")
data class ECMR (

        @Id
        var id: String,
        var shipmentId: String = "",
        var messageNo: String,
        var messageCreationDateTime: String,
        var testIndicator: String?,
        var glnShipFrom: String = "",
        var glnShipTo: String = "",
        var referenceNumberOfTrip: String,
        var yearOfTrip: String,
        var finishedLoadingDateTime: String,
        var freightDocumentId: String?,
        var arcCode: String?,
        var arcCodeNeeded: Boolean = false,
        var statusFlag: String = "Not Created",
        var orderInShipment: MutableList<OrderInShipment>?
)

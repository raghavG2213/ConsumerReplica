package com.tcs.service.model

data class OrderInShipment(
        var referenceNumberPointOfDeparture: String,
        var shipUnit: MutableList<ShipUnit>?
) {
}
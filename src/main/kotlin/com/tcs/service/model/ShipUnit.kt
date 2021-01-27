package com.tcs.service.model

data class ShipUnit(
        var containerTypeGtinPrimaryContainer: String,
        var shipUnitSscc: String,
        var numberOfPrimaryContainers: Int,
        var totalLoadWeight: Int,
        var containerInShipItems: MutableList<ContainerInShipItems>
) {
}
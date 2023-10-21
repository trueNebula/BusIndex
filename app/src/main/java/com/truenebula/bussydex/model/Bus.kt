package com.truenebula.bussydex.model

class Bus(
    val name: String = "unknown",
    val description: String = "unknown",
    var spotted: Boolean = false,
    var dateAdded: String = "01/01/1970",
    var dateSpotted: String = "01/01/1970",
)
package com.truenebula.bussydex.model

import java.io.Serializable

data class Bus(
    val id: Number,
    var name: String = "unknown",
    var description: String = "unknown",
    var spotted: Boolean = false,
    var dateAdded: String = "01/01/1970",
    var dateSpotted: String = "01/01/1970",
) : Serializable
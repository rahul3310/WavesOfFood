package com.wavesoffood.datamodels

data class PendingOrderData(
    val customerName : String,
    val quantity : Int,
    val orderState : Boolean
)

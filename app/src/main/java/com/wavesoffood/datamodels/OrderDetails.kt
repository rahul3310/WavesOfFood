package com.wavesoffood.datamodels

data class OrderDetails(
    val customerName : String,
    val deliveryStatus : Boolean,
    val paymentStatus : Boolean
)

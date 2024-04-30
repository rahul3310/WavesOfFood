package com.wavesoffood.datamodels

data class MenuItemDetails(
    val itemName :String,
    val itemPrice : String,
    val itemImage : Int,
    var quantity:Int = 1,
    val restaurantName : String = "",
    val isRecentBuy : Boolean = false
)

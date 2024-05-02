package com.wavesoffood.datamodels

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MenuItemDetails(
    val itemName :String,
    var itemPrice : Int,
    val itemImage : Int,
    var quantity:Int = 1,
    val restaurantName : String = "",
    val isRecentBuy : Boolean = false
):Parcelable

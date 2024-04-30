package com.wavesoffood.utils

import com.wavesoffood.datamodels.MenuItemDetails

fun interface ButtonClickCallBacks {
    fun onAddToCartClicked(menuItem: MenuItemDetails)
}
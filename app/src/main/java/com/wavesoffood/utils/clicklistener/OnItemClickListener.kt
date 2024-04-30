package com.wavesoffood.utils.clicklistener

import com.wavesoffood.datamodels.MenuItemDetails

interface OnItemClickListener {
    fun onItemClick(menuItemDetails: MenuItemDetails)
}
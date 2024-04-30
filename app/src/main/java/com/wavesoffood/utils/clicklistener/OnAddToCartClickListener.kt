package com.wavesoffood.utils.clicklistener

import com.wavesoffood.datamodels.MenuItemDetails

    interface OnAddToCartClickListener {
        fun onAddToCartClicked(menuItem: MenuItemDetails)
    }

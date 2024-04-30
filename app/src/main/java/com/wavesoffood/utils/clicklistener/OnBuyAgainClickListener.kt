package com.wavesoffood.utils.clicklistener

import com.wavesoffood.datamodels.MenuItemDetails

 interface OnBuyAgainClickListener {
    fun onBuyAgainClicked(menuItem: MenuItemDetails)
}

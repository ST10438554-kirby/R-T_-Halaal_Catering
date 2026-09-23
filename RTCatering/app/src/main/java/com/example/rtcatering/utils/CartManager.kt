package com.example.rtcatering.utils

import com.example.rtcatering.models.CartItem
import com.example.rtcatering.models.Product

object CartManager {

    val items = mutableListOf<CartItem>()

    fun addItem(product: Product, quantity: Int) {

        val existingItem = items.find {
            it.product.id == product.id
        }

        if (existingItem != null) {
            existingItem.quantity += quantity
        } else {
            items.add(
                CartItem(
                    product = product,
                    quantity = quantity
                )
            )
        }
    }

    fun updateQuantity(productId: Int, quantity: Int) {

        val item = items.find {
            it.product.id == productId
        }

        if (item != null) {
            item.quantity = quantity
        }
    }

    fun removeItem(productId: Int) {

        items.removeAll {
            it.product.id == productId
        }
    }

    fun getTotal(): Double {

        return items.sumOf {
            it.getSubtotal()
        }
    }

    fun clearCart() {
        items.clear()
    }
}
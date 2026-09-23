package com.example.rtcatering.utils

import com.example.rtcatering.models.Order

object OrderManager {

    private val orders = mutableListOf<Order>()

    fun addOrder(order: Order) {
        orders.add(order)
    }

    fun getOrders(): List<Order> {
        return orders.toList()
    }

    fun clearOrders() {
        orders.clear()
    }
}
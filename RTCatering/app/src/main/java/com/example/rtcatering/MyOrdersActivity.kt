package com.example.rtcatering

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.rtcatering.utils.OrderManager
import java.util.Locale

class MyOrdersActivity : AppCompatActivity() {

    private lateinit var ordersContainer: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_my_orders)

        ordersContainer =
            findViewById(R.id.ordersContainer)

        val tvBack =
            findViewById<TextView>(R.id.tvBack)

        tvBack.setOnClickListener {
            finish()
        }

        displayOrders()
    }

    private fun displayOrders() {

        ordersContainer.removeAllViews()

        val orders =
            OrderManager.getOrders()

        if (orders.isEmpty()) {

            val emptyText =
                TextView(this)

            emptyText.text =
                "You have no orders yet.\n\nPlace your first catering order to see it here."

            emptyText.textSize = 18f

            emptyText.gravity =
                Gravity.CENTER

            emptyText.setPadding(
                20,
                80,
                20,
                20
            )

            emptyText.setTextColor(
                getColor(R.color.rt_text_primary)
            )

            ordersContainer.addView(
                emptyText
            )

            return
        }


        for (order in orders.reversed()) {

            val card =
                LinearLayout(this)

            card.orientation =
                LinearLayout.VERTICAL

            card.setPadding(
                20,
                20,
                20,
                20
            )

            card.setBackgroundResource(
                R.drawable.card_background
            )


            val params =
                LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
                )

            params.setMargins(
                0,
                0,
                0,
                20
            )

            card.layoutParams = params


            val title =
                TextView(this)

            title.text =
                "Order ${order.orderNumber}"

            title.textSize =
                20f

            title.setTextColor(
                getColor(R.color.rt_primary)
            )

            title.setTypeface(
                null,
                android.graphics.Typeface.BOLD
            )


            val details =
                TextView(this)

            details.text =
                String.format(
                    Locale.getDefault(),
                    "\nEvent Date: %s\n" +
                            "Guests: %d\n" +
                            "Order Type: %s\n" +
                            "Payment: %s\n" +
                            "Total: R %.2f\n" +
                            "Paid: R %.2f\n" +
                            "Balance: R %.2f",
                    order.eventDate,
                    order.guests,
                    order.orderType,
                    order.paymentType,
                    order.total,
                    order.amountPaid,
                    order.balance
                )

            details.textSize =
                16f

            details.setTextColor(
                getColor(R.color.rt_text_primary)
            )


            card.addView(title)
            card.addView(details)

            ordersContainer.addView(card)
        }
    }
}
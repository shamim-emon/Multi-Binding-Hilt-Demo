package com.emon.multibinding

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.emon.multibinding.paymentProcessor.PaymentProcessor
import com.emon.multibinding.sender.NotificationSender
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

const val TAG_SET = "Multi-Binding-Hilt-set"
const val TAG_MAP = "Multi-Binding-Hilt-map"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject lateinit var notificationSenders: Set<@JvmSuppressWildcards NotificationSender>
    @Inject lateinit var paymentProcessors: Map<String,@JvmSuppressWildcards PaymentProcessor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        notificationSenders.forEach { it.send("Hello, this is a notification!") }

        paymentProcessors["payPal"]?.processPayment(100.0)
        paymentProcessors["stripe"]?.processPayment(10.0)
        paymentProcessors["googlePay"]?.processPayment(22.0)
    }
}
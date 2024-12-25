package com.emon.multibinding.paymentProcessor

import com.emon.multibinding.TAG_MAP
import timber.log.Timber
import javax.inject.Inject

class PayPalProcessor @Inject constructor() : PaymentProcessor {
    override fun processPayment(amount: Double) {
        Timber.tag(TAG_MAP).d("Processing payment of $$amount through PayPal.")
    }
}
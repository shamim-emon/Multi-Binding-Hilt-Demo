package com.emon.multibinding

import timber.log.Timber
import javax.inject.Inject

interface PaymentProcessor {
    fun processPayment(amount: Double)
}

class GooglePayProcessor @Inject constructor() : PaymentProcessor {
    override fun processPayment(amount: Double) {
        Timber.tag(TAG_MAP).d("Processing payment of $$amount through Google Pay.")
    }
}

class PayPalProcessor @Inject constructor() : PaymentProcessor {
    override fun processPayment(amount: Double) {
        Timber.tag(TAG_MAP).d("Processing payment of $$amount through PayPal.")
    }
}

class StripeProcessor @Inject constructor() : PaymentProcessor {
    override fun processPayment(amount: Double) {
        Timber.tag(TAG_MAP).d("Processing payment of $$amount through Stripe.")
    }
}
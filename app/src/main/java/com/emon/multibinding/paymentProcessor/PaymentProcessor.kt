package com.emon.multibinding.paymentProcessor

interface PaymentProcessor {
    fun processPayment(amount: Double)
}
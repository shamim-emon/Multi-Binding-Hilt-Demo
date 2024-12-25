package com.emon.multibinding.di

import com.emon.multibinding.paymentProcessor.GooglePayProcessor
import com.emon.multibinding.paymentProcessor.PayPalProcessor
import com.emon.multibinding.paymentProcessor.PaymentProcessor
import com.emon.multibinding.paymentProcessor.StripeProcessor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
@InstallIn(SingletonComponent::class)
interface PaymentModule {
    @Binds
    @IntoMap
    @StringKey("payPal")
    fun bindPayPalProcessor(payPalProcessor: PayPalProcessor): PaymentProcessor

    @Binds
    @IntoMap
    @StringKey("stripe")
    fun bindStripeProcessor(stripeProcessor: StripeProcessor): PaymentProcessor


    @Binds
    @IntoMap
    @StringKey("googlePay")
    fun bindGooglePayProcessor(googlePayProcessor: GooglePayProcessor): PaymentProcessor

}
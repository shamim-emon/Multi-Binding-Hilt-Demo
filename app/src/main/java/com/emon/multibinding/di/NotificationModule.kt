package com.emon.multibinding.di

import com.emon.multibinding.EmailSender
import com.emon.multibinding.NotificationSender
import com.emon.multibinding.SmsSender
import dagger.Module
import dagger.hilt.InstallIn
import dagger.Binds
import dagger.multibindings.IntoSet
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NotificationModule {
    @Binds
    @IntoSet
    fun bindEmailSender(emailSender: EmailSender): NotificationSender

    @Binds
    @IntoSet
    fun bindSmsSender(smsSender: SmsSender): NotificationSender
}
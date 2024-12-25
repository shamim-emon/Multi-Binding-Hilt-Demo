package com.emon.multibinding

import timber.log.Timber
import javax.inject.Inject

interface NotificationSender {
    fun send(message: String)
}

class EmailSender @Inject constructor() : NotificationSender {
    override fun send(message: String) {
        Timber.tag(TAG_SET).d("Sending email: $message")
    }
}

class SmsSender @Inject constructor() : NotificationSender {
    override fun send(message: String) {
        Timber.tag(TAG_SET).d("Sending SMS: $message")
    }
}
package com.emon.multibinding.sender

import com.emon.multibinding.TAG_SET
import timber.log.Timber
import javax.inject.Inject

class EmailSender @Inject constructor() : NotificationSender {
    override fun send(message: String) {
        Timber.tag(TAG_SET).d("Sending email: $message")
    }
}
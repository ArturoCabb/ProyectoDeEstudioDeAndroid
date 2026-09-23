package com.example.proyectodetarjetasparaaaprenderandroid.ui

import com.example.proyectodetarjetasparaaaprenderandroid.data.Email
import com.example.proyectodetarjetasparaaaprenderandroid.data.MailboxType
import com.example.proyectodetarjetasparaaaprenderandroid.data.local.LocalEmailsDataProvider

data class ReplyUiState(
    val mailboxes: Map<MailboxType, List<Email>> = emptyMap(),
    val currentMailbox: MailboxType = MailboxType.Inbox,
    val currentSelectedEmail: Email = LocalEmailsDataProvider.defaultEmail,
    val isShowingHomepage: Boolean = true
) {
    val currentMailboxEmails: List<Email> by lazy { mailboxes[currentMailbox]!! }
}
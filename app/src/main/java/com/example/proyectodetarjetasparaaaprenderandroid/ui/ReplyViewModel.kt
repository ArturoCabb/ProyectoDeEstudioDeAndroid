package com.example.proyectodetarjetasparaaaprenderandroid.ui

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import androidx.lifecycle.ViewModel
import com.example.proyectodetarjetasparaaaprenderandroid.data.Email
import com.example.proyectodetarjetasparaaaprenderandroid.data.MailboxType
import com.example.proyectodetarjetasparaaaprenderandroid.data.MailboxType.*
import com.example.proyectodetarjetasparaaaprenderandroid.data.local.LocalEmailsDataProvider

class ReplyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ReplyUiState())
    val uiState: StateFlow<ReplyUiState> = _uiState

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        val mailboxes: Map<MailboxType, List<Email>> =
            LocalEmailsDataProvider.allEmails.groupBy { it.mailbox }
        _uiState.value =
            ReplyUiState(
                mailboxes = mailboxes,
                currentSelectedEmail = mailboxes[Inbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail
            )
    }

    fun updateDetailsScreenStates(email: Email) {
        _uiState.update {
            it.copy(
                currentSelectedEmail = email,
                isShowingHomepage = false
            )
        }
    }

    fun resetHomeScreenStates() {
        _uiState.update {
            it.copy(
                currentSelectedEmail = it.mailboxes[it.currentMailbox]?.get(0)
                    ?: LocalEmailsDataProvider.defaultEmail,
                isShowingHomepage = true
            )
        }
    }

    fun updateCurrentMailbox(mailboxType: MailboxType) {
        _uiState.update {
            it.copy(
                currentMailbox = mailboxType
            )
        }
    }
}
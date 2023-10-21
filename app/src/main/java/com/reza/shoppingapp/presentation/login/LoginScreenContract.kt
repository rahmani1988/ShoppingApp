package com.reza.shoppingapp.presentation.login

import com.reza.shoppingapp.presentation.base.ViewEvent
import com.reza.shoppingapp.presentation.base.ViewSideEffect
import com.reza.shoppingapp.presentation.base.ViewState

class LoginScreenContract {
    sealed interface Event : ViewEvent {
        object OnLoginClicked : ViewEvent
    }

    data class State(
        val isLoading: Boolean = false,
        val error: String? = null
    ) : ViewState

    sealed class Effect : ViewSideEffect {
        object OnError : Effect()
        object OnNavigateToHome : Effect()
    }
}
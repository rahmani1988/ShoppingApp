package com.reza.shoppingapp.presentation.login

import com.reza.shoppingapp.presentation.base.BaseViewModel

class LoginViewModel : BaseViewModel<
        LoginScreenContract.Event,
        LoginScreenContract.State,
        LoginScreenContract.Effect
        >() {
    override fun setInitialState(): LoginScreenContract.State {
        return LoginScreenContract.State()
    }
}

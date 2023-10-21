package com.reza.shoppingapp.presentation.login

import com.google.common.truth.Truth
import com.reza.shoppingapp.data.models.TokenDto
import org.junit.Test
import kotlin.math.log

class LoginViewModelTest {

    private lateinit var loginViewModel: LoginViewModel

    @Test
    fun `on login view model validate loading state default value is false`() {
        // Assemble: no pre-requisite for this test

        // Act
        loginViewModel = LoginViewModel()

        // Assert
        Truth.assertThat(loginViewModel.viewState.value.isLoading).isFalse()
    }

    @Test
    fun `on login view model validate error state default value is null`() {
        // Assemble: no pre-requisite for this test

        // Act
        loginViewModel = LoginViewModel()

        // Assert
        Truth.assertThat(loginViewModel.viewState.value.error).isNull()
    }

    @Test
    fun `on login view model post login returns success with token`() {
        // Assemble

        // Act

        // Assert

    }

    @Test
    fun `on login view model post login returns error with socket connection exception`() {
        //Assemble
        //Act
        //Assert
    }

    @Test
    fun `on login view model post login returns error with http exception`() {
        //Assemble
        //Act
        //Assert
    }
}
package com.github.for_the_win.ui.presentation.signup

import androidx.annotation.StringRes

data class SignUpState(
    val userName: String = "",
    val email: String = "",
    val phone: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val successLogin: Boolean = false,
    val displayProgressBar: Boolean = false,
    @StringRes val errorMessage: Int? = null
)

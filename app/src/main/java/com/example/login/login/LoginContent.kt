package com.example.login.login

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.Login.R
import com.example.logincap3.data.AuthenticationState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    uiState: AuthenticationState,
    onUsernameUpdated: (String) -> Unit,
    onPasswordUpdated: (String) -> Unit,
    onLogin: () -> Unit,
    passwordToggleVisibility: (Boolean) -> Unit,
    onRegister: () -> Unit
){
    UserNameField(authState = uiState, onValueChanged =
    onUsernameUpdated)
    PasswordInputField(
        text = stringResource(id = R.string.password),
        authState = uiState,
        onValueChanged = onPasswordUpdated,
        passwordToggleVisibility =
        passwordToggleVisibility
    )
    LoginButton(
        text = stringResource(id = R.string.sign_in),
        enabled = if (uiState.isValidForm()) {
            !uiState.loading
        } else {
            false
        },
        onLoginClicked = {
            onLogin.invoke()
        },
        isLoading = uiState.loading
    )/*. . .*/}
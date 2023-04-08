package com.github.for_the_win.ui.presentation.login

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.github.for_the_win.ui.presentation.components.EventDialog
import com.github.for_the_win.ui.presentation.components.GradientBorderButtonRound
import com.github.for_the_win.ui.presentation.components.SocialButtons
import com.github.for_the_win.ui.theme.Blue
import com.github.for_the_win.ui.theme.Skyblue
import com.github.for_the_win.ui.theme.Teal200
import com.practice.for_the_win.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    state: LoginState,
    onLogin: (String, String) -> Unit,
    onNavigateToSignUp: () -> Unit,
    onDismissDialog: () -> Unit
) {
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }

    val colors = Brush.verticalGradient(listOf(Teal200, Skyblue))
    val paddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp)
    val focusManager = LocalFocusManager.current

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .background(Blue)
                    .fillMaxSize()
                    .padding(horizontal = 30.dp),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.ftw_logo),
                    contentDescription = "Login Image",
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                )
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text("Email") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Skyblue,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Skyblue,
                        unfocusedLabelColor = Color.White,
                        textColor = Color.White,
                        disabledTextColor = Color.Black,
                        cursorColor = Skyblue
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email,
                        imeAction = ImeAction.Next,
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.moveFocus(FocusDirection.Down)
                    }),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    label = { Text("Password") },
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = Skyblue,
                        unfocusedBorderColor = Color.White,
                        focusedLabelColor = Skyblue,
                        unfocusedLabelColor = Color.White,
                        textColor = Color.White,
                        disabledTextColor = Color.Black,
                        cursorColor = Skyblue
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done,
                    ),
                    keyboardActions = KeyboardActions(onDone = {
                        focusManager.clearFocus()
                        onLogin(emailValue.value, passwordValue.value)
                    }),
                    modifier = Modifier.fillMaxWidth(),
                    trailingIcon = {
                        IconButton(
                            onClick = {
                                passwordVisibility = !passwordVisibility
                            }
                        ) {
                            Icon(
                                imageVector = if (passwordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                contentDescription = "Toggle Password Icon"
                            )
                        }
                    },
                    visualTransformation = if (passwordVisibility) {
                        VisualTransformation.None
                    } else {
                        PasswordVisualTransformation()
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Forgot Password?",
                    style = MaterialTheme.typography.body1,
                    color = Skyblue,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(alignment = Alignment.End)
                        .clickable {
                            // Handle forgot password click
                            // For example, show a dialog with instructions on how to reset the password
                        }
                )
                Spacer(modifier = Modifier.height(25.dp))
                GradientBorderButtonRound(
                    text = stringResource(R.string.login_button_text, "LOG IN"),
                    colors = colors,
                    paddingValues = paddingValues,
                    displayProgressBar = state.displayProgressBar,
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(
                            width = 4.dp,
                            brush = colors,
                            shape = RoundedCornerShape(percent = 50)
                        )
                        // To make the ripple round
                        .clip(shape = RoundedCornerShape(percent = 50))
                        .clickable {
                            onLogin(emailValue.value, passwordValue.value)
                        }
                )
                Spacer(modifier = Modifier.height(25.dp))
                Text(
                    text = "Or log in with",
                    style = MaterialTheme.typography.body1,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(25.dp))
                SocialButtons()
                Spacer(modifier = Modifier.height(25.dp))
                ClickableText(
                    text = buildAnnotatedString {
                        append("Do not have an Account?")

                        withStyle(
                            style = SpanStyle(
                                color = MaterialTheme.colors.primary,
                                fontWeight = FontWeight.Bold
                            )
                        ) {
                            append("Sign up")
                        }
                    }
                ) {
                    onNavigateToSignUp()
                }
            }
        }
    )

    if (state.errorMessage != null) {
        EventDialog(
            errorMessage = state.errorMessage,
            onDismiss = onDismissDialog
        )
    }

}

/*

@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ForthewinTheme {
        LoginScreen()
    }
}

 */
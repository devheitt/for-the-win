package com.practice.userlogin.ui.presentation.login

import android.annotation.SuppressLint
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.for_the_win.ui.presentation.components.EventDialog
import com.github.for_the_win.ui.presentation.components.GradientBorderButtonRound
import com.github.for_the_win.ui.presentation.components.SocialButtons
import com.github.for_the_win.ui.presentation.components.TransparentTextField
import com.github.for_the_win.ui.presentation.signup.SignUpState
import com.github.for_the_win.ui.presentation.signup.SignUpViewModel
import com.github.for_the_win.ui.theme.ForthewinTheme
import com.github.for_the_win.ui.theme.Skyblue
import com.github.for_the_win.ui.theme.Teal200
import com.practice.for_the_win.R

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    state: SignUpState,
    onRegister: (String, String, String, String, String) -> Unit,
    onBack: () -> Unit,
    onDismissDialog: () -> Unit
) {
    val usernameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    var passwordVisibility by remember { mutableStateOf(false) }
    var confirmPasswordVisibility by remember { mutableStateOf(false) }

    val colors = Brush.verticalGradient(listOf(Teal200, Skyblue))
    val context = LocalContext.current.applicationContext
    val paddingValues = PaddingValues(horizontal = 0.dp, vertical = 12.dp)
    val focusManager = LocalFocusManager.current

    Scaffold(
        content = {
            Column(
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.ftw_logo),
                    contentDescription = "App logo",
                    alignment = Alignment.TopCenter,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ){
                    TransparentTextField(
                        textFieldValue = usernameValue,
                        textLabel = "Name",
                        keyboardType = KeyboardType.Text,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next
                    )
                    TransparentTextField(
                        textFieldValue = emailValue,
                        textLabel = "Email",
                        keyboardType = KeyboardType.Email,
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        imeAction = ImeAction.Next
                    )
                    TransparentTextField(
                        textFieldValue = phoneValue,
                        textLabel = "Phone Number",
                        maxChar = 10,
                        keyboardType = KeyboardType.Phone,
                        keyboardActions = KeyboardActions(
                            onNext = { focusManager.moveFocus(FocusDirection.Down) }
                        ),
                        imeAction = ImeAction.Next
                    )
                    TransparentTextField(
                        textFieldValue = passwordValue,
                        textLabel = "Password",
                        keyboardType = KeyboardType.Password,
                        keyboardActions = KeyboardActions(
                            onNext = {
                                focusManager.moveFocus(FocusDirection.Down)
                            }
                        ),
                        imeAction = ImeAction.Next,
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
                        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    TransparentTextField(
                        textFieldValue = confirmPasswordValue,
                        textLabel = "Confirm Password",
                        keyboardType = KeyboardType.Password,
                        keyboardActions = KeyboardActions(
                            onDone = {
                                focusManager.clearFocus()

                                onRegister(
                                    usernameValue.value,
                                    emailValue.value,
                                    phoneValue.value,
                                    passwordValue.value,
                                    confirmPasswordValue.value
                                )
                            }
                        ),
                        imeAction = ImeAction.Done,
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    confirmPasswordVisibility = !confirmPasswordVisibility
                                }
                            ) {
                                Icon(
                                    imageVector = if (confirmPasswordVisibility) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                    contentDescription = "Toggle Password Icon"
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility) VisualTransformation.None else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    GradientBorderButtonRound(
                        text = stringResource(R.string.signup_button_texts, "SIGN UP"),
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
                                onRegister(
                                    usernameValue.value,
                                    emailValue.value,
                                    phoneValue.value,
                                    passwordValue.value,
                                    confirmPasswordValue.value
                                )
                            }

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Or sign up with",
                        style = MaterialTheme.typography.body1,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    SocialButtons()
                    Spacer(modifier = Modifier.height(10.dp))
                    ClickableText(
                        text = buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.White
                                )
                            ) {
                                append("Already have an account? ")
                            }


                            withStyle(
                                style = SpanStyle(
                                    color = MaterialTheme.colors.primary,
                                    fontWeight = FontWeight.Bold
                                )
                            ) {
                                append("Log in")
                            }
                        },
                        onClick = {
                            onBack()
                        }
                    )
                }

            }

            if (state.errorMessage != null) {
                EventDialog(errorMessage = state.errorMessage, onDismiss = onDismissDialog)
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    ForthewinTheme {
        val viewModel: SignUpViewModel = hiltViewModel()
        SignUpScreen(
            state = viewModel.state.value,
            onRegister = { _, _, _, _, _ -> },
            onBack = { },
            onDismissDialog = { }
        )
    }
}
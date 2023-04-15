package com.github.for_the_win.ui.presentation.login

import android.annotation.SuppressLint
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.for_the_win.ui.presentation.components.*
import com.github.for_the_win.ui.theme.ForthewinTheme
import com.github.for_the_win.ui.theme.Skyblue
import com.github.for_the_win.ui.theme.Teal200
import com.github.for_the_win.ui.theme.TealSkyblue
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

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ftw_logo),
            contentDescription = "Login Image",
            contentScale = ContentScale.Inside,
            modifier = Modifier
                .fillMaxWidth()
        )

        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            ConstraintLayout {

                val (surface, fab) = createRefs()

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(600.dp)
                        .constrainAs(surface) {
                            bottom.linkTo(parent.bottom)
                        },
                    color = MaterialTheme.colors.surface,
                    shape = RoundedCornerShape(
                        topStartPercent = 8,
                        topEndPercent = 8
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(MaterialTheme.colors.surface)
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(80.dp)
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            Text(
                                text = "Welcome Back",
                                style = MaterialTheme.typography.h4.copy(
                                    fontWeight = FontWeight.Medium
                                ),
                                modifier = Modifier
                                    .textBrush(TealSkyblue)
                            )
                            Text(
                                text = "Login to your Account",
                                style = MaterialTheme.typography.h5,
                                color = MaterialTheme.colors.onSurface
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.spacedBy(8.dp)
                        ){
                            TransparentTextField(
                                textFieldValue = emailValue,
                                textLabel = "Email",
                                keyboardType = KeyboardType.Email,
                                keyboardActions = KeyboardActions(
                                    onNext = {
                                        focusManager.moveFocus(FocusDirection.Down)
                                    }
                                ),
                                imeAction = ImeAction.Next
                            )
                            TransparentTextField(
                                textFieldValue = passwordValue,
                                textLabel = "Password",
                                keyboardType = KeyboardType.Password,
                                keyboardActions = KeyboardActions(
                                    onDone = {
                                        focusManager.clearFocus()

                                        onLogin(emailValue.value, passwordValue.value)
                                    }
                                ),
                                imeAction = ImeAction.Done,
                                trailingIcon = {
                                    IconButton(
                                        onClick = {
                                            passwordVisibility = !passwordVisibility
                                        }
                                    ) {
                                        Icon(
                                            imageVector = if(passwordVisibility) {
                                                Icons.Default.Visibility
                                            } else {
                                                Icons.Default.VisibilityOff
                                            },
                                            contentDescription = "Toggle Password Icon"
                                        )
                                    }
                                },
                                visualTransformation = if(passwordVisibility) {
                                    VisualTransformation.None
                                } else {
                                    PasswordVisualTransformation()
                                }
                            )
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                text = "Forgot Password?",
                                style = MaterialTheme.typography.body1.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colors.primary
                                ),
                                textAlign = TextAlign.End
                            )
                            Spacer(modifier = Modifier.height(10.dp))
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
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(
                                text = "Or log in with",
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
                                        append("Do not have an Account? ")
                                    }

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
                }
            }
        }


        if (state.errorMessage != null) {
            EventDialog(
                errorMessage = state.errorMessage,
                onDismiss = onDismissDialog
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginPreview() {
    ForthewinTheme {
        val viewModel: LoginViewModel = hiltViewModel()
        LoginScreen(
            state = viewModel.state.value,
            onLogin = { _, _ -> },
            onNavigateToSignUp = { },
            onDismissDialog = { }
        )
    }
}

package com.example.madprojectwork

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@Composable
fun LoginScreen(navController: NavHostController) {
    var phonevalue by remember {
        mutableStateOf("")
    }
    var passwordvalue by remember {
        mutableStateOf("")
    }
    var confirmpasswordvalue by remember {
        mutableStateOf("")
    }
    var isVisible by remember {
        mutableStateOf(true)
    }
    var interactionSource = remember { MutableInteractionSource() }
    var isSignUp by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = peach_bg)
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.catbeer_loginlogo),
            contentDescription = "cat beer logo",
            modifier = Modifier.scale(1.5f)
        )
        Spacer(modifier = Modifier.height(40.dp))
        LoginTextField(
            value = phonevalue,
            onValueChange = { phonevalue = it },
            modifier = Modifier
                .background(color = text_Field, shape = RoundedCornerShape(8.dp))
                .height(64.dp)
                .padding(14.dp),
            label = {
                Text(
                    text = "Phone Number",
                    fontSize = 16.sp,
                    color = icons_Text.copy(alpha = 0.6f),
                    fontWeight = FontWeight.ExtraBold
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.phone_loginscreen),
                    tint = icons_Text,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "phone"
                )
            },
            shape = RoundedCornerShape(8.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))
        LoginTextField(
            value = passwordvalue,
            onValueChange = { passwordvalue = it },
            modifier = Modifier
                .background(color = text_Field, shape = RoundedCornerShape(8.dp))
                .height(64.dp)
                .padding(14.dp),
            label = {
                Text(
                    text = "Password",
                    fontSize = 16.sp,
                    color = icons_Text.copy(alpha = 0.6f),
                    fontWeight = FontWeight.ExtraBold
                )
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.lock_loginscreen),
                    tint = icons_Text,
                    modifier = Modifier.size(30.dp),
                    contentDescription = "lock"
                )
            },
            trailingIcon = {
                Icon(
                    painter = painterResource(id = if (isVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24),
                    contentDescription = "visibility",
                    tint = icons_Text,
                    modifier = Modifier.clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { isVisible = !isVisible }
                )
            },
            shape = RoundedCornerShape(8.dp),
            visualTransformation = if (isVisible) PasswordVisualTransformation() else VisualTransformation.None
        )
        AnimatedVisibility(
            visible = isSignUp,
            enter = slideInVertically(
                animationSpec = tween(
                    durationMillis = 300
                ),
                initialOffsetY = { fullHeight -> -fullHeight },
            ),
            exit = ExitTransition.None
        ) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                LoginTextField(
                    value = confirmpasswordvalue,
                    onValueChange = { confirmpasswordvalue = it },
                    modifier = Modifier
                        .background(color = text_Field, shape = RoundedCornerShape(8.dp))
                        .height(64.dp)
                        .padding(14.dp),
                    label = {
                        Text(
                            text = "Confirm Password",
                            fontSize = 16.sp,
                            color = icons_Text.copy(alpha = 0.6f),
                            fontWeight = FontWeight.ExtraBold
                        )
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.lock_loginscreen),
                            tint = icons_Text,
                            modifier = Modifier.size(30.dp),
                            contentDescription = "lock"
                        )
                    },
                    trailingIcon = {
                        Icon(
                            painter = painterResource(id = if (isVisible) R.drawable.baseline_visibility_off_24 else R.drawable.baseline_visibility_24),
                            contentDescription = "visibility",
                            tint = icons_Text,
                            modifier = Modifier.clickable(
                                interactionSource = interactionSource,
                                indication = null
                            ) { isVisible = !isVisible }
                        )
                    },
                    shape = RoundedCornerShape(8.dp),
                    visualTransformation = if (isVisible) PasswordVisualTransformation() else VisualTransformation.None,
                )
            }
        }
        AnimatedVisibility(
            visible = !isSignUp,
            enter = expandVertically(animationSpec = tween(durationMillis = 200)),
            exit = shrinkVertically(animationSpec = tween(durationMillis = 400))
        ) {
            Column {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Forgot your password?",
                    fontWeight = FontWeight.ExtraBold,
                    color = icons_Text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 6.dp)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { },
                    textAlign = TextAlign.Right
                )
            }
        }
        Spacer(modifier = Modifier.height(28.dp))
        Box(
            modifier = Modifier
                .size(width = 250.dp, height = 60.dp)
                .background(color = icons_Text, shape = CircleShape)
                .clip(CircleShape)
                .clickable {
                    navController.navigate(Screens.HomeScreen.route)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = if (isSignUp) "Sign Up" else "Sign In",
                fontWeight = FontWeight.ExtraBold,
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Divider(Modifier.width(100.dp))
            Text(text = "   Or   ")
            Divider(Modifier.width(100.dp))
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.facebooklogo),
                contentDescription = "facebook logo",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { }
            )
            Spacer(modifier = Modifier.width(24.dp))
            Image(
                painter = painterResource(id = R.drawable.googlelogo),
                contentDescription = "google logo",
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) { }
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 18.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Row {
            Text(text = if (!isSignUp) "Don't have an account? " else "Done Signing Up? ")
            Text(
                text = if (!isSignUp) "Sign Up" else "Sign In",
                color = icons_Text,
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) {
                    isSignUp = !isSignUp
                }
            )
        }
    }
}

@Composable
fun LoginTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    textStyle: TextStyle = TextStyle.Default,
    label: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    singleLine: Boolean = true,
    maxLines: Int = -1,
    minLines: Int = -1,
    shape: Shape = RectangleShape
) {
    BasicTextField(
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.surface,
                shape,
            )
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        enabled = enabled,
        readOnly = readOnly,
        textStyle = textStyle,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        singleLine = singleLine,
        maxLines = maxLines,
        minLines = minLines,
        visualTransformation = visualTransformation,
        cursorBrush = SolidColor(MaterialTheme.colorScheme.primary)
    ) { innerTextField ->
        Row(
            modifier = modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                leadingIcon()
                Spacer(modifier = Modifier.width(8.dp))
            }
            Box(Modifier.weight(1f)) {
                if (value.isEmpty() && label != null) label()
                innerTextField()
            }
            if (trailingIcon != null) {
                Spacer(modifier = Modifier.width(8.dp))
                trailingIcon()
            }
        }
    }
}
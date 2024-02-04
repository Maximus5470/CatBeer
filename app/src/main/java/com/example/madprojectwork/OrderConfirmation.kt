package com.example.madprojectwork

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun ConfirmationPage(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hungryunhappy))

    Column(
        modifier = Modifier
            .background(color = Color(0xFFEEE2DE))
            .fillMaxSize()
            .padding(start = 75.dp),
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(composition = composition,
            modifier = Modifier
                .size(200.dp),
            isPlaying = true,
            iterations = LottieConstants.IterateForever
        )
        Text(text ="please wait while we work on it...",
            modifier = Modifier.fillMaxWidth(),
            color = Color(0xFF8B5D2E),
            style = MaterialTheme.typography.bodyLarge)
    }

}
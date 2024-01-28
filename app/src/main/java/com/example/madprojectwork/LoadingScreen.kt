package com.example.madprojectwork

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
@Preview(showBackground = true)
@Composable
fun Gifload() {

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.beer))

    Column(
        modifier = Modifier
            .background(color = Color(0xFFEEE2DE))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(composition = composition,
            modifier = Modifier
                .size(200.dp),
            isPlaying = true,
            iterations = LottieConstants.IterateForever

        )
        Text(text ="please wait while we work on it...")




    }

}
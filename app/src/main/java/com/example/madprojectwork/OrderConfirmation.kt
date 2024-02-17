package com.example.madprojectwork

import androidx.compose.runtime.Composable
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(200.dp),
            isPlaying = true,
            iterations = LottieConstants.IterateForever
        )
        Text(
            text = "CONFIRM ORDER",
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, top = 20.dp),
            color = Color(0xFF8B5D2E),
            style = MaterialTheme.typography.bodyLarge,
            fontSize = 20.sp,
        )

        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 60.dp, top = 90.dp),

        ){
            Text(text = "DELIVERING TO",
                color = Color(0xFF000000),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
            )
            Text(text = "HOME",
                modifier = Modifier.padding(start = 30.dp),
                color = Color(0xFF000000),
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify
            )
            Divider(modifier = Modifier.padding(top = 20.dp),
                color = Color(0xFF000000),
                thickness = 123.dp)

        }

    }

}
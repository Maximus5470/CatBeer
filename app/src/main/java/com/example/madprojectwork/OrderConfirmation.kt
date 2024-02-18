package com.example.madprojectwork

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg


@Composable
fun ConfirmationPage(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hungryunhappy))

    Column(
        modifier = Modifier
            .background(color = peach_bg)
            .fillMaxSize()
            .padding(horizontal = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(200.dp)
                .padding(end = 30.dp)
            ,
            isPlaying = true,
            iterations = LottieConstants.IterateForever
        )
        Box(
            modifier = Modifier
                .size(width = 250.dp, height = 60.dp)
                .background(color = icons_Text, shape = CircleShape)
                .clip(CircleShape)
                .clickable{

                    navController.popBackStack(Screens.Mainlayout.route, false)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CONFIRM ORDER",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
        }
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ){
            Text(text = "DELIVERING TO",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
            )
            Text(text = "HOME",
                color = Color.Black,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 20.sp,
                textAlign = TextAlign.Justify
            )

        }
        Divider(modifier = Modifier.padding(top = 20.dp, start = 10.dp, end = 10.dp),
            color = Color.Black,
            thickness = 2.dp)

    }

}
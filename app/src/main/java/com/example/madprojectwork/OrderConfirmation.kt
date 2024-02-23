package com.example.madprojectwork

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.madprojectwork.dataclasses.foodList
import com.example.madprojectwork.dataclasses.profileList
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ConfirmationPage(navController: NavController) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.hungryunhappy))
    Column(
        modifier = Modifier
            .background(color = peach_bg)
            .fillMaxSize()
            .padding(start = 5.dp, end = 5.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LottieAnimation(
            composition = composition,
            modifier = Modifier
                .size(200.dp)
                .padding(end = 30.dp),
            isPlaying = true,
            iterations = LottieConstants.IterateForever
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "CONFIRM ORDER",
            color = Color.Black,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            modifier = Modifier
                .size(height = 40.dp, width = 130.dp)
                .background(color = icons_Text, shape = CircleShape)
                .clip(CircleShape)
                .clickable {
                    foodList[index].isOrdered.value = !foodList[index].isOrdered.value
                    navController.popBackStack(Screens.Mainlayout.route, false)
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "CONFIRM",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                color = Color.White,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(12.dp))
        Text(
            text = "How many items do you want?",
            color = icons_Text,
            style = MaterialTheme.typography.bodyMedium,
            fontSize = 16.sp
        )
        var count by remember { mutableIntStateOf(0) }

        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable(onClick = { if (count > 0) count-- })
                    .background(color = icons_Text),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "-",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }

            Spacer(modifier = Modifier.width(10.dp))
            AnimatedContent(
                targetState = count,
                transitionSpec = {
                    if (targetState > initialState) {
                        slideInVertically { -it } with slideOutVertically { it }
                    } else {
                        slideInVertically { it } with slideOutVertically { -it }
                    }
                }, label = ""
            ) { count ->
                Text(
                    "$count",
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .clickable(onClick = { count++ })
                    .background(color = icons_Text),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "+",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
        }

    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 90.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(
                text = "DELIVERING TO",
                color = Color.Gray,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 16.sp,
            )
            Text(
                text = "Home",
                color = icons_Text,
                style = MaterialTheme.typography.bodyMedium,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Divider(
            modifier = Modifier
                .width(100.dp)
                .padding(top = 4.dp, bottom = 2.dp),
            color = Color.Gray,
            thickness = 2.dp
        )
        Text(
            text = profileList[0].address,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            color = Color.Gray,
            modifier = Modifier
                .padding(bottom = 20.dp)
                .width(250.dp),
            textAlign = TextAlign.Center
        )
    }
}
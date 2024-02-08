package com.example.madprojectwork

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favourite() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = peach_bg)
    ) {
        CenterAlignedTopAppBar(
            title = { },
            actions = {
                Icon(
                    Icons.Default.Favorite,
                    contentDescription = null,
                    tint = icons_Text,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(42.dp)
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = text_Field
            ),
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = text_Field)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Favourite",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "V.KARTHICC",
                fontSize = 14.sp,
                overflow = TextOverflow.Ellipsis,
                color = Color.White
            )
            Divider(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .fillMaxWidth(),
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Favourite Foods",
            fontWeight = FontWeight.ExtraBold,
            color = icons_Text,
            fontSize = 28.sp,
            modifier = Modifier.padding(start = 12.dp)
        )
        Box(
            modifier = Modifier
                .padding(12.dp)
                .size(169.dp)
                .background(
                    color = text_Field,
                    shape = RoundedCornerShape(12.dp)
                )
        ) {
            Text(
                text = "Favourite",
                fontSize = 30.sp,
                modifier = Modifier.padding(12.dp),
                textAlign = TextAlign.Center
            )

        }


    }
    //Food_RestaurantLayout(navController = navController, carousel = )
}
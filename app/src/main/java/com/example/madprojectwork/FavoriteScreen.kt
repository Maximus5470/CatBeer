package com.example.madprojectwork

import androidx.compose.foundation.background
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favourite() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = peach_bg)
    ) {
        CenterAlignedTopAppBar(
            title = {

            },
            actions = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Outlined.FavoriteBorder, contentDescription = null,
                        modifier = Modifier.size(32.dp))
                }
            },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "BackArrow")
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = text_Field
            )
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = text_Field)
                .padding(10.dp)
        ) {
            Text(
                text = "Favourite",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(start = 12.dp),
                text = "Monkey D. Luffy",
                fontSize = 15.sp,
                overflow = TextOverflow.Ellipsis,
            )
            Divider(
                modifier = Modifier
                    .padding(vertical = 5.dp)
                    .fillMaxWidth(),
                color = Color.Black
            )
        }
        Row(
            modifier = Modifier
                .padding(top = 24.dp, start = 12.dp, end = 12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Favorite Foods",
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF724D64),
                fontSize = 24.sp
            )
            Text(
                text = "See all",
                color = Color(0xFF724D64),
                fontWeight = FontWeight.Bold
            )
        }

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
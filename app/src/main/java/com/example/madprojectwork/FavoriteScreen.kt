package com.example.madprojectwork

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.madprojectwork.dataclasses.foodList
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Favourite(navController: NavHostController) {
    val likedFoodList = foodList.filter { it.isLiked.value }
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
            modifier = Modifier.padding(start = 12.dp, bottom = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(likedFoodList.size) { page ->
                    Food_RestaurantLayout(
                        navController = navController,
                        carousel = likedFoodList[page]
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 66.dp)
        )
    }
}
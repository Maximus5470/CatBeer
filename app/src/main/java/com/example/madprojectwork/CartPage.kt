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
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ShoppingCart
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.madprojectwork.dataclasses.foodList
import com.example.madprojectwork.dataclasses.profileList
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartScreen(navController: NavHostController) {
    val OrderedFoodList = foodList.filter { it.isOrdered.value }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = peach_bg)
    ) {
        CenterAlignedTopAppBar(
            title = { },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = text_Field,
            ),
            actions = {
                Icon(
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = "Account",
                    tint = icons_Text,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(42.dp)
                )

            }
        )
        Column(
            modifier = Modifier
                .background(color = text_Field)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "My Cart",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = "34 min to Home",
                    fontSize = 20.sp,
                    color = Color.White,
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(19.dp))
        }
        Text(
            text = "Order History",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = icons_Text,
            modifier = Modifier.padding(start = 12.dp, bottom = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(OrderedFoodList.size) { page ->
                    Food_RestaurantLayout(
                        navController = navController,
                        carousel = OrderedFoodList[page],
                        page = page
                    )
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 66.dp)
        )
    }
}
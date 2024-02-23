package com.example.madprojectwork

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Info
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
fun DashboardScreen(navController: NavHostController) {
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
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "Account",
                    tint = icons_Text,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(42.dp)
                )
                Icon(
                    imageVector = Icons.Filled.ExitToApp,
                    contentDescription = "Logout",
                    tint = icons_Text,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(42.dp)
                        .clickable {
                            navController.popBackStack(Screens.LoginScreen.route, false)
                        }
                )
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = null,
                    tint = icons_Text,
                    modifier = Modifier
                        .padding(6.dp)
                        .size(42.dp)
                        .clickable {
                            navController.navigate(Screens.FAQPage.route)
                        }
                )
            },
        )
        Column(
            modifier = Modifier
                .background(color = text_Field)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "My Account",
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )
            Column(
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(
                    text = profileList[0].name.uppercase(Locale.ROOT),
                    fontSize = 14.sp,
                    color = Color.White,
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                color = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Details",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = icons_Text,
            modifier = Modifier.padding(start = 12.dp)
        )
        Column(
            modifier = Modifier.padding(start = 32.dp)
        ) {
            Text(
                text = profileList[0].name,
                fontSize = 14.sp,
                color = Color.Black,
            )
            Text(
                text = profileList[0].phone.value,
                fontSize = 14.sp,
                color = Color.Black,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
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
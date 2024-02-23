package com.example.madprojectwork

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
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
import com.example.madprojectwork.dataclasses.profileList
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field
import java.util.Locale
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQPage(navController: NavHostController) {
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
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back arrow",
                    tint = Color.Black,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(28.dp)
                        .clickable{
                            navController.popBackStack()
                        }
                )
            }
        )
        Column(
            modifier = Modifier
                .background(color = text_Field)
                .padding(horizontal = 16.dp)
        ) {
            Text(
                text = "FAQ",
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
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = "Q: How do I place an order?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = icons_Text
            )
            Text(
                text = "A: You can place an order by selecting the food item you want to order and clicking on the 'Order' button.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Q: How do I cancel an order?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = icons_Text
            )
            Text(
                text = "A: You can cancel an order by selecting the food item you want to cancel and clicking on the 'Cancel' button.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Q: How do I view my order history?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = icons_Text
            )
            Text(
                text = "A: You can view your order history by clicking on the 'Order History' button.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Q: How do I view my profile?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = icons_Text
            )
            Text(
                text = "A: You can view your profile by clicking on the 'Profile' button.",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Q: How do I view my account?",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = icons_Text
            )
            Text(
                text = "A: You can view your account by clicking on the 'Account' button.",
                fontSize = 16.sp
            )
        }
    }
}
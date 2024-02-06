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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun DashboardScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = peach_bg)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = peach_bg)
                .weight(3f)
        )
    }
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
                    tint = Color.White,
                    modifier = Modifier
                        .padding(12.dp)
                        .size(32.dp)
                )
            },
            navigationIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "back arrow",
                    tint = Color.Black,
                    modifier = Modifier.padding(12.dp)
                )
            }
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
                    text = "V.KARTHICC",
                    fontSize = 14.sp,
                    color = Color.White,
                )
                Text(
                    text = "+91 9876543210",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Divider(
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black
            )
            Spacer(modifier = Modifier.padding(8.dp))
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Details",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = icons_Text,
            modifier = Modifier.padding(start = 12.dp)
        )
        Column(
            modifier = Modifier.padding(start = 32.dp)
        ) {
            Text(
                text = "V.KARTHICC",
                fontSize = 14.sp,
                color = Color.Black,
            )
            Text(
                text = "+91 9876543210",
                fontSize = 14.sp,
                color = Color.Black,
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Order History",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = icons_Text,
            modifier = Modifier.padding(start = 12.dp)
        )
        Column(
            modifier = Modifier.padding(start = 32.dp)
        ) {
            Text(
                text = "V.KARTHICC",
                fontSize = 14.sp,
                color = Color.Black,
            )
            Text(
                text = "+91 9876543210",
                fontSize = 14.sp,
                color = Color.Black,
            )
        }
    }
}
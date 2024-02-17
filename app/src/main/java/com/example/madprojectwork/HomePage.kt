package com.example.madprojectwork

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.example.madprojectwork.dataclasses.Screen
import com.example.madprojectwork.dataclasses.foodList
import com.example.madprojectwork.dataclasses.home_fooditem_restaurant
import com.example.madprojectwork.dataclasses.home_foodtype
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun MainLayout(navController: NavHostController) {
    val tabitem = listOf(
        Screen.Favorites,
        Screen.Home,
        Screen.Profile
    )
    var tabindex by remember { mutableIntStateOf(1) }
    val pagerState = rememberPagerState(initialPage = 1, pageCount = { tabitem.size })

    LaunchedEffect(key1 = tabindex) {
        pagerState.animateScrollToPage(tabindex)
    }
    LaunchedEffect(key1 = pagerState.currentPage) {
        tabindex = pagerState.currentPage
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(peach_bg)
    ) {
        Column {
            when (tabindex) {
                0 -> Favourite(navController = navController)
                1 -> HomeScreen(navController = navController)
                2 -> DashboardScreen(navController = navController)
            }
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            TabRow(
                containerColor = icons_Text,
                contentColor = icons_Text,
                selectedTabIndex = tabindex,
                divider = { },
                indicator = { }
            ) {
                tabitem.forEachIndexed { index, item ->
                    Tab(
                        modifier = Modifier.fillMaxWidth().height(64.dp),
                        selected = (index == tabindex),
                        onClick = {
                            tabindex = index
                        },
                        icon = {
                            BottomNavItem(
                                screen = tabitem[index],
                                isSelected = (index == tabindex)
                            )
                        }
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var searchValue by remember {
        mutableStateOf("")
    }

    val foodType = listOf(
        home_foodtype(food = "Starters", image = R.drawable.soup_bowl),
        home_foodtype(food = "Veg", image = R.drawable.vegetableicon),
        home_foodtype(food = "Non-Veg", image = R.drawable.chickenicon),
        home_foodtype(food = "Wraps", image = R.drawable.wrapsicon),
        home_foodtype(food = "Dessert", image = R.drawable.icecreamcupicon),
    )

    val pagerState3 = rememberPagerState(initialPage = 0, pageCount = { foodType.size })
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = peach_bg)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, top = 12.dp)
        ) {
            Text(
                text = " Order a quick yum yum :3",
                color = Color(0xFF724D64)
            )
            Icon(
                painter = painterResource(id = R.drawable.baseline_shopping_cart_24),
                tint = icons_Text,
                contentDescription = "cart",
                modifier = Modifier
                    .clip(CircleShape)
                    .clickable { }
                    .size(30.dp)
            )
        }
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            LoginTextField(
                value = searchValue,
                onValueChange = { searchValue = it },
                modifier = Modifier
                    .background(color = text_Field, shape = RoundedCornerShape(8.dp))
                    .height(64.dp)
                    .padding(14.dp),
                leadingIcon = {
                    Image(
                        painter = painterResource(id = R.drawable.search_icon),
                        contentDescription = "search icon",
                        modifier = Modifier.size(31.dp)
                    )
                },

                label = {
                    Text(
                        text = "What would u like to order?",
                        color = icons_Text.copy(alpha = 0.6f),
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 15.sp
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        //foodList carousel
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = text_Field.copy(alpha = 0.6f))
                .padding(8.dp)
        ) {
            HorizontalPager(
                state = pagerState3,
                pageSpacing = (-270).dp
            ) { page ->
                FoodItemCategoryLayout(list = foodType[page])
            }
        }
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Popular Foods",
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
        Spacer(modifier = Modifier.height(12.dp))
        //popular food 2x2 grid
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(foodList.size) { page ->
                    Food_RestaurantLayout(navController = navController, carousel = foodList[page])
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 66.dp)
        )
    }

}

@ExperimentalAnimationApi
@Composable
private fun BottomNavItem(
    modifier: Modifier = Modifier,
    screen: Screen,
    isSelected: Boolean,
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
    ) {
        val animatedElevation by animateDpAsState(targetValue = if (isSelected) 15.dp else 0.dp)
        val animatedAlpha by animateFloatAsState(targetValue = if (isSelected) 1f else .5f)
        val animatedHeight by animateFloatAsState(targetValue = if (isSelected) 52f else 42f)
        val animatedIconSize by animateDpAsState(
            targetValue = if (isSelected) 32.dp else 22.dp,
            animationSpec = spring(
                stiffness = Spring.StiffnessLow,
                dampingRatio = Spring.DampingRatioMediumBouncy
            ), label = "animations"
        )
        Row(
            modifier = Modifier
                .height(animatedHeight.dp)
                .shadow(
                    elevation = animatedElevation,
                    shape = CircleShape
                )
                .background(
                    color = peach_bg,
                    shape = CircleShape
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            FlipIcon(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .padding(horizontal = 10.dp)
                    .alpha(animatedAlpha)
                    .size(animatedIconSize),
                isActive = isSelected,
                activeIcon = screen.activeIcon,
                inactiveIcon = screen.inactiveIcon,
                contentDescription = screen.title
            )
        }
    }
}

@Composable
fun FlipIcon(
    modifier: Modifier = Modifier,
    isActive: Boolean,
    activeIcon: ImageVector,
    inactiveIcon: ImageVector,
    contentDescription: String,
) {
    val animationRotation by animateFloatAsState(
        targetValue = if (isActive) 180f else 0f,
        animationSpec = spring(
            stiffness = Spring.StiffnessLow,
            dampingRatio = Spring.DampingRatioMediumBouncy
        )
    )
    Box(
        modifier = modifier
            .graphicsLayer { rotationY = animationRotation },
        contentAlignment = Alignment.Center,
    ) {
        Icon(
            rememberVectorPainter(image = if (animationRotation > 90f) activeIcon else inactiveIcon),
            contentDescription = contentDescription,
            tint = icons_Text,
            modifier = Modifier.size(32.dp)
        )
    }
}

@Composable
fun Food_RestaurantLayout(
    navController: NavController,
    carousel: home_fooditem_restaurant
) {
    val interactionSource = remember { MutableInteractionSource() }

    Box {
        val painter = rememberImagePainter(
            data = carousel.image,
            builder = {
                CircularProgressIndicator()
            }
        )
        Image(
            painter = painter,
            contentDescription = null,
            modifier = Modifier
                .size(carousel.size)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop,
            alpha = 0.9f
        )
    }
    Column(
        modifier = Modifier
            .size(carousel.size)
            .background(
                color = Color(0xFFB68791).copy(alpha = 0.76f),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(9.dp)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                navController.navigate(Screens.RestaurantScreen.route)
            },
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Icon(
                imageVector = if (carousel.isLiked.value) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                contentDescription = "favorites",
                tint = icons_Text,
                modifier = Modifier
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        carousel.isLiked.value = !carousel.isLiked.value
                    }
                    .size(28.dp)
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = carousel.name,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 24.sp,
                    color = Color.White,
                    modifier = Modifier.weight(6f)
                )
                if (carousel.isRestaurant) {
                    Icon(
                        painter = painterResource(id = R.drawable.sendpics),
                        contentDescription = "send",
                        tint = icons_Text,
                        modifier = Modifier
                            .size(25.dp)
                            .weight(1.5f)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = if (carousel.stars > 5) "5.0" else "${carousel.stars}.0",
                        fontSize = 10.sp,
                        modifier = Modifier.padding(end = 1.dp),
                        color = Color.White
                    )
                    StarRating(stars = carousel.stars)
                    Text(
                        text = "(${carousel.reviewNumber})",
                        fontSize = 10.sp,
                        color = Color.White
                    )
                }
                if (!carousel.isRestaurant) {
                    Text(
                        text = "${carousel.price}/-",
                        fontSize = 16.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}


@Composable
fun StarRating(
    stars: Int = 0
) {
    val newstars = if (stars > 5) 5 else stars
    Row {
        for (i in 1..newstars) {
            Image(
                painter = painterResource(id = R.drawable.baseline_star_24),
                contentDescription = "filled",
                modifier = Modifier.size(12.dp)
            )
        }
        for (i in newstars + 1..5) {
            Image(
                painter = painterResource(id = R.drawable.baseline_star_outline_24),
                contentDescription = "outlined",
                modifier = Modifier.size(12.dp)
            )
        }
    }
}

@Composable
fun FoodItemCategoryLayout(
    list: home_foodtype
) {
    Box {
        Box(
            modifier = Modifier
                .size(75.dp)
                .clip(RoundedCornerShape(4.dp))
                .border(
                    width = 2.dp,
                    color = icons_Text,
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(bottom = 4.dp),
            contentAlignment = Alignment.Center
        ) {
            val painter = rememberImagePainter(
                data = list.image,
                builder = { }
            )

            Icon(
                painter = painter,
                contentDescription = null,
                tint = icons_Text,
                modifier = Modifier.size(40.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Box(
            modifier = Modifier
                .size(75.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                text = list.food,
                color = icons_Text,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}
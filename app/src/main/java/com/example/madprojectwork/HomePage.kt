package com.example.madprojectwork

import androidx.compose.animation.core.animateFloatAsState
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
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.madprojectwork.dataclasses.Screen
import com.example.madprojectwork.dataclasses.home_fooditem_restaurant
import com.example.madprojectwork.dataclasses.home_foodtype
import com.example.madprojectwork.ui.theme.icons_Text
import com.example.madprojectwork.ui.theme.peach_bg
import com.example.madprojectwork.ui.theme.text_Field

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    var searchValue by remember {
        mutableStateOf("")
    }
    val foodList = listOf(
        home_fooditem_restaurant(
            name = "Burger",
            price = 100,
            stars = 3,
            reviewNumber = 100,
            isRestaurant = false,
            size = 190.dp,
            image = R.drawable.borgir
        ),
        home_fooditem_restaurant(
            name = "Pizza",
            price = 100,
            stars = 4,
            reviewNumber = 100,
            isRestaurant = false,
            size = 190.dp,
            image = R.drawable.pizzaaa
        ),
        home_fooditem_restaurant(
            name = "Sushi",
            price = 100,
            stars = 4,
            reviewNumber = 100,
            isRestaurant = false,
            size = 190.dp,
            image = R.drawable.sushi3
        ),
        home_fooditem_restaurant(
            name = "Biryani",
            price = 100,
            stars = 5,
            reviewNumber = 100,
            isRestaurant = false,
            size = 190.dp,
            image = R.drawable.biryani
        ),
        home_fooditem_restaurant(
            name = "Kebabs",
            price = 100,
            stars = 5,
            reviewNumber = 100,
            isRestaurant = false,
            size = 190.dp,
            image = R.drawable.kebabs3
        ),
        home_fooditem_restaurant(
            name = "Ice Cream",
            price = 100,
            stars = 5,
            reviewNumber = 100,
            isRestaurant = false,
            size = 190.dp,
            image = R.drawable.icecream2
        ),
    )


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
                contentDescription = "cart"
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
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            verticalItemSpacing = 8.dp,
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            content = {
                items(foodList.size) { page ->
                    Food_RestaurantLayout(navController = navController, carousel = foodList[page])
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp, bottom = 62.dp)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom
    ) {
        BottomNavNoAnimation(
            screens = listOf(
                Screen.Favorites,
                Screen.Home,
                Screen.Profile
            )
        )
    }
}

@Composable
fun BottomNavNoAnimation(
    screens: List<Screen>
) {
    var selectedScreen by remember { mutableStateOf(0) }
    Box(
        Modifier
            .shadow(5.dp)
            .background(color = icons_Text)
            .height(60.dp)
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            for (screen in screens) {
                val isSelected = screen == screens[selectedScreen]
                val animatedWeight by animateFloatAsState(targetValue = if (isSelected) 1.5f else 1f,
                    label = "bottom nav bar animation"
                )
                Box(
                    modifier = Modifier.weight(animatedWeight),
                    contentAlignment = Alignment.Center,
                ) {
                    val interactionSource = remember { MutableInteractionSource() }
                    BottomNavItem(
                        modifier = Modifier.clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) {
                            selectedScreen = screens.indexOf(screen)
                        },
                        screen = screen,
                        isSelected = isSelected
                    )
                }
            }
        }
    }
}

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
        Row(
            modifier = Modifier
                .height(40.dp)
                .shadow(
                    elevation = if (isSelected) 15.dp else 0.dp,
                    shape = RoundedCornerShape(20.dp)
                )
                .background(
                    color = peach_bg,
                    shape = RoundedCornerShape(20.dp)
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Icon(
                rememberVectorPainter(
                    image = if (isSelected) screen.activeIcon else screen.inactiveIcon
                ),
                contentDescription = screen.title,
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .fillMaxHeight()
                    .padding(start = 6.dp, end = 6.dp,)
                    .alpha(if (isSelected) 1f else .5f)
                    .size(if (isSelected) 32.dp else 28.dp),
            )

            if (isSelected) {
                Text(
                    text = screen.title,
                    modifier = Modifier.padding(start = 8.dp, end = 10.dp),
                    maxLines = 1,
                )
            }
        }
    }
}

@Composable
fun Food_RestaurantLayout(
    navController: NavController,
    carousel: home_fooditem_restaurant
) {
    var isLiked by remember {
        mutableStateOf(false)
    }
    val interactionSource = remember { MutableInteractionSource() }

    Box {
        Image(
            painter = painterResource(carousel.image),
            contentDescription = null,
            modifier = Modifier
                .size(carousel.size)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop,
            alpha = 0.9f
        )
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
                    imageVector = if (isLiked) Icons.Default.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = "favorites",
                    tint = icons_Text,
                    modifier = Modifier
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null
                        ) { isLiked = !isLiked }
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
    Box{
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
            Icon(
                painter = painterResource(id = list.image),
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
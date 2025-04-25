package com.example.dashboardui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.dashboardui.ui.theme.DashBoardUiTheme
import com.example.dashboardui.ui.theme.MyGrey
import com.example.dashboardui.ui.theme.MyRed

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DashBoardUiTheme {
                Dashboard()
            }
        }
    }
}

@Composable
fun Dashboard() {
    Column(
        Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .background(color = MyGrey),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout {
            val (redBorder) = createRefs()
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .constrainAs(redBorder) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(color = MyRed))
            Row(
                modifier = Modifier
                    .padding(top = 10.dp, start = 10.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .height(60.dp)
                        .padding(start = 8.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        "Foods",
                        color = Color.White,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
                Image(
                    painterResource(R.drawable.photo),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .clickable {}
                )
            }
        }
        var searchText by rememberSaveable { mutableStateOf(" ") }
        TextField(
            value = searchText, onValueChange = { searchText = it },
            label = { Text("Search Restaurants...") },
            trailingIcon = {
                Icon(
                    Icons.Rounded.Search, contentDescription = null,
                    tint = Color.Red
                )
            },
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                focusedPlaceholderColor = Color.White,
                unfocusedPlaceholderColor = Color.White,
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(70.dp)
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(3.dp, shape = RoundedCornerShape(50.dp))
                .background(Color.White, CircleShape)
        )
        ConstraintLayout(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp, end = 24.dp, start = 24.dp)
                .shadow(5.dp, shape = RoundedCornerShape(25.dp))
                .height(150.dp)
                .background(color = MyRed)
        ) {
            val (bannerImage, flatText, freeText, couponText) = createRefs()
            Image(
                painterResource(id = R.drawable.bannerimg),
                contentDescription = null,
                modifier = Modifier
                    .constrainAs(bannerImage) {
                        top.linkTo(parent.top)
                        end.linkTo(parent.end)
                        bottom.linkTo(parent.bottom)
                    }
            )
            Text(
                "FLAT 50% OFF",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .padding(top = 32.dp)
                    .constrainAs(flatText) {
                        top.linkTo(parent.top)
                        end.linkTo(bannerImage.start)
                        start.linkTo(parent.start)
                    }
            )
            Text(
                "Free Delivery + 10% Cashback",
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .constrainAs(freeText) {
                        top.linkTo(flatText.bottom)
                        end.linkTo(flatText.end)
                        start.linkTo(flatText.start)
                    }
            )
        }
        Text(
            "CATEGORIES",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier
                .padding(top = 16.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.cake),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                    )
            }

            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.icecream),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.burger),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.dalrice),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.biryani),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.burger),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, start = 16.dp, end = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.cake),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.icecream),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }

            Column(
                modifier = Modifier
                    .weight(0.25f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(R.drawable.burger),
                    contentDescription = null,
                    modifier = Modifier
                        .height(100.dp)
                        .shadow(
                            3.dp, shape = RoundedCornerShape(10.dp)
                        )
                        .padding(top = 8.dp, bottom = 4.dp)
                        .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                        .padding(16.dp)
                )
                Text("Cake",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                        .padding(top = 8.dp),
                    color = Color.Black
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Dashboard()
}
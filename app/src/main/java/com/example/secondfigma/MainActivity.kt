package com.example.secondfigma

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.FontResourcesParserCompat
import com.example.secondfigma.ui.theme.DarkGrey
import com.example.secondfigma.ui.theme.SecondFigmaTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CompositionLocalProvider(
                LocalLayoutDirection provides LayoutDirection.Rtl
            ) {
                SecondFigmaTheme {
                    Scaffold(
                        modifier = Modifier.fillMaxSize(),
                        topBar = {
                            CenterAlignedTopAppBar(
                                title = {
                                    Row(
                                        horizontalArrangement = Arrangement.SpaceBetween,
                                        verticalAlignment = Alignment.CenterVertically,
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(color = Color.White)
                                    ) {
                                        Text(
                                            text = "أذكار الصباح",
                                            fontSize = 14.sp, modifier = Modifier.weight(1f),
                                            fontWeight = FontWeight.Bold,
                                            fontFamily = FontFamily(Font(R.font.cairobold)),
                                            color = DarkGrey
                                        )

                                        IconButton(
                                            onClick = { /*TODO*/ },
                                            modifier = Modifier,
                                        ) {
                                            Image(
                                                painter = painterResource(R.drawable.arrow___left),
                                                contentDescription = null,
                                                contentScale = ContentScale.Fit,
                                            )
                                        }
                                    }
                                },

                                )
                        },
                    ) { innerPadding ->

                        AllViews(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CompositionLocalProvider(
        LocalLayoutDirection provides LayoutDirection.Rtl
    ) {
        SecondFigmaTheme {
            AllViews()
        }
    }
}

@Composable
fun UpView(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Text(
            text = "أذكار الصباح",
            fontSize = 14.sp, modifier = Modifier.weight(1f),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.cairobold)),
            color = DarkGrey
        )

        IconButton(
            onClick = { /*TODO*/ },
            modifier = Modifier,
        ) {
            Image(
                painter = painterResource(R.drawable.arrow___left),
                contentDescription = null,
                contentScale = ContentScale.Fit,
            )
        }
    }


}

@SuppressLint("ResourceAsColor")
@Composable
fun DownView(modifier: Modifier = Modifier) {
    var pageNumber by remember { mutableStateOf(0) }
    Row(
        modifier = modifier
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround
    ) {
            Button(
                onClick = {
                    if (pageNumber in (1..7)) {
                        pageNumber--
                    }
                }, colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.White,
                    disabledContentColor = Color.Yellow,
                    disabledContainerColor = Color.Red
                ), modifier = Modifier.padding(7.dp),
                border = BorderStroke(1.dp, Color.Black),
                shape = RoundedCornerShape(25f)
            ) {
                Image(
                    painter = painterResource(R.drawable.arrow___right),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                )
            }
        Box() {
            Card(
                modifier = Modifier.padding(5.dp)
                    .width(60.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(1.dp, color = colorResource(R.color.Asfar)),
                colors = CardColors(
                    containerColor = Color.Black,
                    contentColor = colorResource(R.color.black),
                    disabledContainerColor = Color.Red,
                    disabledContentColor = Color.Red
                )
            ) {

            }


            Card(
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp),
                shape = RoundedCornerShape(25.dp),
                border = BorderStroke(1.dp, color = colorResource(R.color.Asfar)),
                colors = CardColors(
                    containerColor = colorResource(R.color.Asfar),
                    contentColor = colorResource(R.color.black),
                    disabledContainerColor = Color.Red,
                    disabledContentColor = Color.Red
                )


            )

            {
                Text(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 15.dp),
                    text = "$pageNumber/7",
                    fontFamily = FontFamily(Font(R.font.cairobold)),
                    textAlign = TextAlign.Center,
                    fontSize = 16.sp,
                    lineHeight = 29.98.sp,
                    color = colorResource(R.color.assouad1)
                )


            }
        }


        Button(
            onClick = {
                if (pageNumber in (0 until 7)) {
                    pageNumber++
                }
            }, colors = ButtonColors(
                contentColor = Color.White,
                containerColor = Color.White,
                disabledContentColor = Color.Yellow,
                disabledContainerColor = Color.Red
            ), modifier = Modifier.padding(top = 5.dp),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(25f)
        ) {
            Image(
                painter = painterResource(R.drawable.arrow___left),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
            )
        }

    }


}

@Composable
fun AllViews(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.group_580),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceAround) {
            Text(
                text = stringResource(R.string.main_text),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(266.dp)
                    .padding(horizontal = 25.dp)
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                    .padding(horizontal = 25.dp)
                    .padding(top = 45.dp),
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                lineHeight = 26.24.sp,
                fontFamily = FontFamily(Font(R.font.cairomedium)),
                color = colorResource(R.color.assouad1)
            )
            DownView()
        }
    }
}
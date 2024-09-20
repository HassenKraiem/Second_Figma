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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.res.FontResourcesParserCompat
import com.example.secondfigma.ui.theme.SecondFigmaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SecondFigmaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AllViews(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SecondFigmaTheme {
        AllViews()
    }
}

@Composable
fun UpView(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .background(color = Color.White)
    ) {
        Box {
            Button(
                onClick = { /*TODO*/ }, colors = ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.White,
                    disabledContentColor = Color.Yellow,
                    disabledContainerColor = Color.Red
                ), modifier = Modifier.fillMaxWidth(0.25f),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Image(
                    painter = painterResource(R.drawable.arrow___left),
                    contentDescription = null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier.fillMaxWidth(0.5f)
                )
            }
        }
        Text(
            text = "أذكار الصباح",
            fontSize = 25.sp, modifier = Modifier.fillMaxWidth(0.5f),
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily(Font(R.font.cairobold))
        )
    }


}

@SuppressLint("ResourceAsColor")
@Composable
fun DownView(modifier: Modifier = Modifier) {
    var pageNumber by remember { mutableStateOf(0) }
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 50.dp), horizontalArrangement = Arrangement.SpaceAround
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
            ), modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            border = BorderStroke(2.dp, Color.Black),
            shape = RoundedCornerShape(25f)
        ) {
            Image(
                painter = painterResource(R.drawable.arrow___left),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Button(
            onClick = {},
            colors = ButtonColors(
                containerColor = colorResource(R.color.Asfar),
                contentColor = Color.Black,
                disabledContainerColor = Color.Black,
                disabledContentColor = Color.Black
            ),
            border = BorderStroke(2.dp, Color.Black),
            shape = RoundedCornerShape(25f),
            modifier = Modifier.padding(horizontal = 55.dp)
        )

        {
            Text(
                text = "$pageNumber/7",
                fontFamily = FontFamily(Font(R.font.cairobold))
            )

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
            ), modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            border = BorderStroke(2.dp, Color.Black),
            shape = RoundedCornerShape(25f)
        ) {
            Image(
                painter = painterResource(R.drawable.arrow___right),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }

    }


}

@Composable
fun AllViews(modifier: Modifier = Modifier) {
    Box(modifier = modifier
        .fillMaxSize()
        .padding(20.dp)) {
        Image(
            painter = painterResource(R.drawable.group_580),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.fillMaxSize()
        )
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            UpView()
            Text(
                text = stringResource(R.string.main_text),
                modifier = Modifier
                    .fillMaxHeight(0.50f)
                    .fillMaxWidth()
                    .border(2.dp, Color.Black, shape = RoundedCornerShape(15.dp))
                    .safeContentPadding(),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontFamily = FontFamily(Font(R.font.cairomedium))
            )
            DownView()
        }
    }
}
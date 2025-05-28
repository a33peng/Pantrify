package com.example.pantrify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.pantrify.ui.theme.PantrifyTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.withStyle
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.draw.scale

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantrifyTheme {
                MainContent2()
            }
        }
    }
}

@Composable
fun MainContent2() {
    // vertical layout of mobile app
    Column (
        modifier = Modifier
            .fillMaxSize()  // fill up whole screen
            //.background(color = Color(0xFF75BDBC)) // set background colour
            .padding(16.dp)
    ){
        // display annotated text style
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF0B0C0D), fontSize = 30.sp)) { append("Hi") } // dark colour text
                append(" ")
                withStyle(style = SpanStyle(color = Color(0XFF75BDBC), fontSize = 30.sp)) { append("Foodie! \n") } // light teal text
                withStyle(style = SpanStyle(color = Color(0xFF0B0C0D))) { append("What are you craving today?")}
                },
            fontSize = 20.sp
        )

    }
}


// display preview in IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MainContent2()
}

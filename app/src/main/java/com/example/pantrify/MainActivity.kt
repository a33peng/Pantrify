package com.example.pantrify

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantrify.ui.theme.PantrifyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            PantrifyTheme {
                WelcomeScreen( // passing in a lambda, anonymous function as parameter
                    onStartClicked = {
                        // launches second activity page
                        startActivity(Intent(this, SecondActivity::class.java))
                    }
                )
            }
        }
    }
}

@Composable
fun WelcomeScreen(onStartClicked: () -> Unit) {
    // background box size + background colour
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF75BDBC))
    ) {
        Image(
            painter = painterResource(id = R.drawable.pattern),
            contentDescription = stringResource(R.string.pattern),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // vertically arrange UI components
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(300.dp))

            Image(
                painter = painterResource(id = R.drawable.cookingpot),
                contentDescription = stringResource(R.string.cookingpot),
                modifier = Modifier
                    .width(280.dp)
                    .height(260.dp)
            )
            // add vertical spacing at the top of the screen
            Spacer(modifier = Modifier.height(15.dp))

            // Welcome text - Let's start cooking
            Text(
                text = stringResource(R.string.welcome_title),
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF333333)
            )
            // insert space between pot image and text
            Spacer(modifier = Modifier.height(16.dp))

            // Start button
            Button(
                // when button is clicked, onStartClicked is trigger, implements an Intent to go to SecondActivity
                onClick = onStartClicked,
                modifier = Modifier.width(200.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF018786))
            ) {
                Text(
                    text = stringResource(R.string.start_button),
                    color = Color.Red
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun WelcomeScreenPreview() {
    PantrifyTheme {
        // pass in a null lambda, anonymous body
        WelcomeScreen(onStartClicked = {})
    }
}


//// keep track if start button is clicked or not
//// var isStart by remember { mutableStateOf(false) }

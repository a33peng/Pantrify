package com.example.pantrify

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.pantrify.ui.theme.PantrifyTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.compose.ui.unit.sp
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pantrify.ui.theme.PantrifyTheme


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
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFF75BDBC))
    ){

        //        Spacer(modifier = Modifier.height(50.dp))

        Text("Search Page",
            fontSize = 30.sp,
            )
    }
}

// display preview in IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MainContent2()
}


//class SecondActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            PantrifyTheme {
//                // call composable function to display elements and its contents
//                MainContent2()
//            }
//        }
//    }
//}

package com.example.pantrify


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pantrify.ui.theme.PantrifyTheme


class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantrifyTheme {
                MainContent2()

                //setContentView(R.layout.activity_home)
                //val btnFridge = findViewById<ImageView>(R.id.fridgeButton)
                // render new activity page if exit button is clicked
//                btnFridge.setOnClickListener {
//                    startActivity(Intent(this, InventoryActivity::class.java))
//                }
            }
        }
    }
}

@Composable
fun SearchBar() {
    val allRecipes = listOf("Spaghetti Carbonara", "Spaghetti Bolognese", "Curry", "Fried Rice", "Potato Salad")
    var query by remember { mutableStateOf("") }

    val filteredRecipes by remember(query) {
        mutableStateOf(
            if (query.isEmpty()) allRecipes
            else allRecipes.filter { it.contains(query, ignoreCase = true) }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        TextField(
            value = query,
            onValueChange = { query = it },
            placeholder = { Text("Search recipes...") },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        if (filteredRecipes.isEmpty()) {
            Text("No recipes found.")
        } else {
            filteredRecipes.forEach { recipe ->
                Row{    // shift drop down recipes to the right
                    Spacer(modifier = Modifier.width(25.dp))
                    Text(
                        text = recipe,
                        fontSize = 18.sp,
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .clickable {
                                // Handle recipe click, if needed
                                // onResultClick(resultText)
                                // expanded = false
                            }
                            .fillMaxSize()
                            .padding(horizontal = 16.dp, vertical = 4.dp)
                    )
                }
            }
        }
    }
}

// Header above searchbar
@Composable
fun Greeting(){
    Row{   // adjust horizontal spacing
        Spacer(modifier = Modifier.width(20.dp)) // push text to right
        Text(
            buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF0B0C0D), fontSize = 30.sp)) { append("Hi") } // dark colour text
                append(" ")
                withStyle(style = SpanStyle(color = Color(0XFF75BDBC), fontSize = 30.sp)) { append("Foodie! \n") } // light teal text
                withStyle(style = SpanStyle(color = Color(0xFF0B0C0D))) { append("What are you craving today?")}
            },
            fontSize = 20.sp,
            lineHeight = 25.sp, // line height separating Header and sub text
            modifier = Modifier.padding(top = 30.dp)
        )
    }
}

// display fridge
@Composable
fun FridgeImage() {
    Image(
        painter = painterResource(id = R.drawable.fridge),
        contentDescription = "Fridge",
        modifier = Modifier
            .size(160.dp)
            .padding(16.dp)
            .offset(x = 10.dp, y = 180.dp) // adjust position, larger value is down
    )
    Row{
        Spacer(modifier = Modifier.width(20.dp))
        Text("Fridge",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset( x = 10.dp, y = 5.dp)
        )
    }
}

// display fridge
@Composable
fun MapImage() {
    Image(
        painter = painterResource(id = R.drawable.map),
        contentDescription = "Map",
        modifier = Modifier
            .size(160.dp)
            .padding(16.dp)
            .offset(x = 180.dp, y = -5.dp)
    )
    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            "Map",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = 200.dp, y = -170.dp)
        )
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

        Greeting()
        Spacer(modifier = Modifier.height(25.dp))
        SearchBar()
        FridgeImage()
        MapImage()
    }
}

// display preview in IDE emulator
@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    MainContent2()
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    PantrifyTheme {
        SearchBar()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PantrifyTheme {
        Greeting()
    }
}

@Preview(showBackground = true)
@Composable
fun FridgePreview() {
    FridgeImage()
}

@Preview(showBackground = true)
@Composable
fun MapPreview() {
    MapImage()
}

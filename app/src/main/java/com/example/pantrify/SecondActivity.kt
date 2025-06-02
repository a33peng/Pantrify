package com.example.pantrify

import android.content.Intent
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// import com.android.volley.toolbox.ImageLoader
import com.example.pantrify.ui.theme.PantrifyTheme
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import androidx.compose.runtime.Composable
import coil.ImageLoader

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
fun CatGif(){
    val context = LocalContext.current
    // enabled gif to load image
    val gifEnabledLoader = ImageLoader.Builder(context)
        .components {
            if ( SDK_INT >= 28 ) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }.build()
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(R.drawable.clearcatdriving)    // load cat driving gif
            .build(),
        imageLoader = gifEnabledLoader,
        contentDescription = "pusheen driving a car",
        modifier = Modifier
            .offset(x = 220.dp, y = 650.dp)
            .size(150.dp)
    )
    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            "Map",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = 235.dp, y = 625.dp)
        )
    }
}


@Composable
fun SearchBar() {
    val allRecipes = listOf("Spaghetti Carbonara", "Spaghetti Bolognese", "Curry", "Fried Rice", "Potato Salad")
    var query by remember { mutableStateOf("") }
    val filteredRecipes by remember(query) {
        // display matching recipes in search drop down based on input
        mutableStateOf(
            if (query.isEmpty()){
                allRecipes
            } else {
                allRecipes.filter { it.contains(query, ignoreCase = true) }
            }
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
    val context = LocalContext.current // define context for starting activity
    Image(
        painter = painterResource(id = R.drawable.fridge),
        contentDescription = "Fridge",
        modifier = Modifier
            .size(180.dp)
            .padding(16.dp)
            .offset(x = 20.dp, y = 630.dp)
            .clickable { // render inventory page if fridge image is clicked
                val intent = Intent(context, InventoryActivity::class.java)
                context.startActivity(intent)
            }
    )
    Row{
        Spacer(modifier = Modifier.width(20.dp))
        Text("Fridge",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset( x = 40.dp, y = 620.dp)
        )
    }
}

// old version
@Composable
fun MapImage() {
    Image(
        painter = painterResource(id = R.drawable.map),
        contentDescription = "Map",
        modifier = Modifier
            .size(160.dp)
            .padding(16.dp)
            .offset(x = 180.dp, y = 625.dp) // larger dp, lower the img
    )
    Row {
        Spacer(modifier = Modifier.width(20.dp))
        Text(
            "Map",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.offset(x = 200.dp, y = 620.dp)
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
        Spacer(modifier = Modifier.height(25.dp))
    }
    FridgeImage()
    //MapImage()
    CatGif()
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

@Preview(showBackground = true)
@Composable
fun PreviewCatGif(){
    CatGif()
}

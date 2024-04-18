package com.example.ktt

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktt.ui.theme.KTTTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KTTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Task()
                }
            }
        }
    }
}

@Composable
fun Task() {
    val rainbowColors = listOf("Red", "Orange", "Yellow", "Green", "Blue", "Dark Blue", "Violet")

    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Select your favorite color!",
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )

        LazyColumn (
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ){
            items(rainbowColors){colors ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color(0xFFfff4fc)) //0xFFfff4fc
                        .border(BorderStroke(1.dp, Color.Gray))
                        .clip(shape = RoundedCornerShape(12.dp))
                        .clickable {
                            Toast.makeText(context, colors, Toast.LENGTH_SHORT).show()
                        },
                    contentAlignment = Alignment.Center
                ){
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        val colorPics = when (colors) {
                            "Red" -> R.drawable.red
                            "Orange" -> R.drawable.orange
                            "Yellow" -> R.drawable.yellow
                            "Green" -> R.drawable.green
                            "Blue" -> R.drawable.blue
                            "Dark Blue" -> R.drawable.darkblue
                            "Violet" -> R.drawable.violet
                            else -> null
                        }

                        colorPics?.let { painterResource(id = it) }?.let {
                            Image(
                                painter = it,
                                contentDescription = null,
                                modifier = Modifier.size(40.dp)

                            )
                        }

                        Spacer(modifier = Modifier.width(16.dp))

                        Text(
                            text = colors,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                    Spacer(modifier = Modifier.height(80.dp))
                }
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KTTTheme {
        Task()
    }
}
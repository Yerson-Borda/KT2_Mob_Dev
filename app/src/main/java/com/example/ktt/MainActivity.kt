package com.example.ktt

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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

data class ColorInfo(
    val name: String,
    val color: Color,
    val initial: String
)

@Composable
fun Task() {
    val rainbowColors = listOf(
        ColorInfo("Red", Color.Red, "R"),
        ColorInfo("Orange", Color(0xFFff8c04), "O"),
        ColorInfo("Yellow", Color.Yellow, "Y"),
        ColorInfo("Green", Color.Green, "G"),
        ColorInfo("Blue", Color.Blue, "B"),
        ColorInfo("Dark Blue", Color(0xFF00008B), "D"),
        ColorInfo("Violet", Color(0xFFa004fc), "V")
    )

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Select your favorite color!",
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp
        )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 20.dp)
        ) {
            items(rainbowColors) { colorInfo ->
                ColorBox(
                    colorInfo = colorInfo,
                    onClick = {
                        Toast.makeText(context, colorInfo.name, Toast.LENGTH_SHORT).show()
                    },
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun ColorBox(colorInfo: ColorInfo, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(Color(0xFFfff4fc), shape = RoundedCornerShape(15.dp))
            .clickable(onClick = onClick)
            .padding(start = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(colorInfo.color, shape = RoundedCornerShape(32.dp)),
            contentAlignment = Alignment.Center,
        ) {
            Text(
                text = colorInfo.initial,
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = colorInfo.name,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KTTTheme {
        Task()
    }
}
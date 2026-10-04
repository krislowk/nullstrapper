package com.nullstrapper.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val BgBlack      = Color(0xFF0A0A0A)
private val SurfaceDark  = Color(0xFF141414)
private val BorderGray   = Color(0xFF2A2A2A)
private val TextPrimary  = Color(0xFFFFFFFF)
private val TextSecondary = Color(0xFF888888)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme(
                colorScheme = darkColorScheme(
                    background = BgBlack,
                    surface = SurfaceDark
                )
            ) {
                Surface(modifier = Modifier.fillMaxSize(), color = BgBlack) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "NULLSTRAPPER",
            color = TextPrimary,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Monospace,
            letterSpacing = 3.sp
        )

        Spacer(Modifier.height(56.dp))

        MenuButton(label = "Launch Roblox") { /* Phase 9 */ }
        Spacer(Modifier.height(12.dp))
        MenuButton(label = "FFlags") { /* Phase 4 */ }
        Spacer(Modifier.height(12.dp))
        MenuButton(label = "Settings") { /* Phase 3 */ }

        Spacer(Modifier.weight(1f))

        Text(
            text = "Version: ${BuildConfig.VERSION_NAME}",
            color = TextSecondary,
            fontSize = 12.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}

@Composable
fun MenuButton(label: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(SurfaceDark, RoundedCornerShape(4.dp))
            .border(1.dp, BorderGray, RoundedCornerShape(4.dp))
            .clickable { onClick() }
            .padding(horizontal = 20.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = label,
            color = TextPrimary,
            fontSize = 16.sp,
            fontFamily = FontFamily.Monospace
        )
    }
}

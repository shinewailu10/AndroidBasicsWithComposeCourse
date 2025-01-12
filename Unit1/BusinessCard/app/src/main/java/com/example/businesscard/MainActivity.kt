package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface (
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    val color = colorResource(R.color.light_green)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = null,
            modifier = Modifier
                .background(colorResource(R.color.dark_green))
                .size(100.dp)
        )
        Text(
            text = stringResource(R.string.Name),
            fontSize = 36.sp,
            modifier = Modifier
                .padding(top = 15.dp)


        )
        Text(
            text = stringResource(R.string.career_title),
            color = Color(0xFF009900),
            modifier = Modifier
                .padding(top = 10.dp)

        )
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.Start,
            ) {
            Row(
                modifier = Modifier
                    .padding(10.dp),
            ) {
                Icon(
                    imageVector = Icons.Default.Call,
                    tint = Color(0xFF009900),
                    contentDescription = null

                )
                Text(
                    text = stringResource(R.string.ph_num),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row(
                modifier = Modifier.padding(10.dp),
                horizontalArrangement = Arrangement.Start,

                ) {
                Icon(
                    imageVector = Icons.Default.Share,
                    tint = Color(0xFF009900),
                    contentDescription = null

                )
                Text(
                    text = stringResource(R.string.link),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    tint = Color(0xFF009900),
                    contentDescription = null

                )
                Text(
                    text = stringResource(R.string.mail),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}
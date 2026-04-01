package com.example.anime_list.ui.auth

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anime_list.ui.shared.DefaultInput

@Composable
fun SignupScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)
    ){
        Card(
            modifier = Modifier.fillMaxWidth().height(700.dp).align(Alignment.BottomCenter),
            shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)
        ) {

            SignupForm()
        }
    }

}

@Composable
fun SignupForm() {
    Column(
        modifier = Modifier.padding(32.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = {}, colors = IconButtonDefaults.iconButtonColors(
                contentColor = MaterialTheme.colorScheme.primary
            )) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,      // No drawable!
                    contentDescription = "Google Sign In",
                    modifier = Modifier.size(24.dp),
                    tint = MaterialTheme.colorScheme.primary,
                )
            }
            Text("back to login", color = MaterialTheme.colorScheme.primary)
        }

        Column(modifier = Modifier.padding(vertical = 24.dp)) {

            Row() {
                Text(
                    modifier = Modifier.padding(top = 24.dp),
                    text = "SignUp",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.primary
                )

            }
            Column(modifier = Modifier.padding(vertical = 32.dp)) {
                DefaultInput(value = "", label = "Email", onChange = {})
                DefaultInput(value = "", label = "PhoneNumber", onChange = {})
                DefaultInput(value = "", label = "Password", onChange = {})
                DefaultInput(value = "", label = "Confirm Password", onChange = {})
            }
            Button(onClick = {},modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
                Text("Signup")
            }

        }


    }
}
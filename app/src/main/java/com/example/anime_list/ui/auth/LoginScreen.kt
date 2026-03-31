package com.example.anime_list.ui.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.R
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.anime_list.ui.shared.DefaultInput


@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary)
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().height(600.dp).align(Alignment.BottomCenter),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp)

        ) {
            LoginForm()
        }

    }

}


@Composable
fun LoginForm(modifier: Modifier = Modifier) {

    Column(modifier = Modifier.padding(24.dp)) {

        Text(
            modifier = Modifier.padding(top = 24.dp),
            text = "Login",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colorScheme.primary
        )

        Column(modifier = Modifier.padding(top = 32.dp)) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                DefaultInput(value = "", onChange = {}, label = "Username")
                DefaultInput(value = "", onChange = {}, label = "Email")
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "forgot your password?",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                Button(onClick = {},modifier = Modifier.padding(vertical = 12.dp).fillMaxWidth(), shape = RoundedCornerShape(8.dp)) {
                    Text("Login")
                }
            }
            Column(
                modifier = Modifier.padding(top = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ){
                    Text(
                        text = "OR LOGIN WITH",
                        color = Color.Gray
                    )
                }

                Row(
                    modifier = Modifier.width(200.dp).padding(top = 24.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    IconButton(
                        onClick = { /* Google login */ },
                        modifier = Modifier
                            .size(48.dp).background(color = Color.LightGray),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,      // No drawable!
                            contentDescription = "Google Sign In",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified  // Keeps multi-colo
                        )
                    }
                    IconButton(
                        onClick = { /* Google login */ },
                        modifier = Modifier
                            .size(48.dp).background(color = Color.LightGray),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,      // No drawable!
                            contentDescription = "Google Sign In",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified  // Keeps multi-colo
                        )
                    }
                    IconButton(
                        onClick = { /* Google login */ },
                        modifier = Modifier
                            .size(48.dp).background(color = Color.LightGray),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,      // No drawable!
                            contentDescription = "Google Sign In",
                            modifier = Modifier.size(24.dp),
                            tint = Color.Unspecified  // Keeps multi-colo
                        )
                    }
                }

                Row(
                    modifier = Modifier.padding(top = 24.dp)
                ){
                    Text("Sie Haben Keine Accounten? OH MEIN GOTT!", color = MaterialTheme.colorScheme.primary)
                }
            }

        }

    }


}

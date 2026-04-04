package com.example.anime_list

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.anime_list.ui.auth.AuthScreen
import com.example.anime_list.ui.auth.AuthViewModel
import com.example.anime_list.ui.auth.LoginScreen
import com.example.anime_list.ui.auth.SignupScreen
//import com.example.anime_list.ui.theme.Apptheme
import com.example.compose.AppTheme
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlinx.serialization.Serializable

val supabase = createSupabaseClient(
    supabaseUrl = "https://ubphatjhpduhuczgvbet.supabase.co",
    supabaseKey = "sb_publishable_m_bkXhkzVEji_4UgHqg2lQ_S2W7By4e"
) {
    install(Auth)
    install(Postgrest)
    //install other modules
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        val authViewModel = AuthViewModel()
        setContent {
            AppTheme(dynamicColor = false) {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    AuthScreen(modifier = Modifier.fillMaxSize().padding(innerPadding))
                    Greeting("abc", viewModel=authViewModel)
                }
            }
        }
    }
}

@Serializable
data class Task(
    val id:Int,
    val title:String,
)

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier,viewModel: AuthViewModel) {
    val tasks = remember { mutableStateListOf<Task>() }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            val results = supabase.from(table = "tasks").select().decodeList<Task>()
            tasks.addAll(results)
        }
    }

    Column() {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button( onClick = {
                viewModel.Signup()
        }, colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        )) {
            Text("click me")
        }
        LazyColumn() {
            items(items=tasks){ item ->
                Text(text = item.title)
            }
        }
//        LoginScreen()
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme(dynamicColor = false) {
//        Greeting("Android")
    }
}
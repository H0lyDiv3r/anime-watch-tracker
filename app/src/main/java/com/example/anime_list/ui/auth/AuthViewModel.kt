package com.example.anime_list.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


//
//sealed class UiState<out T> {
//    object Loading : UiState<Nothing>()
//    data class Success<T>(val data: T) : UiState<T>()
//    data class Error(val message: String) : UiState<Nothing>()
//}
//
//// 2. ViewModel (copy-paste ready)
//class SignupViewModel : ViewModel() {
//    private val _uiState = MutableStateFlow<UiState<SignUpResult>>(UiState.Loading)
//    val uiState: StateFlow<UiState<SignUpResult>> = _uiState.asStateFlow()
//
//    fun signup(email: String, password: String) {
//        viewModelScope.launch {
//            _uiState.value = UiState.Loading
//            _uiState.value = try {
//                UiState.Success(supabase.auth.signUpWith(Email) { /* ... */ })
//            } catch (e: Exception) {
//                UiState.Error(e.message ?: "Failed")
//            }
//        }
//    }
//}

class AuthViewModel: ViewModel(){
    val supabase = createSupabaseClient(
        supabaseUrl = "https://ubphatjhpduhuczgvbet.supabase.co",
        supabaseKey = "sb_publishable_m_bkXhkzVEji_4UgHqg2lQ_S2W7By4e"
    ) {
        install(Auth)
        install(Postgrest)
        //install other modules
    }

    fun Signup() {
        val deferred = viewModelScope.async {  // ✅ async returns Deferred<Result>
            try {
                supabase.auth.signUpWith(Email) {
                    email = "example3@gmail.com"
                    password = "pass123"
                }
            } catch (e: Exception) {
                e
            }
        }

        viewModelScope.launch {
            val result = deferred.await()  // ✅ WAITS + GETS RESULT
            println("✅ Result: ${result}")
        }
    }

    

}
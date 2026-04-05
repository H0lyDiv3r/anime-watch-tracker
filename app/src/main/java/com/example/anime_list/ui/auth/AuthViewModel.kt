package com.example.anime_list.ui.auth

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.auth.auth
import io.github.jan.supabase.auth.exception.AuthRestException
import io.github.jan.supabase.auth.providers.builtin.Email
import io.github.jan.supabase.auth.status.SessionStatus
import io.github.jan.supabase.auth.user.UserInfo
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch



sealed class AuthUiState {
    object Idle : AuthUiState()
    object Loading : AuthUiState()
    data class Success(val user: UserInfo?) : AuthUiState()
    data class Error(val message: String) : AuthUiState()
}

class AuthViewModel: ViewModel(){
    private val _uiState = MutableStateFlow<AuthUiState>(AuthUiState.Idle)
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    val supabase = createSupabaseClient(
        supabaseUrl = "https://ubphatjhpduhuczgvbet.supabase.co",
        supabaseKey = "sb_publishable_m_bkXhkzVEji_4UgHqg2lQ_S2W7By4e"
    ) {
        install(Auth)
        install(Postgrest)
        //install other modules
    }



    private val authStateJob = viewModelScope.launch {
        supabase.auth.sessionStatus.collect { status ->
            when(status) {
                is SessionStatus.Authenticated -> {
                    _uiState.value= AuthUiState.Success(status.session.user)
                }
                is SessionStatus.NotAuthenticated -> {
                    _uiState.value = AuthUiState.Idle
                }
                else -> Unit
            }
        }
    }

    fun Signup(emailString:String,passwordString:String) {
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            try{
                val res = supabase.auth.signUpWith(Email){
                    email = emailString
                    password = passwordString
                }
//                _uiState.value = AuthUiState.Success(res)
            }catch (e: AuthRestException){

                when(e.statusCode){
                    400 -> _uiState.value = AuthUiState.Error("user already exists")
                    429 -> _uiState.value = AuthUiState.Error("Too many requests")
                    else -> _uiState.value = AuthUiState.Error("unknown error ${e.description}")
                }

            }catch (e: Exception){
                _uiState.value = AuthUiState.Error("there has been an exeption ${e.message}")
            }
        }
    }

    fun Signin(emailString: String, passwordString: String){
        viewModelScope.launch {
            _uiState.value = AuthUiState.Loading
            try {
                val res = supabase.auth.signInWith(Email){
                    email = emailString
                    password = passwordString
                }
            }catch (e: AuthRestException){
                when(e.statusCode) {
                    400,401 -> _uiState.value = AuthUiState.Error("bad request")
                    429 -> _uiState.value = AuthUiState.Error("too many requests")
                    else -> _uiState.value = AuthUiState.Error("Sign in failed for some reason ${e.message}")
                }

            }catch (e: Exception){
                _uiState.value = AuthUiState.Error("signin failed ${e.message}")
            }
        }
    }

    fun SignOut() {
        viewModelScope.launch {
            try {
                supabase.auth.signOut()
            }catch (e: Exception){
                _uiState.value= AuthUiState.Error("OH BUDDY. YOU ARE LOCKED IN HERE")
            }
        }
    }


    override fun onCleared() {
        super.onCleared()
        authStateJob.cancel("ViewModel Death")
    }
}
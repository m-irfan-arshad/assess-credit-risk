package com.ai.credit.risk.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _isLoading = MutableStateFlow(true)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        simulateLoading()
    }

    private fun simulateLoading() {
        // Replace with real logic (API/auth/db)
        viewModelScope.launch {
            kotlinx.coroutines.delay(1000)
            _isLoading.value = false
        }
    }
}
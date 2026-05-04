package com.ai.credit.risk.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.ai.credit.risk.presentation.viewmodel.SplashViewModel
import com.ai.finrisk.ui.theme.FinRiskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SplashViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Keep splash until loading finishes
        splashScreen.setKeepOnScreenCondition {
            viewModel.isLoading.value
        }


        setContent {
            FinRiskTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RiskAssessmentScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

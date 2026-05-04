package com.ai.credit.risk

import android.app.Application
import com.ai.credit.risk.logging.CrashlyticsTree
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class FinCreditRiskApp : Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.Forest.plant(Timber.DebugTree())
        } else {
            Timber.Forest.plant(CrashlyticsTree())
        }
    }
}
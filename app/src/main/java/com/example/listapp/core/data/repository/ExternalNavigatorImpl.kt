package com.example.listapp.core.data.repository

import android.content.Context
import com.example.listapp.core.domain.api.ExternalNavigator
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class ExternalNavigatorImpl @Inject constructor(
    @ApplicationContext private val context: Context
): ExternalNavigator {

    override fun launchTheApp(packageName: String) {
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
    }
}
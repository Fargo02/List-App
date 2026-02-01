package com.example.listapp.core.data.repository

import android.content.Context
import android.content.Intent
import com.example.listapp.core.domain.api.AppsRepository
import com.example.listapp.core.domain.model.InstalledApp
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor(
    @ApplicationContext private val context: Context
): AppsRepository {

    override suspend fun getAppsInfo(): List<InstalledApp> {
        val pm = context.packageManager

        val intent = Intent(Intent.ACTION_MAIN).apply {
            addCategory(Intent.CATEGORY_LAUNCHER)
        }

        return pm.queryIntentActivities(intent, 0)
            .map { resolveInfo ->
                val appInfo = requireNotNull(
                    resolveInfo.activityInfo.applicationInfo
                )

                InstalledApp(
                    name = pm.getApplicationLabel(appInfo).toString(),
                    packageName = appInfo.packageName,
                    icon = pm.getApplicationIcon(appInfo)
                )
            }
            .sortedBy { it.name.lowercase() }
    }

    override suspend fun getAppInfoByPackage(
        packageName: String
    ): InstalledApp? {
        val pm = context.packageManager

        return runCatching {
            val packageInfo = pm.getPackageInfo(packageName, 0)
            val appInfo = requireNotNull(packageInfo.applicationInfo)

            InstalledApp(
                name = pm.getApplicationLabel(appInfo).toString(),
                versionName = packageInfo.versionName ?: "",
                packageName = packageName,
                icon = pm.getApplicationIcon(appInfo),
                apkPath = appInfo.sourceDir
            )
        }.getOrNull()
    }
}
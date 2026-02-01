package com.example.listapp.details.domain.usecase.api

interface GetApkSha1UseCase {

    fun invoke(apkPath: String): String
}
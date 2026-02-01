package com.example.listapp.details.domain.usecase.impl

import com.example.listapp.details.domain.usecase.api.GetApkSha1UseCase
import java.io.File
import java.security.MessageDigest
import javax.inject.Inject

class GetApkSha1UseCaseImpl @Inject constructor(

): GetApkSha1UseCase {

    override operator fun invoke(apkPath: String): String {
        val digest = MessageDigest.getInstance("SHA-1")
        val file = File(apkPath)

        file.inputStream().use { input ->
            val buffer = ByteArray(8 * 1024)
            var read: Int
            while (input.read(buffer).also { read = it } != -1) {
                digest.update(buffer, 0, read)
            }
        }

        return digest.digest().joinToString(":") {
            "%02X".format(it)
        }
    }
}

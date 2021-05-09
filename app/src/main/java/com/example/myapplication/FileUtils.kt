package com.example.myapplication

import android.content.Context
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

internal object FileUtils {

    @Throws(IOException::class)
    fun fileFromAsset(context: Context, assetFileName: String): File {
        val outFile = File(context.cacheDir, "$assetFileName-pdfview.pdf")
        if (assetFileName.contains("/")) {
            outFile.parentFile.mkdirs()
        }
        context.assets.open(assetFileName).copyTo(outFile.outputStream())
        return outFile
    }

    @Throws(IOException::class)
    fun fileFromBase64(context: Context, data: ByteArray): File {
//        val decode = android.util.Base64.decode(data, android.util.Base64.DEFAULT)
        val file = File.createTempFile("image", null, context.cacheDir)
        val fileOutputStream = FileOutputStream(file)
        val bufferedOutputStream = BufferedOutputStream(fileOutputStream)
        try {
            bufferedOutputStream.write(data)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            try {
                bufferedOutputStream.close()
            } catch (e: IOException) {
                e.printStackTrace();
            }
        }
        return file
    }
}
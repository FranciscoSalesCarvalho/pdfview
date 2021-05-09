package com.example.myapplication

import android.content.Context
import android.util.AttributeSet
import java.io.File

class PDFView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null) : SubsamplingScaleImageView(context, attrs) {

    private var mfile: File? = null
    private var mScale: Float = 8f

    init {
        setMinimumTileDpi(120)
        setMinimumScaleType(SCALE_TYPE_START)
    }

    fun fromAsset(assetFileName: String): PDFView {
        mfile = FileUtils.fileFromAsset(context, assetFileName)
        return this
    }

    fun fromBase64(base64: ByteArray): PDFView {
        mfile = FileUtils.fileFromBase64(context, base64)
        return this
    }

    fun fromFile(file: File): PDFView {
        mfile = file
        return this
    }

    fun fromFile(filePath: String): PDFView {
        mfile = File(filePath)
        return this
    }

    fun scale(scale: Float): PDFView {
        mScale = scale
        return this
    }

    fun show() {
        val source = ImageSource.uri(mfile!!.path)
        setRegionDecoderFactory { PDFRegionDecoder(view = this, file = mfile!!, scale = mScale) }
        setImage(source)
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        this.recycle()
    }
}

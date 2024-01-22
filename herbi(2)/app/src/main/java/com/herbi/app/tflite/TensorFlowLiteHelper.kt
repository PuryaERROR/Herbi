package com.herbi.app.tflite

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Bitmap.createScaledBitmap
import android.os.Trace
import android.util.Log
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.io.IOException
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.FileChannel

object TensorFlowLiteHelper {
    private const val TAG = "TensorFlowLiteHelper"
    private var interpreter: Interpreter? = null

    const val NUM_CLASSES: Int = 5 // Change the value based on the number of classes in your model

    // Adjust this value based on your TFLite model's input size
    private const val inputSize = 224

    @Throws(IOException::class)
    fun loadModelFile(context: Context, modelFileName: String): Interpreter? {
        try {
            val modelPath = "file:///android_asset/$modelFileName"
            val modelFileDescriptor = context.assets.openFd(modelFileName)
            val fileChannel = FileInputStream(modelFileDescriptor.fileDescriptor).channel
            val startOffset = modelFileDescriptor.startOffset
            val declaredLength = modelFileDescriptor.declaredLength
            val modelFile = fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)

            val options = Interpreter.Options()
            interpreter = Interpreter(modelFile, options)
            Log.d(TAG, "TFLite model loaded successfully")
        } catch (e: Exception) {
            e.printStackTrace()
            Log.e(TAG, "Error loading TFLite model: ${e.message}")
        }

        return interpreter
    }


    // Preprocess the input image (resize, normalize, etc.)
    fun preprocessImage(bitmap: Bitmap): ByteBuffer {
        Trace.beginSection("Preprocess Image")

        val resizedBitmap = createScaledBitmap(bitmap, inputSize, inputSize, false)
        val byteBuffer = ByteBuffer.allocateDirect(1 * inputSize * inputSize * 3 * 4)
        byteBuffer.order(ByteOrder.nativeOrder())

        for (y in 0 until inputSize) {
            for (x in 0 until inputSize) {
                val px = resizedBitmap.getPixel(x, y)

                byteBuffer.putFloat(((px shr 16 and 0xFF) - 128) / 128.0f)
                byteBuffer.putFloat(((px shr 8 and 0xFF) - 128) / 128.0f)
                byteBuffer.putFloat(((px and 0xFF) - 128) / 128.0f)
            }
        }

        Trace.endSection()
        return byteBuffer
    }

    // Example function for running inference
    fun runInference(inputBuffer: ByteBuffer, outputBuffer: Array<FloatArray>) {
        Trace.beginSection("Run Inference")
        interpreter?.run(inputBuffer, outputBuffer)
        Trace.endSection()
    }

    // Postprocess the output
    fun postprocessOutput(outputBuffer: Array<FloatArray>): Int {
        Trace.beginSection("Postprocess Output")
        val plantClasses = listOf("Alugbati", "Ampalaya", "Bayabas", "Malunggay", "Oregano")

        var maxProbIndex = 0
        var maxProb = outputBuffer[0][0]

        for (i in 1 until outputBuffer[0].size) {
            if (outputBuffer[0][i] > maxProb) {
                maxProb = outputBuffer[0][i]
                maxProbIndex = i
            }
        }

        Trace.endSection()
        return maxProbIndex
    }

    // Release resources
    fun close() {
        interpreter?.close()
        interpreter = null
    }
}

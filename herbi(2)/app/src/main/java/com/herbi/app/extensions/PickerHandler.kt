package com.herbi.app.extensions

import android.Manifest
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.herbi.app.plantInfos.PlantInfoDictionary
import com.herbi.app.appcomponents.di.MyApp
import com.herbi.app.modules.result.ui.ResultActivity
import com.herbi.app.tflite.TensorFlowLiteHelper
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import java.lang.ref.WeakReference
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object PickerHandler {
    private var contextRef: WeakReference<Context>? = null

    // Constants
    private const val REQUEST_PERMISSION: Int = 10
    const val OPEN_CAMERA_REQUEST_CODE: Int = 1
    const val OPEN_STORAGE_REQUEST_CODE: Int = 2
    const val MIME_TYPE_IMAGE: String = "image/*"
    private const val MIME_TYPE_ALL: String = "*/*"

    // Set the context
    fun setContext(context: Context) {
        this.contextRef = WeakReference(context)
    }

    // Intent to pick a file
    fun filePickerIntent(mimeType: String = MIME_TYPE_ALL): Intent {
        val pickFile = Intent(Intent.ACTION_GET_CONTENT)
        pickFile.type = mimeType
        return pickFile
    }

    // Process the captured image
    fun processCapturedImage(imageBitmap: Bitmap) {
        Log.d("PickerHandler", "processCapturedImage called")

        val context = contextRef?.get()
        if (context == null) {
            Log.d("PickerHandler", "Context is null. Aborting processCapturedImage.")
            return
        }

        try {
            // Load the TensorFlow Lite model
            TensorFlowLiteHelper.loadModelFile(context, "Medicinal_fine_tuned.tflite")

            // Preprocess the input image (resize, normalize, etc.)
            val inputBuffer = TensorFlowLiteHelper.preprocessImage(imageBitmap)

            // Run inference
            val outputBuffer = Array(1) { FloatArray(TensorFlowLiteHelper.NUM_CLASSES) }
            TensorFlowLiteHelper.runInference(inputBuffer, outputBuffer)

            if (outputBuffer[0].isEmpty()) {
                Log.e("PickerHandler", "Output buffer is empty. Aborting processCapturedImage.")
                return
            }

            // Postprocess the output
            val predictedClass = TensorFlowLiteHelper.postprocessOutput(outputBuffer)

            // Fetch information for the predicted class from your dictionary
            val plantInfo = PlantInfoDictionary.plantInfoMap[predictedClass as? String]

            if (plantInfo == null) {
                Log.e("PickerHandler", "PlantInfo is null. Aborting processCapturedImage.")
                return
            }

            // Access the information from the PlantInfo object
            val herbName = plantInfo.herbName
            val scientificName = plantInfo.scientificName
            val description = plantInfo.description
            val medicinalUses = plantInfo.medicinalUses

            // Save the captured image and get the file path
            val capturedImagePath = saveCapturedImage(imageBitmap, context)

            // Start ResultActivity with the captured image path, predicted class, and plant information
            val intent = Intent(MyApp.getInstance(), ResultActivity::class.java).apply {
                putExtra("capturedImagePath", capturedImagePath)
                putExtra("predictedClass", predictedClass)
                putExtra("herbName", herbName)
                putExtra("scientificName", scientificName)
                putExtra("description", description)
                putExtra("medicinalUses", medicinalUses)
            }
            context.startActivity(intent)

        } catch (e: Exception) {
            e.printStackTrace()
            Log.e("PickerHandler", "Error processing captured image: ${e.message}")
        }
    }

    // Decode a Uri to Bitmap
    fun decodeUriToBitmap(uri: Uri, context: Context): Bitmap? {
        try {
            val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
            return inputStream?.let {
                BitmapFactory.decodeStream(it)
            }
        } catch (e: FileNotFoundException) {
            Log.e("PickerHandler", "File not found: ${e.message}")
        } catch (e: IOException) {
            Log.e("PickerHandler", "Error reading the Uri: ${e.message}")
        }
        return null
    }
    // Intent to take a picture from the camera
    fun takePictureFromCameraIntent(uri: Uri): Intent {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        return cameraIntent
    }

    // Save captured image
    private fun saveCapturedImage(imageBitmap: Bitmap, context: Context): String {
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(Date())
        val imageFileName = "JPEG_$timeStamp.jpg"

        val storageDir: File? = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        val imageFile = File.createTempFile(imageFileName, ".jpg", storageDir)

        try {
            val fileOutputStream = FileOutputStream(imageFile)
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream)
            fileOutputStream.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return imageFile.absolutePath
    }

    // Intent to pick a contact
    fun contactIntent(): Intent {
        return Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI)
    }

    // Get contact information
    fun getContactInfo(contactData: Uri) {
        val currentContext = contextRef?.get() ?: return

        val cursor: Cursor? = currentContext.contentResolver.query(contactData, null, null, null, null)

        cursor.use { cursor ->
            cursor?.moveToFirst()

        }
    }

    // Check if a valid camera intent is available
    @SuppressLint("QueryPermissionsNeeded")
    fun isValidCameraIntent(takePicture: Intent): Boolean {
        return takePicture.resolveActivity(MyApp.getInstance().packageManager) != null ||
                MyApp.getInstance().packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY)
    }

    // Create URI for camera intent
    fun createUri(context: Context?): Uri? {
        val title = "title"
        val values: ContentValues = ContentValues().apply {
            put(MediaStore.Images.Media.TITLE, title)
        }
        return context?.contentResolver?.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    }

    // Check camera and storage permissions before using the camera or gallery
    fun checkCameraAndStoragePermissions(): Boolean {
        val context = contextRef?.get() ?: return false

        return ContextCompat.checkSelfPermission(
            context,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ) == PackageManager.PERMISSION_GRANTED
    }

    // Request camera and storage permissions
    fun requestCameraAndStoragePermissions(activity: AppCompatActivity) {
        ActivityCompat.requestPermissions(
            activity,
            arrayOf(
                Manifest.permission.CAMERA,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ),
            REQUEST_PERMISSION
        )
    }
}

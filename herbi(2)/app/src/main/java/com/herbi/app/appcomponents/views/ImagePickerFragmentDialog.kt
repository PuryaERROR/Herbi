package com.herbi.app.appcomponents.views

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.herbi.app.R
import com.herbi.app.appcomponents.di.MyApp
import com.herbi.app.databinding.LayoutImagePickerDialogBinding
import com.herbi.app.extensions.PickerHandler
import com.vmadalin.easypermissions.EasyPermissions
import com.vmadalin.easypermissions.dialogs.SettingsDialog

class ImagePickerFragmentDialog : BottomSheetDialogFragment(),
    EasyPermissions.PermissionCallbacks {

    private var binding: LayoutImagePickerDialogBinding? = null
    private var imageUri: Uri? = null

    private lateinit var onImageSelectedCallback: (Uri?) -> Unit
    private var onPermissionResultCallback: ((Boolean) -> Unit)? = null

    companion object {
        private const val TAG = "ImagePickerDialog"
        private const val REQUEST_CAMERA_PERMISSION = 1001
        private const val OPEN_CAMERA_REQUEST_CODE = 1002
        private const val OPEN_STORAGE_REQUEST_CODE = 1003
    }

    override fun onDismiss(dialog: DialogInterface) {
        binding = null
        super.onDismiss(dialog)
    }

    private fun onImageSelected(uri: Uri?) {
        onImageSelectedCallback(uri)
        processCapturedImage(uri)
        dismiss()
    }

    private inline fun executeWithContext(callback: (Context) -> Unit) {
        context?.let { callback(it) }
    }

    private fun checkCameraPermissionAndOpenCamera() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openCamera()
        } else {
            requestCameraPermission()
        }
    }

    private fun openCamera() {
        imageUri = PickerHandler.createUri(requireContext())
        val takePicture = PickerHandler.takePictureFromCameraIntent(imageUri!!)

        executeWithContext {
            if (PickerHandler.isValidCameraIntent(takePicture)) {
                startActivityForResult(takePicture, OPEN_CAMERA_REQUEST_CODE)
            } else {
                // Handle Camera not found code
                dismiss()
            }
        }
    }

    private fun requestCameraPermission() {
        requestPermission(
            Manifest.permission.CAMERA,
            MyApp.getInstance().getString(R.string.msg_camera_permission)
        ) { isPermissionGranted ->
            if (isPermissionGranted) {
                openCamera()
            } else {
                dismiss()
            }
        }
    }

    private fun openGallery() {
        val pickFile = PickerHandler.filePickerIntent(PickerHandler.MIME_TYPE_IMAGE)
        startActivityForResult(pickFile, OPEN_STORAGE_REQUEST_CODE)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.layout_image_picker_dialog,
            container,
            false
        )

        initBinding()

        return binding?.root
    }

    private fun initBinding() {
        context ?: return
        binding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.layout_image_picker_dialog,
            null,
            false
        )

        binding?.textCamera?.setOnClickListener {
            checkCameraPermissionAndOpenCamera()
        }

        binding?.textGallery?.setOnClickListener {
            openGallery()
        }
    }

    private fun processCapturedImage(uri: Uri?) {
        uri?.let {
            // Decode the image URI to a Bitmap
            val imageBitmap = PickerHandler.decodeUriToBitmap(it, requireContext())

            // Call your image processing logic here
            if (imageBitmap != null) {
                PickerHandler.processCapturedImage(imageBitmap)
            }
        }
    }

    fun show(supportFragmentManager: FragmentManager, callback: (Uri?) -> Unit) {
        onImageSelectedCallback = {
            callback(it)
        }
        val oldDialog = supportFragmentManager.findFragmentByTag(TAG)
        if (oldDialog != null && oldDialog.isVisible) {
            (oldDialog as? ImagePickerFragmentDialog)?.dismissAllowingStateLoss()
        }
        show(supportFragmentManager, TAG)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            REQUEST_CAMERA_PERMISSION -> {
                EasyPermissions.onRequestPermissionsResult(
                    requestCode, permissions, grantResults,
                    this@ImagePickerFragmentDialog
                )
            }
            // Add other cases if needed
        }
    }

    private fun requestPermission(
        permission: String,
        message: String,
        onPermissionResultCallback: (Boolean) -> Unit
    ) {
        EasyPermissions.requestPermissions(
            this@ImagePickerFragmentDialog,
            message,
            REQUEST_CAMERA_PERMISSION,
            permission
        )
        this.onPermissionResultCallback = onPermissionResultCallback
    }

    override fun onPermissionsDenied(requestCode: Int, perms: List<String>) {
        if (EasyPermissions.somePermissionPermanentlyDenied(
                this@ImagePickerFragmentDialog,
                *perms.toTypedArray()
            )
        ) {
            executeWithContext {
                SettingsDialog.Builder(it).build().show()
            }
        }
        onPermissionResultCallback?.invoke(false)
    }

    override fun onPermissionsGranted(requestCode: Int, perms: List<String>) {
        onPermissionResultCallback?.invoke(true)
    }
}

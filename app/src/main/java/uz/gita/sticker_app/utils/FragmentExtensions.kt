package uz.gita.sticker_app.utils

import androidx.fragment.app.Fragment
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener

// Created by Jamshid Isoqov on 1/29/2023


fun Fragment.checkPermission(permission: String, onGranted: () -> Unit, onDenied: () -> Unit) {

    Dexter.withContext(requireContext())
        .withPermission(permission)
        .withListener(object : PermissionListener {
            override fun onPermissionGranted(p0: PermissionGrantedResponse?) {
                onGranted.invoke()
            }

            override fun onPermissionDenied(p0: PermissionDeniedResponse?) {
                onDenied.invoke()
            }

            override fun onPermissionRationaleShouldBeShown(
                p0: PermissionRequest?,
                p1: PermissionToken?
            ) {
                p1?.continuePermissionRequest()
            }

        })
}
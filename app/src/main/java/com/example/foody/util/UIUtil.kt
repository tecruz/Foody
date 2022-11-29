package com.example.foody.util

import android.view.View
import com.google.android.material.snackbar.Snackbar

class UIUtil {
    companion object {
        fun showSnackBar(rootView: View, message: String) {
            Snackbar.make(
                rootView,
                message,
                Snackbar.LENGTH_SHORT
            ).setAction("Okay") {}
                .show()
        }
    }
}
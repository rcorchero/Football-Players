package com.rcorchero.footballplayers.platform.extensions

import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AlertDialog
import com.rcorchero.footballplayers.R

fun Context.showMessage(message: String, onClickListener: DialogInterface.OnClickListener) {
    val builder = AlertDialog.Builder(this)
    builder.setMessage(message).setPositiveButton(this.getString(R.string.accept), onClickListener)
    builder.create().show()
}
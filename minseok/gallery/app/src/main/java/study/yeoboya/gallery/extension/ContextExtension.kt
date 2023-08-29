package study.yeoboya.gallery.extension

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.BaseTransientBottomBar.Duration

fun Context.showToast(message: String, @Duration duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this.applicationContext, message, duration).show()
}

fun Context.showToast(@StringRes messageRes: Int, @Duration duration: Int = Toast.LENGTH_SHORT) {
    showToast(applicationContext.getString(messageRes), duration)
}
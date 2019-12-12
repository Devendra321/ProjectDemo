package com.xtendbiz.projectdemo.base


import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import com.xtendbiz.projectdemo.ViewModelFactory


fun <T : ViewModel> AppCompatActivity.obtainViewModel(viewModelClass: Class<T>, viewModelFactory: ViewModelFactory) =

    ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)

fun <T : ViewModel> Fragment.obtainViewModel(viewModelClass: Class<T>, viewModelFactory: ViewModelFactory) =

    ViewModelProviders.of(this, viewModelFactory).get(viewModelClass)


fun <T> AppCompatActivity.navigateActivity(className: Class<T>, finish: Boolean) {
    this.startActivity(
        Intent(this, className)
            .setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
    )
    if (finish) this.finish()
}


fun AppCompatActivity.showToastMessage(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

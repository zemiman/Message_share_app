package com.example.zemiman.myfirstkotlinapp

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Context.ShowToast(message: String, duration:Int=Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration).show()

}
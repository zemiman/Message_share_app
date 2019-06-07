package com.example.zemiman.myfirstkotlinapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.zemiman.myfirstkotlinapp.Constants
import com.example.zemiman.myfirstkotlinapp.R
import com.example.zemiman.myfirstkotlinapp.ShowToast
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity(){
    companion object {
        val TAG:String=SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //safe call ?.
        //safe call with let ?.let{}
        val bundle: Bundle? = intent.extras
        bundle?.let {
            val msg=bundle.getString(Constants.USER_MSG_KEY)
            ShowToast(msg)
            //Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            txvUserMsg.text=msg
        }
    }
}

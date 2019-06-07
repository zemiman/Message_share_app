package com.example.zemiman.myfirstkotlinapp.activities

//import android.support.v7.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.zemiman.myfirstkotlinapp.Constants
import com.example.zemiman.myfirstkotlinapp.R
import com.example.zemiman.myfirstkotlinapp.R.id.btnshowme
import com.example.zemiman.myfirstkotlinapp.ShowToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        val TAG:String=MainActivity::class.java.simpleName
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnshowme.setOnClickListener {
            Log.i(TAG, "Button was clicked")
            ShowToast(resources.getString(R.string.btn_was_clicked), Toast.LENGTH_LONG)
            //Toast.makeText(this, "Button was clicked!", Toast.LENGTH_SHORT).show()

        }
        btnSendMSG.setOnClickListener {
            val message=etUserMessage.text.toString()
           //Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            val intent=Intent(this, SecondActivity::class.java)
            intent.putExtra(Constants.USER_MSG_KEY, message)
            startActivity(intent)

        }
        btnSharetoApps.setOnClickListener {
            val message=etUserMessage.text.toString()
            val intent=Intent()
            intent.action=Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.type="text/plain"
            startActivity(Intent.createChooser(intent, "please select an app: "))
        }
        btnRecyclerViewDemo.setOnClickListener {
            val intent=Intent(this, HobbiesActivity::class.java)
            startActivity(intent)
        }
    }
}

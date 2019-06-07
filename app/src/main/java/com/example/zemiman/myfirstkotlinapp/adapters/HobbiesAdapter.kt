package com.example.zemiman.myfirstkotlinapp.adapters

import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.zemiman.myfirstkotlinapp.models.Hobby
import com.example.zemiman.myfirstkotlinapp.R
import com.example.zemiman.myfirstkotlinapp.R.id.imgShare3
import com.example.zemiman.myfirstkotlinapp.ShowToast
import com.example.zemiman.myfirstkotlinapp.activities.MainActivity
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobby>) : RecyclerView.Adapter<HobbiesAdapter.MyHolderView>(){
    companion object {
        val TAG:String= HobbiesAdapter::class.java.simpleName
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyHolderView {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, p0, false)

        return MyHolderView(view)

    }

    override fun getItemCount(): Int {
        return hobbies.size

    }

    override fun onBindViewHolder(p0: MyHolderView, p1: Int) {
        val hobby=hobbies[p1]
        p0.setData(hobby, p1)

    }

    inner class MyHolderView(itemView: View) : RecyclerView.ViewHolder(itemView){
        var currentHobby: Hobby?=null
        var currentPosition: Int=0
        init {
//            val img=BitmapFactory.decodeResource(resources, R.drawable)
            itemView.setOnClickListener {
                currentHobby?.let {
                    context.ShowToast(currentHobby!!.title + " is Clicked!")
                    //Toast.makeText(context, currentHobby!!.title + " is Clicked!", Toast.LENGTH_SHORT).show()
                }
            }
            val img=BitmapFactory.decodeResource(itemView.resources, R.drawable.myphoto)
            val round=RoundedBitmapDrawableFactory.create(itemView.resources, img)
            round.isCircular=true
            itemView.imgShare3.setImageDrawable(round)

            itemView.imgShare.setOnClickListener {
                currentHobby?.let {
                    val message="My hobby is : " + currentHobby!!.title
                    val intent= Intent()
                    intent.action= Intent.ACTION_SEND
                    intent.putExtra(Intent.EXTRA_TEXT, message)
                    intent.type="text/plain"
                    context.startActivity(Intent.createChooser(intent, "please select an app: "))

                }
            }
        }
        fun setData(hobby: Hobby?, pos: Int){
            hobby?.let {
                itemView.txvTitle.text=hobby.title
            }

            this.currentHobby=hobby
            this.currentPosition=pos
        }
    }
}

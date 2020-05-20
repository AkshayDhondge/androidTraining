package com.example.firstandroidapp.activities.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.firstandroidapp.R
import com.example.firstandroidapp.activities.HomeScreenActivity
import com.example.firstandroidapp.activities.MainActivity
import com.example.firstandroidapp.activities.Model.Hobbies
import com.example.firstandroidapp.activities.Model.Supplier.hobbies
import kotlinx.android.synthetic.main.list_item.view.*

class HobbiesAdapter(val context: Context, private val hobbies: List<Hobbies>) :

    RecyclerView.Adapter<HobbiesAdapter.myViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        return myViewHolder(view)

    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        val hobby = hobbies[position]
        holder.setData(hobby, position)
    }

    inner class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var currentHobbie: Hobbies? = null
        var currentPosition: Int = 0

        init {
            itemView.setOnClickListener {
                Toast.makeText(context,currentHobbie!!.title + " Clicked!!", Toast.LENGTH_SHORT).show()
            }

            itemView.imgShare.setOnClickListener {
                val message: String = "My hobbie is: " + currentHobbie!!.title
                val intent  = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                context.startActivity(Intent.createChooser(intent,"Please select app"))

//                val intent1 = Intent(context, MainActivity::class.java)
//                context.startActivity(intent1)

            }
        }


        fun setData(hobby: Hobbies?, pos: Int) {
            itemView.txvTitle.text = hobby!!.title

            this.currentHobbie = hobby
            this.currentPosition = pos
        }
    }


}
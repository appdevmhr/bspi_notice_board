package com.appdevmhr.bangladeshswedenpolytechnic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdevmhr.bangladeshswedenpolytechnic.FullViewImage
import com.appdevmhr.bangladeshswedenpolytechnic.R
import com.appdevmhr.bangladeshswedenpolytechnic.model.SendMessageModel
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.Date

class SendMessageAdapter (var context: Context,
                          var list: ArrayList<SendMessageModel>):
    RecyclerView.Adapter<SendMessageAdapter.viewholder>(), simpleMethod {

    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var SMS: TextView
        var TIME: TextView
        var photo:ImageView




        init {
            TIME = itemView.findViewById(R.id.sender_time)
            SMS = itemView.findViewById(R.id.sender_sms)
            photo = itemView.findViewById(R.id.sender_image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.simple_send_message, parent, false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, i: Int) {
        val model = list[i]

        holder.SMS.text = list[i].sms
        val dateFormat = SimpleDateFormat("hh:mm a")
        holder.TIME.setText(
            dateFormat.format(
                Date(list[i].timestamp)
            )
        )
        Picasso.get().load(list[i].photo).placeholder(R.drawable.ic_baseline_account_circle_24)
            .into(holder.photo)

        holder.photo.setOnClickListener {
            val intent = Intent(context,FullViewImage::class.java)
            intent.putExtra("photo",list[i].photo)
            context.startActivity(intent)
        }

        if (list[i].photo.equals("NoPhotoAvailable")){
            holder.photo.visibility = View.GONE
        }
        if (list[i].sms.equals("photo_bspi_cst")){
            holder.SMS.visibility = View.GONE
        }

    }


}
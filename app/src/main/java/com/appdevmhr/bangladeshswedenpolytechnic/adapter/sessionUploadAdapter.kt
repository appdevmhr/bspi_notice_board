package com.appdevmhr.bangladeshswedenpolytechnic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdevmhr.bangladeshswedenpolytechnic.R
import com.appdevmhr.bangladeshswedenpolytechnic.SendMessage
import com.appdevmhr.bangladeshswedenpolytechnic.StudentListView
import com.appdevmhr.bangladeshswedenpolytechnic.model.ProbidanModel
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadSessionModel
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod

class sessionUploadAdapter(
    var context: Context,
    var collection: String, var list: ArrayList<uploadSessionModel>,
    var type:String
) :
    RecyclerView.Adapter<sessionUploadAdapter.viewholder>(), simpleMethod {


    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Session: TextView
        var Shift: TextView


        init {
            Session = itemView.findViewById(R.id.session_upload_session)
            Shift = itemView.findViewById(R.id.session_upload_shift)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.simple_session_upload, parent, false)
        return viewholder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewholder, i: Int) {
        val model = list[i]
        holder.Session.text = list[i].session
        holder.Shift.text = list[i].shift
        if (type == "SessionList") {
            holder.itemView.setOnClickListener {
                val intent = Intent(context, SendMessage::class.java)
                intent.putExtra("Session", list[i].session)
                intent.putExtra("Shift", list[i].shift)
                intent.putExtra("Department", list[i].department)
                intent.putExtra("collection", list[i].department + "StudentInfo")
                intent.putExtra("document", list[i].department + list[i].session + list[i].shift)
                context.startActivity(intent)
            }

        } else {
            holder.itemView.setOnClickListener {
                val intent = Intent(context, StudentListView::class.java)
                intent.putExtra("Session", list[i].session)
                intent.putExtra("Shift", list[i].shift)
                intent.putExtra("Department", list[i].department)
                intent.putExtra("collection", list[i].department + "StudentInfo")
                intent.putExtra("document", list[i].department + list[i].session + list[i].shift)
                context.startActivity(intent)
            }
        }
    }
}
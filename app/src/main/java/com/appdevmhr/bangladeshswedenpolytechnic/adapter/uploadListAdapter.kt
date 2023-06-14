package com.appdevmhr.bangladeshswedenpolytechnic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.appdevmhr.bangladeshswedenpolytechnic.R
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadFolderListModel
import com.appdevmhr.bangladeshswedenpolytechnic.model.uploadSessionModel
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod

class uploadListAdapter (
    var context: Context,
    var collection: String, var list: ArrayList<uploadFolderListModel>,
    var type:String
) :
    RecyclerView.Adapter<uploadListAdapter.viewholder>(), simpleMethod {
    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Session: TextView
        var Shift: TextView


        init {
            Session = itemView.findViewById(R.id.session_upload_session)
            Shift = itemView.findViewById(R.id.session_upload_shift)

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): uploadListAdapter.viewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.simple_session_upload, parent, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: viewholder, i: Int) {
        val model = list[i]
        holder.Session.text = list[i].folderName
        holder.Shift.text = list[i].date
        Toast.makeText(context,"jdasjfa",Toast.LENGTH_LONG).show()
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
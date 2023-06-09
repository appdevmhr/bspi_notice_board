package com.appdevmhr.bangladeshswedenpolytechnic.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdevmhr.bangladeshswedenpolytechnic.R
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list
import com.appdevmhr.bangladeshswedenpolytechnic.model.ProbidanModel
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod
import com.rajat.pdfviewer.PdfViewerActivity

open class probidanAdapter(var context: Context,
                           var collection: String,var list: ArrayList<ProbidanModel>) :
    RecyclerView.Adapter<probidanAdapter.viewholder>(), simpleMethod {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): probidanAdapter.viewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.simple_probidan, parent, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(holder: probidanAdapter.viewholder, i: Int) {
        val model = list[i]
        holder.Name.text = list[i].name
        holder.Title.text = list[i].title
        holder.Desc.text = list[i].desc
        holder.itemView.setOnClickListener {
            context.startActivity(PdfViewerActivity.Companion.launchPdfFromUrl(context,list[i].url,list[i].name,"",true));
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var Title: TextView
        var Desc: TextView

        init {
            Name = itemView.findViewById(R.id.probidan_name)
            Title = itemView.findViewById(R.id.probidan_title)
            Desc = itemView.findViewById(R.id.probidan_des)
              }
    }
}
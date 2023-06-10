package com.appdevmhr.bangladeshswedenpolytechnic.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdevmhr.bangladeshswedenpolytechnic.R
import com.appdevmhr.bangladeshswedenpolytechnic.adapter.adapter_simple_staff_list_Image.viewholder
import com.appdevmhr.bangladeshswedenpolytechnic.model.Model_simple_staff_list
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod
import com.appdevmhr.bangladeshswedenpolytechnic.ui.administation.staff_list_in_details
import com.appdevmhr.bangladeshswedenpolytechnic.ui.setPeople
import com.squareup.picasso.Picasso

open class adapter_simple_staff_list_Image(
    var context: Context,
    var collection: String,
    var list: ArrayList<Model_simple_staff_list>
) : RecyclerView.Adapter<viewholder>(), simpleMethod {
    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): viewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.simple_staff_list, viewGroup, false)
        return viewholder(view)
    }

    override fun onBindViewHolder(viewholder: viewholder, i: Int) {
        val model = list[i]
        viewholder.Name.text = list[i].simple_staff_list_Name
        viewholder.Post.text = list[i].simple_staff_list_post
        Picasso.get().load(list[i].imagelink).placeholder(R.drawable.ic_baseline_account_circle_24)
            .into(viewholder.Photo)

        if(simpleMethod.ADMIN_ACCOUNT == true){
            viewholder.itemView.setOnLongClickListener {
                setIntentForSetPeaple(
                    context,
                    setPeople::class.java,
                    collection,
                    model.simple_staff_list_Name
                )
                false
            }
        }

        viewholder.view_details.setOnClickListener {
            val intent = Intent(context, staff_list_in_details::class.java)
            intent.putExtra("name", model.simple_staff_list_Name)
            intent.putExtra("post", model.simple_staff_list_post)
            intent.putExtra("section", model.section)
            intent.putExtra("homeDistrict", model.homeDistrict)
            intent.putExtra("education", model.education)
            intent.putExtra("govtJobJoiningDate", model.govtJobJoiningDate)
            intent.putExtra("currentPositionJoinningDate", model.currentPositionJoinningDate)
            intent.putExtra("currentInstituteJoinningDate", model.currentInstituteJoinningDate)
            intent.putExtra("mobile", model.mobile)
            intent.putExtra("email", model.email)
            intent.putExtra("photo", model.simple_staff_list_Image)
            intent.putExtra("photoLink", model.imagelink)
            context.startActivity(intent)
        }
        viewholder.itemView.setOnClickListener {
            val intent = Intent(context, staff_list_in_details::class.java)
            intent.putExtra("name", model.simple_staff_list_Name)
            intent.putExtra("post", model.simple_staff_list_post)
            intent.putExtra("section", model.section)
            intent.putExtra("homeDistrict", model.homeDistrict)
            intent.putExtra("education", model.education)
            intent.putExtra("govtJobJoiningDate", model.govtJobJoiningDate)
            intent.putExtra("currentPositionJoinningDate", model.currentPositionJoinningDate)
            intent.putExtra("currentInstituteJoinningDate", model.currentInstituteJoinningDate)
            intent.putExtra("mobile", model.mobile)
            intent.putExtra("email", model.email)
            intent.putExtra("photo", model.simple_staff_list_Image)
            intent.putExtra("photoLink", model.imagelink)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var Post: TextView
        var Photo: ImageView
        var view_details: Button

        init {
            Name = itemView.findViewById(R.id.simple_staff_list_Name)
            Post = itemView.findViewById(R.id.simple_staff_list_post)
            Photo = itemView.findViewById(R.id.simple_staff_list_Image)
            view_details = itemView.findViewById(R.id.Simple_staff_list_Button)
        }
    }
}
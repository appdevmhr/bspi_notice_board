package com.appdevmhr.bangladeshswedenpolytechnic

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appdevmhr.bangladeshswedenpolytechnic.model.Signup_Student_Model
import com.appdevmhr.bangladeshswedenpolytechnic.ui.administation.staff_list_in_details
import com.squareup.picasso.Picasso

class StudentListAdapter  (var context: Context,
var collection: String,var document:String,var Session:String,var Shift:String,var Department:String,
var list: ArrayList<Signup_Student_Model>
) : RecyclerView.Adapter<StudentListAdapter.viewholder>(), simpleMethod {

    inner class viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var Name: TextView
        var Roll: TextView
        var Photo: ImageView
        var view_details: Button

        init {
            Name = itemView.findViewById(R.id.simple_student_list_Name)
            Roll = itemView.findViewById(R.id.simple_student_list_roll)
            Photo = itemView.findViewById(R.id.simple_student_list_photo)
            view_details = itemView.findViewById(R.id.simple_student_list_Button)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        val view =
            LayoutInflater.from(context).inflate(R.layout.simple_student_list, parent, false)
        return viewholder(view)    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(viewholder: viewholder, i: Int) {
        val model = list[i]
        viewholder.Name.text = list[i].name
        viewholder.Roll.text = list[i].roll
        Picasso.get().load(list[i].photo).placeholder(R.drawable.ic_baseline_account_circle_24)
            .into(viewholder.Photo)
        viewholder.itemView.setOnLongClickListener {
            setIntentForSetStudentListView(
                context,
                Signup_Student::class.java, collection, document, Session, Shift, Department
            )

            false
        }

        viewholder.view_details.setOnClickListener {
            val intent = Intent(context, StudentDetails::class.java)
            intent.putExtra("name", model.name)
            intent.putExtra("roll", model.roll)
            intent.putExtra("registration", model.registration)
            intent.putExtra("homeDistrict", model.homeDistrict)
            intent.putExtra("studentMobileNumber", model.studentMobileNumber)
            intent.putExtra("gordianName", model.gordianName)
            intent.putExtra("gordianMobileNumber", model.gordianMobileNumber)
            intent.putExtra("email_address", model.email_address)
            intent.putExtra("session", model.session)
            intent.putExtra("shift", model.shift)
            intent.putExtra("department", model.department)
            intent.putExtra("photo", model.photo)
            context.startActivity(intent)
        }
        viewholder.itemView.setOnClickListener {
            val intent = Intent(context, StudentDetails::class.java)
            intent.putExtra("name", model.name)
            intent.putExtra("roll", model.roll)
            intent.putExtra("registration", model.registration)
            intent.putExtra("homeDistrict", model.homeDistrict)
            intent.putExtra("studentMobileNumber", model.studentMobileNumber)
            intent.putExtra("gordianName", model.gordianName)
            intent.putExtra("gordianMobileNumber", model.gordianMobileNumber)
            intent.putExtra("email_address", model.email_address)
            intent.putExtra("session", model.session)
            intent.putExtra("shift", model.shift)
            intent.putExtra("department", model.department)
            intent.putExtra("photo", model.photo)
            context.startActivity(intent)
        }

    }

}
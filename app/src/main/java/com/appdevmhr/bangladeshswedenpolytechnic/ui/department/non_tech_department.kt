package com.appdevmhr.bangladeshswedenpolytechnic.ui.department

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appdevmhr.bangladeshswedenpolytechnic.BoardResultView
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentNonTechDepartmentBinding
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod

class non_tech_department : Fragment(), simpleMethod {
    var binding: FragmentNonTechDepartmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentNonTechDepartmentBinding.inflate(inflater, container, false)
        binding!!.OurTeachers.setOnClickListener {
            setIntentForSetPeaple(
                activity, TeacherView::class.java, "ntTeachers", ""
            )
        }
        binding!!.StaffList.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "ntStaffList",
                ""
            )
        }
        binding!!.ourTeacherButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "ntTeachers",
                ""
            )
        }
        binding!!.staffListButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "ntStaffList",
                ""
            )
        }
        binding!!.DepartmentNotice.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","non_tech_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.dn.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection", "non_tech_DepartmentNotice")
            startActivity(intent)
        }
        return binding!!.root
    }
}
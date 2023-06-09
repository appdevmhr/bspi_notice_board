package com.appdevmhr.bangladeshswedenpolytechnic.ui.department

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appdevmhr.bangladeshswedenpolytechnic.BoardResultView
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentAutomobileDepartmentBinding
import com.appdevmhr.bangladeshswedenpolytechnic.funtionOfMain
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod

class automobile_department : Fragment(), simpleMethod, funtionOfMain {
    var binding: FragmentAutomobileDepartmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAutomobileDepartmentBinding.inflate(inflater, container, false)
        binding!!.OurTeachers.setOnClickListener {
            setIntentForSetPeaple(
                activity, TeacherView::class.java, "atTeachers", ""
            )
        }
        binding!!.StaffList.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "atStaffList",
                ""
            )
        }
        binding!!.ourTeacherButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "atTeachers",
                ""
            )
        }
        binding!!.staffListButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "atStaffList",
                ""
            )
        }
        binding!!.br.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_BoardResult")
            startActivity(intent)
        }
        binding!!.cr.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_ClassRoutine")
            startActivity(intent)
        }
        binding!!.ClassRoutine.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_ClassRoutine")
            startActivity(intent)
        }
         binding!!.SemesterPlan.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_SemesterPlan")
            startActivity(intent)
        }
        binding!!.sp.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_SemesterPlan")
            startActivity(intent)
        }
         binding!!.Syllabus.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_Syllabus")
            startActivity(intent)
        }
        binding!!.sb.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_Syllabus")
            startActivity(intent)
        }
         binding!!.DigitalContent.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_DigitalContent")
            startActivity(intent)
        }
        binding!!.dc.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_DigitalContent")
            startActivity(intent)
        }
        binding!!.DepartmentNotice.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.dn.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.BoardResult.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","automobile_BoardResult")
            startActivity(intent)
        }

        return binding!!.root
    }

}
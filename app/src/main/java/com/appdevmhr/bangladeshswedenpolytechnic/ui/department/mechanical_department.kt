package com.appdevmhr.bangladeshswedenpolytechnic.ui.department

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appdevmhr.bangladeshswedenpolytechnic.BoardResultView
import com.appdevmhr.bangladeshswedenpolytechnic.StudentInfo
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentMechanicalDepartmentBinding
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod

class mechanical_department : Fragment(), simpleMethod {
    var binding: FragmentMechanicalDepartmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMechanicalDepartmentBinding.inflate(inflater, container, false)
        binding!!.OurTeachers.setOnClickListener {
            setIntentForSetPeaple(
                activity, TeacherView::class.java, "mtTeachers", ""
            )
        }
        binding!!.StaffList.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "mtStaffList",
                ""
            )
        }
        binding!!.ourTeacherButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "mtTeachers",
                ""
            )
        }
        binding!!.staffListButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "mtStaffList",
                ""
            )
        }
        binding!!.br.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_BoardResult")
            startActivity(intent)
        }
        binding!!.cr.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_ClassRoutine")
            startActivity(intent)
        }
        binding!!.ClassRoutine.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_ClassRoutine")
            startActivity(intent)
        }
        binding!!.SemesterPlan.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_SemesterPlan")
            startActivity(intent)
        }
        binding!!.sp.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_SemesterPlan")
            startActivity(intent)
        }
        binding!!.Syllabus.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_Syllabus")
            startActivity(intent)
        }
        binding!!.sb.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_Syllabus")
            startActivity(intent)
        }
        binding!!.DigitalContent.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_DigitalContent")
            startActivity(intent)
        }
        binding!!.dc.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_DigitalContent")
            startActivity(intent)
        }
        binding!!.DepartmentNotice.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.dn.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.BoardResult.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_BoardResult")
            startActivity(intent)
        }
        binding!!.Stipend.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_Stipend")
            startActivity(intent)
        }
        binding!!.sd.setOnClickListener {
            val intent = Intent(context,BoardResultView::class.java)
            intent.putExtra("collection","mechanical_Stipend")
            startActivity(intent)
        }
        binding!!.StudentInformation.setOnClickListener {
            setIntentForSetUploadSession(
                context,
                StudentInfo::class.java, "StudentInfo", "", "mechanical"
            )

        }
        binding!!.si.setOnClickListener {
            setIntentForSetUploadSession(
                context,
                StudentInfo::class.java, "StudentInfo", "", "mechanical"
            )

        }

        return binding!!.root
    }
}
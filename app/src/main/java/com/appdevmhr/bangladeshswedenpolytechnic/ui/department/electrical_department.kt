package com.appdevmhr.bangladeshswedenpolytechnic.ui.department

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.appdevmhr.bangladeshswedenpolytechnic.BoardResultView
import com.appdevmhr.bangladeshswedenpolytechnic.StudentInfo
import com.appdevmhr.bangladeshswedenpolytechnic.databinding.FragmentElectricalDepartmentBinding
import com.appdevmhr.bangladeshswedenpolytechnic.simpleMethod

class electrical_department : Fragment(), simpleMethod {
    var binding: FragmentElectricalDepartmentBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentElectricalDepartmentBinding.inflate(inflater, container, false)
        binding!!.OurTeachers.setOnClickListener {
            setIntentForSetPeaple(
                activity, TeacherView::class.java, "etTeachers", ""
            )
        }
        binding!!.StaffList.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "etStaffList",
                ""
            )
        }
        binding!!.ourTeacherButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "etTeachers",
                ""
            )
        }
        binding!!.staffListButton.setOnClickListener {
            setIntentForSetPeaple(
                activity,
                TeacherView::class.java,
                "etStaffList",
                ""
            )
        }
        binding!!.br.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_BoardResult")
            startActivity(intent)
        }
        binding!!.cr.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_ClassRoutine")
            startActivity(intent)
        }
        binding!!.ClassRoutine.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_ClassRoutine")
            startActivity(intent)
        }
        binding!!.SemesterPlan.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_SemesterPlan")
            startActivity(intent)
        }
        binding!!.sp.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_SemesterPlan")
            startActivity(intent)
        }
        binding!!.Syllabus.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_Syllabus")
            startActivity(intent)
        }
        binding!!.sb.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_Syllabus")
            startActivity(intent)
        }
        binding!!.DigitalContent.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_DigitalContent")
            startActivity(intent)
        }
        binding!!.dc.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_DigitalContent")
            startActivity(intent)
        }
        binding!!.DepartmentNotice.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.dn.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_DepartmentNotice")
            startActivity(intent)
        }
        binding!!.BoardResult.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_BoardResult")
            startActivity(intent)
        }
        binding!!.Stipend.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_Stipend")
            startActivity(intent)
        }
        binding!!.sd.setOnClickListener {
            val intent = Intent(context, BoardResultView::class.java)
            intent.putExtra("collection","electrical_Stipend")
            startActivity(intent)
        }
        binding!!.StudentInformation.setOnClickListener {
            setIntentForSetUploadSession(
                context,
                StudentInfo::class.java, "StudentInfo", "", "electrical"
            )

        }
        binding!!.si.setOnClickListener {
            setIntentForSetUploadSession(
                context,
                StudentInfo::class.java, "StudentInfo", "", "electrical"
            )

        }
        return binding!!.root
    }
}
package com.example.gpacalculator

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.gpacalculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding


    private lateinit var cs1Sem: Semester

    private lateinit var cs2Sem: Semester

    private lateinit var cs3Sem: Semester

    private lateinit var cs4Sem: Semester

    private lateinit var cs5Sem: Semester

    private lateinit var cs6Sem: Semester

    private lateinit var cs7Sem: Semester

    private lateinit var cs8Sem: Semester

    private lateinit var man1Sem: Semester

    private lateinit var man2Sem: Semester

    private lateinit var man3Sem: Semester

    private lateinit var man4Sem: Semester

    private lateinit var man5Sem: Semester

    private lateinit var man6Sem: Semester

    private lateinit var man7Sem: Semester

    private lateinit var man8Sem: Semester

    private lateinit var math1Sem: Semester

    private lateinit var math2Sem: Semester

    private lateinit var math3Sem: Semester

    private lateinit var math4Sem: Semester

    private lateinit var math5Sem: Semester

    private lateinit var math6Sem: Semester

    private lateinit var math7Sem: Semester

    private lateinit var math8Sem: Semester

    private var choosingCourse:Boolean = false

    private var choosingSemester:Boolean = false

    private var currentCourse:Course = Course.CS

    private var currentSemester:Int = 1

    private lateinit var currentView:ConstraintLayout

    private lateinit var currentSubjects:List<Subject>

    private lateinit var gradeList: List<EditText>

    private var subGradeMap: MutableMap<Subject, Float> = mutableMapOf()





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mainBinding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


         cs1Sem = Semester(listOf(Subject.I2I,Subject.DS,Subject.I2CA,Subject.FOP,Subject.ENG),mainBinding.cs1SemesterLayout.cs1SemesterLayout)
         cs2Sem = Semester(listOf(Subject.OCAML,Subject.CALC,Subject.CALAB,Subject.OS,Subject.ENG), mainBinding.cs2SemesterLayout.cs2SemesterLayout)
         cs3Sem = Semester(listOf(Subject.BASES,Subject.AIDS,Subject.LINEAR,Subject.MINOR1,Subject.MINOR2), mainBinding.cs3SemesterLayout.cs3SemesterLayout)
         cs4Sem = Semester(listOf(Subject.SCRIPT,Subject.TC,Subject.DPT,Subject.MINOR1,Subject.MINOR2),mainBinding.cs4SemesterLayout.cs4SemesterLayout )
         cs5Sem = Semester(listOf(Subject.NP,Subject.I2SW,Subject.ELECTIVE,Subject.MINOR1,Subject.MINOR2),mainBinding.cs5SemesterLayout.cs5SemesterLayout)
         cs6Sem = Semester(listOf(Subject.I2CNDS,Subject.BASES,Subject.SOFTWARE,Subject.ELECTIVE,Subject.MINOR1),mainBinding.cs6SemesterLayout.cs6SemesterLayout)
         cs7Sem = Semester(listOf(Subject.ELECTIVE,Subject.ELECTIVE2,Subject.ELECTIVE3,Subject.INTERN),mainBinding.cs7SemesterLayout.cs7SemesterLayout)
         cs8Sem = Semester(listOf(Subject.ELECTIVE,Subject.ELECTIVE2,Subject.THESIS),mainBinding.cs8SemesterLayout.cs8SemesterLayout)

        man1Sem = Semester(listOf(Subject.FEB,Subject.Economics,Subject.MS,Subject.C4B,Subject.ENGMAN),mainBinding.mg1SemesterLayout.mg1SemesterLayout)
        man2Sem = Semester(listOf(Subject.PRMAN,Subject.Economics,Subject.C4B,Subject.PROB,Subject.ENGMAN),mainBinding.mg2SemesterLayout.mg2SemesterLayout)
        man3Sem = Semester(listOf(Subject.FA,Subject.I2M,Subject.HRM,Subject.SBE,Subject.ENGMAN),mainBinding.mg3SemesterLayout.mg3SemesterLayout)
        man4Sem = Semester(listOf(Subject.OB,Subject.LBL,Subject.CA,Subject.POM,Subject.I2PDA),mainBinding.mg4SemesterLayout.mg4SemesterLayout)
        man5Sem = Semester(listOf(Subject.I2SM,Subject.CONS,Subject.ACS,Subject.MINOR1,Subject.MINOR2),mainBinding.mg5SemesterLayout.mg5SemesterLayout)
        man6Sem = Semester(listOf(Subject.RM,Subject.BE,Subject.IFM,Subject.ELECTIVE,Subject.CONS,Subject.MINOR1),mainBinding.mg6SemesterLayout.mg6SemesterLayout)
        man7Sem = Semester(listOf(Subject.INTENRMAN,Subject.ELECTIVE,Subject.MINOR1,Subject.MINOR2,Subject.MINOR3),mainBinding.mg7SemesterLayout.mg7SemesterLayout)
        man8Sem = Semester(listOf(Subject.ELECTIVE,Subject.CONS,Subject.MINOR1,Subject.THESISMAN),mainBinding.mg8SemesterLayout.mg8SemesterLayout)

        math1Sem = Semester(listOf(Subject.CalcMath,Subject.LinearMath,Subject.I2MS,Subject.ENG),mainBinding.math1SemesterLayout.math1SemesterLayout)
        math2Sem = Semester(listOf(Subject.AnalysisMath,Subject.LADS,Subject.I2P,Subject.ENG),mainBinding.math2SemesterLayout.math2SemesterLayout)
        math3Sem = Semester(listOf(Subject.Analisys2,Subject.Numerical,Subject.I2PR,Subject.MINOR1,Subject.MINOR2),mainBinding.math3SemesterLayout.math3SemesterLayout)
        math4Sem = Semester(listOf(Subject.OPT,Subject.NA,Subject.Analisys2,Subject.MINOR1,Subject.MINOR2),mainBinding.math4SemesterLayout.math4SemesterLayout)
        math5Sem = Semester(listOf(Subject.LO,Subject.ELECTIVE,Subject.I2SP,Subject.MINOR1,Subject.MINOR2),mainBinding.math5SemesterLayout.math5SemesterLayout)
        math6Sem = Semester(listOf(Subject.CNO,Subject.NMDE,Subject.SDE,Subject.ELECTIVE,Subject.MINOR1),mainBinding.math6SemesterLayout.math6SemesterLayout)
        math7Sem = Semester(listOf(Subject.ATP,Subject.ATNM,Subject.ATPS,Subject.INTERN),mainBinding.math7SemesterLayout.math7SemesterLayout)
        math8Sem = Semester(listOf(Subject.ELECTIVE,Subject.ME,Subject.THESIS),mainBinding.math8SemesterLayout.math8SemesterLayout)



        currentView = cs1Sem.view
        currentSubjects = cs1Sem.subjects
        gradeList = listOf(mainBinding.score1,mainBinding.score2,mainBinding.score3,mainBinding.score4,mainBinding.score5,mainBinding.score6)

        mainBinding.main.setOnClickListener{
            choosingCourse = false
            choosingSemester = false
            showCourses()
            showSemesters()
            calcGpa()
            hideKeyboard()
        }

        val regex = Regex("([1234567890])*")

        gradeList.forEach { editText ->

            var keyon:Boolean = true

            editText.setOnClickListener {
                if (!regex.matches(editText.text.toString())) {
                    editText.error = "Invalid input"
                }
                calcGpa()
                if (keyon)hideKeyboard()

                keyon=!keyon


            }
        }


        mainBinding.chooseCourse.setOnClickListener {
            choosingCourse = !choosingCourse
            showCourses()
            choosingCourse=!choosingCourse
        }

        mainBinding.courseNum.setOnClickListener {
            choosingSemester = !choosingSemester
            showSemesters()
            choosingSemester=!choosingSemester
        }

        mainBinding.CompScience.setOnClickListener {
            currentCourse = Course.CS
            mainBinding.chooseCourse.text = mainBinding.CompScience.text
            choosingCourse = false
            showCourses()
            showSemesterLayout()
        }

        mainBinding.Managemant.setOnClickListener {
            currentCourse = Course.MANAGEMANT
            mainBinding.chooseCourse.text = mainBinding.Managemant.text
            choosingCourse = false
            showCourses()
            showSemesterLayout()
        }

        mainBinding.Math.setOnClickListener {
            currentCourse = Course.MATH
            mainBinding.chooseCourse.text = mainBinding.Math.text
            choosingCourse = false
            showCourses()
            showSemesterLayout()
        }

        mainBinding.semester1.setOnClickListener {
            currentSemester=1
            mainBinding.courseNum.text = mainBinding.semester1.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester2.setOnClickListener {
            currentSemester=2
            mainBinding.courseNum.text = mainBinding.semester2.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester3.setOnClickListener {
            currentSemester=3
            mainBinding.courseNum.text = mainBinding.semester3.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester4.setOnClickListener {
            currentSemester=4
            mainBinding.courseNum.text = mainBinding.semester4.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester5.setOnClickListener {
            currentSemester=5
            mainBinding.courseNum.text = mainBinding.semester5.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester6.setOnClickListener {
            currentSemester=6
            mainBinding.courseNum.text = mainBinding.semester6.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester7.setOnClickListener {
            currentSemester=7
            mainBinding.courseNum.text = mainBinding.semester7.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }
        mainBinding.semester8.setOnClickListener {
            currentSemester=8
            mainBinding.courseNum.text = mainBinding.semester8.text
            choosingSemester = false
            showSemesters()
            showSemesterLayout()
        }


    }


    private fun showCourses(){
        if (choosingCourse){
        mainBinding.CompScience.visibility = View.VISIBLE
        mainBinding.Managemant.visibility = View.VISIBLE
        mainBinding.Math.visibility = View.VISIBLE
        }
        else{
            mainBinding.CompScience.visibility = View.GONE
            mainBinding.Managemant.visibility = View.GONE
            mainBinding.Math.visibility = View.GONE
        }
        calcGpa()
    }


    private fun showSemesters(){
        if (choosingSemester) {
            mainBinding.semester1.visibility = View.VISIBLE
            mainBinding.semester2.visibility = View.VISIBLE
            mainBinding.semester3.visibility = View.VISIBLE
            mainBinding.semester4.visibility = View.VISIBLE
            mainBinding.semester5.visibility = View.VISIBLE
            mainBinding.semester6.visibility = View.VISIBLE
            mainBinding.semester7.visibility = View.VISIBLE
            mainBinding.semester8.visibility = View.VISIBLE
        }
        else {
            mainBinding.semester1.visibility = View.GONE
            mainBinding.semester2.visibility = View.GONE
            mainBinding.semester3.visibility = View.GONE
            mainBinding.semester4.visibility = View.GONE
            mainBinding.semester5.visibility = View.GONE
            mainBinding.semester6.visibility = View.GONE
            mainBinding.semester7.visibility = View.GONE
            mainBinding.semester8.visibility = View.GONE
        }
        calcGpa()
    }

    private fun showSemesterLayout(){
        currentView.visibility = View.GONE
        mainBinding.score6.visibility = View.GONE
        subGradeMap = mutableMapOf()
        when(currentSemester){
            1 -> when(currentCourse){
                Course.CS -> {
                    cs1Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs1Sem.subjects
                    currentView = cs1Sem.view
                }
                Course.MANAGEMANT -> {
                    man1Sem.view.visibility= View.VISIBLE
                    currentSubjects = man1Sem.subjects
                    currentView = man1Sem.view
                }
                Course.MATH -> {
                    math1Sem.view.visibility= View.VISIBLE
                    currentSubjects = math1Sem.subjects
                    currentView = math1Sem.view
                }
            }
            2 -> when(currentCourse){
                Course.CS -> {
                    cs2Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs2Sem.subjects
                    currentView = cs2Sem.view
                }
                Course.MANAGEMANT -> {
                    man2Sem.view.visibility= View.VISIBLE
                    currentSubjects = man2Sem.subjects
                    currentView = man2Sem.view
                }
                Course.MATH -> {
                    math2Sem.view.visibility= View.VISIBLE
                    currentSubjects = math2Sem.subjects
                    currentView = math2Sem.view
                }
            }
            3 -> when(currentCourse){
                Course.CS -> {
                    cs3Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs3Sem.subjects
                    currentView = cs3Sem.view
                }
                Course.MANAGEMANT -> {
                    man3Sem.view.visibility= View.VISIBLE
                    currentSubjects = man3Sem.subjects
                    currentView = man3Sem.view
                }
                Course.MATH -> {
                    math3Sem.view.visibility= View.VISIBLE
                    currentSubjects = math3Sem.subjects
                    currentView = math3Sem.view
                }
            }
            4 -> when(currentCourse){
                Course.CS -> {
                    cs4Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs4Sem.subjects
                    currentView = cs4Sem.view
                }
                Course.MANAGEMANT -> {
                    man4Sem.view.visibility= View.VISIBLE
                    currentSubjects = man4Sem.subjects
                    currentView = man4Sem.view
                }
                Course.MATH -> {
                    math4Sem.view.visibility= View.VISIBLE
                    currentSubjects = math4Sem.subjects
                    currentView = math4Sem.view
                }
            }
            5 -> when(currentCourse){
                Course.CS -> {
                    cs5Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs5Sem.subjects
                    currentView = cs5Sem.view
                }
                Course.MANAGEMANT -> {
                    man5Sem.view.visibility= View.VISIBLE
                    currentSubjects = man5Sem.subjects
                    currentView = man5Sem.view
                }
                Course.MATH -> {
                    math5Sem.view.visibility= View.VISIBLE
                    currentSubjects = math5Sem.subjects
                    currentView = math5Sem.view
                }
            }
            6 -> when(currentCourse){
                Course.CS -> {
                    cs6Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs6Sem.subjects
                    currentView = cs6Sem.view
                }
                Course.MANAGEMANT -> {
                    mainBinding.score6.visibility = View.VISIBLE
                    man6Sem.view.visibility= View.VISIBLE
                    currentSubjects = man6Sem.subjects
                    currentView = man6Sem.view
                }
                Course.MATH -> {
                    math6Sem.view.visibility= View.VISIBLE
                    currentSubjects = math6Sem.subjects
                    currentView = math6Sem.view
                }
            }
            7 -> when(currentCourse){
                Course.CS -> {
                    cs7Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs7Sem.subjects
                    currentView = cs7Sem.view
                }
                Course.MANAGEMANT -> {
                    man7Sem.view.visibility= View.VISIBLE
                    currentSubjects = man7Sem.subjects
                    currentView = man7Sem.view
                }
                Course.MATH -> {
                    math7Sem.view.visibility= View.VISIBLE
                    currentSubjects = math7Sem.subjects
                    currentView = math7Sem.view
                }
            }
            8 -> when(currentCourse){
                Course.CS -> {
                    cs8Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs8Sem.subjects
                    currentView = cs8Sem.view
                }
                Course.MANAGEMANT -> {
                    man8Sem.view.visibility= View.VISIBLE
                    currentSubjects = man8Sem.subjects
                    currentView = man8Sem.view
                }
                Course.MATH -> {
                    math8Sem.view.visibility= View.VISIBLE
                    currentSubjects = math8Sem.subjects
                    currentView = math8Sem.view
                }
            }
                  
        }

        calcGpa()
    }

    
    private fun calcGpa(){
        mapSubjects()

        var gpSum = 0.0f
        var creditSum = 0.0f
        for (n in  subGradeMap.keys){
            if (subGradeMap[n]!! !=0.0f){
                creditSum+=n.credits
                gpSum+=n.credits* subGradeMap[n]!!
            }
        }
        val result = gpSum/creditSum

        mainBinding.Gpa.text = result.toString()

    }


    private fun mapSubjects(){
        val gradeToGpList = gradeToGp()
        for ((index, n) in currentSubjects.withIndex()){
            subGradeMap[n] = gradeToGpList[index]

        }

    }


    private fun gradeToGp():List<Float>{
        val gpList:MutableList<Float> = mutableListOf()
        var index = 0;
        for (n in gradeList){
            var x = n.text.toString().toIntOrNull() ?:0
            if (x>=94) gpList.add(index,4.0F)
            else if (91<=x) gpList.add(index,3.7f)
            else if (88<=x) gpList.add(index,3.4f)
            else if (85<=x) gpList.add(index,3.1f)
            else if (81<=x) gpList.add(index,2.8f)
            else if (78<=x) gpList.add(index,2.5f)
            else if (74<=x) gpList.add(index,2.2f)
            else if (71<=x) gpList.add(index,1.9f)
            else if (68<=x) gpList.add(index,1.6f)
            else if (64<=x) gpList.add(index,1.3f)
            else if (61<=x) gpList.add(index,1.0f)
            else if (56<=x) gpList.add(index,0.8f)
            else if (51==x) gpList.add(index,0.5f)
            else  gpList.add(index,0.0f)

            index++
        }

        return gpList
    }


    private fun hideKeyboard() {
        val view = currentView // returns the view that has focus or null
        if (view != null) {
            val manager = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }






    

}
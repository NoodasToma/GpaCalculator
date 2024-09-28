package com.example.gpacalculator

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.EditText
import android.widget.GridLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import androidx.core.widget.doOnTextChanged
import androidx.transition.Visibility
import com.example.gpacalculator.databinding.ActivityMainBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton

public enum class Course{
    CS,MANAGEMANT,MATH
}
public enum class Subject(val credits:Int, val course: Course){


    I2I(6,Course.CS),FOP(6,Course.CS),DS(9,Course.CS),I2CA(6,Course.CS),ENG(3,Course.CS,Course.MANAGEMANT);

    constructor(credits: Int, course:Course,course2: Course) : this(credits,course)
}


class Semester(val subjects: List<Subject>, val view: ConstraintLayout)



class MainActivity : AppCompatActivity() {

    lateinit var mainBinding: ActivityMainBinding


    val cs1Sem = Semester(listOf(Subject.I2I,Subject.DS,Subject.I2CA,Subject.FOP,Subject.ENG),mainBinding.cs1Semester.cs1Semester)

    var choosingCourse:Boolean = false

    var choosingSemester:Boolean = false

    var currentCourse:Course = Course.CS

    var currentSemester:Int = 0

    var currentView:ConstraintLayout = mainBinding.cs1Semester.cs1Semester

    var currentSubjects:List<Subject> = cs1Sem.subjects

    var gradeList: List<EditText> = listOf(mainBinding.score1,mainBinding.score2,mainBinding.score3,mainBinding.score4,mainBinding.score5)

    var sub_Grade_Map: MutableMap<Subject, Float> = mapOf<Subject,Float>() as MutableMap<Subject, Float>



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



        mainBinding.main.setOnClickListener{
            choosingCourse = false
            showCourses()
            mainBinding.Gpa.text = calcGpa().toString()
        }

        val regex = Regex("(1|2|3|4|5|6|7|8|9|0)*")

        gradeList.forEach { i->
            if (!regex.matches(i.text.toString())){
                throw IllegalArgumentException()
            }

            i.doOnTextChanged { text, start, before, count ->
                calcGpa()
            }

        }


        mainBinding.chooseCourse.setOnClickListener {
            choosingCourse = true
            showCourses()
            choosingCourse=!choosingCourse
        }

        mainBinding.courseNum.setOnClickListener {
            choosingSemester = true
            showSemesters()
            choosingSemester=!choosingSemester
        }

        mainBinding.CompScience.setOnClickListener {
            currentCourse = Course.CS
            mainBinding.chooseCourse.text = mainBinding.CompScience.text
            choosingCourse = false
            showCourses()
        }

        mainBinding.Managemant.setOnClickListener {
            currentCourse = Course.CS
            mainBinding.chooseCourse.text = mainBinding.Managemant.text
            choosingCourse = false
            showCourses()
        }

        mainBinding.Math.setOnClickListener {
            currentCourse = Course.CS
            mainBinding.chooseCourse.text = mainBinding.Math.text
            choosingCourse = false
            showCourses()
        }

        mainBinding.semester1.setOnClickListener {
            currentSemester=1
            mainBinding.courseNum.text = mainBinding.semester1.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester2.setOnClickListener {
            currentSemester=2
            mainBinding.courseNum.text = mainBinding.semester2.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester3.setOnClickListener {
            currentSemester=3
            mainBinding.courseNum.text = mainBinding.semester3.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester4.setOnClickListener {
            currentSemester=4
            mainBinding.courseNum.text = mainBinding.semester4.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester5.setOnClickListener {
            currentSemester=5
            mainBinding.courseNum.text = mainBinding.semester5.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester6.setOnClickListener {
            currentSemester=6
            mainBinding.courseNum.text = mainBinding.semester6.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester7.setOnClickListener {
            currentSemester=7
            mainBinding.courseNum.text = mainBinding.semester7.text
            choosingSemester = false
            showSemesters()
        }
        mainBinding.semester8.setOnClickListener {
            currentSemester=8
            mainBinding.courseNum.text = mainBinding.semester8.text
            choosingSemester = false
            showSemesters()
        }


    }


    fun showCourses(){
        if (choosingCourse){
        mainBinding.CompScience.visibility = View.VISIBLE
        mainBinding.Managemant.visibility = View.VISIBLE
        mainBinding.Math.visibility = View.VISIBLE
        }
        else{
            mainBinding.CompScience.visibility = View.INVISIBLE
            mainBinding.Managemant.visibility = View.INVISIBLE
            mainBinding.Math.visibility = View.INVISIBLE
        }
        calcGpa()
    }


    fun showSemesters(){
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
            mainBinding.semester1.visibility = View.INVISIBLE
            mainBinding.semester2.visibility = View.INVISIBLE
            mainBinding.semester3.visibility = View.INVISIBLE
            mainBinding.semester4.visibility = View.INVISIBLE
            mainBinding.semester5.visibility = View.INVISIBLE
            mainBinding.semester6.visibility = View.INVISIBLE
            mainBinding.semester7.visibility = View.INVISIBLE
            mainBinding.semester8.visibility = View.INVISIBLE
        }
        calcGpa()
    }

    fun showSemesterLaout(){
        currentView.visibility = View.INVISIBLE
        when(currentSemester){
            1 -> when(currentCourse){
                Course.CS -> {
                    cs1Sem.view.visibility= View.VISIBLE
                    currentSubjects = cs1Sem.subjects
                    currentView = mainBinding.cs1Semester.cs1Semester
                }
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            2 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            3 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            4 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            5 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            6 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            7 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
            8 -> when(currentCourse){
                Course.CS -> mainBinding.cs1Semester.cs1Semester.visibility = View.VISIBLE
                Course.MANAGEMANT -> TODO()
                Course.MATH -> TODO()
            }
                  
        }

        calcGpa()
    }

    
    fun calcGpa():Float{
        mapSubjects()

        var gpSum = 0.0f
        var creditSum = 0.0f
        for (n in  sub_Grade_Map.keys){
            if (sub_Grade_Map.get(n)!! >=0.5){
                creditSum+=n.credits
                gpSum+=n.credits*sub_Grade_Map.get(n)!!
            }
        }

        return gpSum/creditSum
    }


    fun mapSubjects(){
        var index = 0
        for (n in  currentSubjects){
            sub_Grade_Map.set(n,grade_to_GP().get(index))
            index++

        }

    }


    fun grade_to_GP():MutableList<Float>{
        var gpList:MutableList<Float> = emptyList<Float>() as MutableList
        var index = 0
        for (n in  gradeList){
            var x = n.text.toString().toInt()
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
            else if (51<=x) gpList.add(index,0.5f)
            else  gpList.add(index,0.0f)

            index++
        }

        return gpList
    }






    

}
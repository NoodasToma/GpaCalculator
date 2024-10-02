package com.example.gpacalculator

import androidx.constraintlayout.widget.ConstraintLayout

enum class Course{
    CS,MANAGEMANT,MATH
}

enum class Subject(val credits:Int){

    REG(6),MINOR(6),INTERN(12),NINECRED(9),ENG(3)

}


class Semester(val subjects: List<Subject>, val view: ConstraintLayout)
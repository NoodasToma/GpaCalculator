package com.example.gpacalculator

import androidx.constraintlayout.widget.ConstraintLayout

enum class Course{
    CS,MANAGEMANT,MATH
}

enum class Subject(val credits:Int){

    I2I(6),FOP(6),DS(9),I2CA(6),ENG(3);

}


class Semester(val subjects: List<Subject>, val view: ConstraintLayout)
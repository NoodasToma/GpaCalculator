package com.example.gpacalculator

import androidx.constraintlayout.widget.ConstraintLayout

enum class Course{
    CS,MANAGEMANT,MATH
}

enum class Subject(val credits:Int){
    //CS subjects
    I2I(6),FOP(6),DS(9),I2CA(6),ENG(3),
    OCAML(6),CALC(9),OS(6),CALAB(6),
    MINOR1(6),MINOR2(6),AIDS(6),BASES(6),LINEAR(6),
    SCRIPT(6),TC(6),DPT(6),
    NP(6),I2SW(6),ELECTIVE(6),
    I2CNDS(6),SOFTWARE(6),
    ELECTIVE2(6),ELECTIVE3(6),INTERN(12),
    THESIS(18),
    //MG subjects
    FEB(6),Economics(6),MS(6),C4B(6),ENGMAN(6),
    PRMAN(6),PROB(6),
    FA(6),I2M(6),HRM(6),SBE(6),
    OB(6),LBL(6),CA(6),POM(6),I2PDA(6),
    I2SM(6),CONS(6),ACS(6),
    RM(3),BE(3),IFM(6),
    INTENRMAN(6),MINOR3(6),
    THESISMAN(12),

    //math subjects

    CalcMath(12),LinearMath(12),I2MS(3),
    AnalysisMath(12),LADS(12),I2P(3),
    Analisys2(6),Numerical(6),I2PR(6),
    OPT(6),NA(6),
    LO(6),I2SP(6),
    CNO(6),NMDE(6),SDE(6),
    ATP(6),ATNM(6),ATPS(6),
    ME(6)


}


class Semester(val subjects: List<Subject>, val view: ConstraintLayout)
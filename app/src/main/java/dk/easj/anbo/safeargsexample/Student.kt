package dk.easj.anbo.safeargsexample

import java.io.Serializable

data class Student(val name: String, val semester: Int = 1) : Serializable {
    override fun toString(): String {
        return "$name $semester"
    }
}
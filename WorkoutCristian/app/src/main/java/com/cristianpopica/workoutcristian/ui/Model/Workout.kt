package com.cristianpopica.workoutcristian.ui.Model

import com.cristianpopica.workoutcristian.R
data class Workout(
    val gifDrawableId : Int
)  {
    companion object{
        fun getWorkOuts() : List<Workout> {
            return listOf(
                Workout(R.drawable.e1),
                Workout(R.drawable.e2),
                Workout(R.drawable.e3),
                Workout(R.drawable.e4),
                Workout(R.drawable.e5),
                Workout(R.drawable.e6),
                Workout(R.drawable.e7),
                Workout(R.drawable.e8)
            )
        }
    }
}

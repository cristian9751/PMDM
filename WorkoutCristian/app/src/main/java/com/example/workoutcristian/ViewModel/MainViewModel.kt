package com.cristianpopica.workoutcristian.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _username = MutableLiveData<String>()
    val username : LiveData<String> = _username
    private val _workoutRepetitions = MutableLiveData<Int>()
    val workoutRepetitions : LiveData<Int> = _workoutRepetitions

    fun setUserName(username : String) {
        this._username.value = username
    }

    fun addWorkoutRepetitions(plus : Int = 1)  {
        manageRepetitions {repetitions ->
            _workoutRepetitions.value = repetitions + plus
        }

    }

    fun substractRepetitions(minus : Int = 1) {
        manageRepetitions {repetitions ->
            _workoutRepetitions.value = repetitions - minus
        }
    }

    fun manageRepetitions(manage : (repetitions : Int ) -> Unit) {
        val repetitions = _workoutRepetitions.value ?: 0
        manage(repetitions)
    }


}



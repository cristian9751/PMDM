package com.cristianpopica.workoutcristian.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristianpopica.workoutcristian.Model.Workout
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class WorkoutViewModel : ViewModel() {




    private val _workoutList = MutableLiveData<List<Workout>>()
    val workoutList : LiveData<List<Workout>> = _workoutList
    val _currentWorkOut = MutableLiveData<Workout>()
    val _isDoingWorkout = MutableLiveData<Boolean>()
    val isDoingWorkout : LiveData<Boolean> = _isDoingWorkout
    val currentWorkout : LiveData<Workout> = _currentWorkOut

    init {
        viewModelScope.launch {
            _workoutList.value = Workout.getWorkouts()
        }
    }


    fun startWorkout(workout : Workout) {
        _currentWorkOut.value = workout
        _isDoingWorkout.value = true
        viewModelScope.launch {
            delay(2000)
            _isDoingWorkout.value = false
        }
    }

}
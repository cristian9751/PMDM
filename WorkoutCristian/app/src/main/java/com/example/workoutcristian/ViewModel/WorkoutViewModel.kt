package com.cristianpopica.workoutcristian.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristianpopica.workoutcristian.Model.Workout
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WorkoutViewModel : ViewModel() {




    private val _workoutList = MutableLiveData<List<Workout>>()
    val workoutList : LiveData<List<Workout>> = _workoutList
    private val _isDoingWorkout = MutableLiveData<Boolean>()
    val isDoingWorkout : LiveData<Boolean> = _isDoingWorkout
    val _currentWorkOut = MutableLiveData<Workout>()
    val currentWorkout : LiveData<Workout> = _currentWorkOut

    init {
        viewModelScope.launch {
            _workoutList.value = Workout.getWorkouts()
        }
    }
    fun startWorkout(workout: Workout) {
        _currentWorkOut.value = workout
        viewModelScope.launch {
            _isDoingWorkout.value = true
            delay(2000)
            _isDoingWorkout.value = false
        }
    }

}
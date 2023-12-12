package com.cristianpopica.workoutcristian.ui.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WorkoutScreenViewModel : ViewModel() {
    private val _currentWorkout = MutableLiveData<Workout>()
    val currentWorkout : LiveData<Workout> = _currentWorkout
    private val _isDoingWorkout = MutableLiveData<Boolean>()
    val isDoingWorkout : LiveData<Boolean> = _isDoingWorkout

    private val _workoutList = MutableLiveData<List<Workout>>()
    val workoutList : LiveData<List<Workout>> = _workoutList

    init {
        viewModelScope.launch {
            _workoutList.value = Workout.getWorkOuts()
        }
    }

    fun setCurrentWorkout(workout : Workout) {
        _currentWorkout.value = workout
    }

    fun startWorkout() {
        viewModelScope.launch {
            _isDoingWorkout.value = true
            delay(6000)
            _isDoingWorkout.value = false
        }
    }



}
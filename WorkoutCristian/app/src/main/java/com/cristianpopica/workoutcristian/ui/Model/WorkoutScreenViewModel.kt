package com.cristianpopica.workoutcristian.ui.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WorkoutScreenViewModel : ViewModel() {
    private val _currentWorkout = MutableLiveData<Workout>()
    val currentWorkout : LiveData<Workout> = _currentWorkout
    private val _isDoingWorkout = MutableLiveData<Boolean>()
    val isDoingWorkout : LiveData<Boolean> = _isDoingWorkout
}
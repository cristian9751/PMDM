package com.cristianpopica.workoutcristian.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cristianpopica.workoutcristian.Model.Workout
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class WorkoutViewModel constructor(val repetitions : Int) : ViewModel()  {




    private val _workoutList = MutableLiveData<List<Workout>>()
    val _currentWorkOut = MutableLiveData<Workout>()
    val _isDoingWorkout = MutableLiveData<Boolean>()
    val isDoingWorkout : LiveData<Boolean> = _isDoingWorkout
    val currentWorkout : LiveData<Workout> = _currentWorkOut
    val _currentRepetitions = MutableLiveData<Int>();
    val currentRepetitions : LiveData<Int> = _currentRepetitions

    init {
        viewModelScope.launch {
            _workoutList.value = Workout.getWorkouts()
        }
    }


    fun startWorkout() {
         val initialRepetitions  = this.repetitions
         viewModelScope.launch {
             _currentRepetitions.value = initialRepetitions
             do {
                 if(_currentRepetitions.value == 0 ) {
                     _currentRepetitions.value = initialRepetitions
                 }
                 if(_currentRepetitions.value == initialRepetitions) {
                     _isDoingWorkout.value = false
                     _currentWorkOut.value = _workoutList.value?.random()
                 }
                 delay(2000)
                 _currentRepetitions.value = _currentRepetitions.value?.minus(1)
                 _isDoingWorkout.value = true
             } while((_currentRepetitions.value?: 0) >= 0)
         }
    }

}
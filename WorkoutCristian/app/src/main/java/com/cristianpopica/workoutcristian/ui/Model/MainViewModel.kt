package com.cristianpopica.workoutcristian.ui.Model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _userName = MutableLiveData<String>()
    val userName : LiveData<String> = _userName
    private val _repetitionNumber = MutableLiveData<Int>()
    val repetitionsNumber : LiveData<Int> =  _repetitionNumber

    fun setUserName(username : String)  {
        _userName.value = username
    }

    fun setRepetitionNumber(repetitions : Int) {
        _repetitionNumber.value = repetitions
    }
}
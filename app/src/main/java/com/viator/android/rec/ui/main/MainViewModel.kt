package com.viator.android.rec.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _state = MutableLiveData<State>()
    val state: LiveData<State> = _state

    fun onButtonClicked() {
        val newValue = _state.value?.visible ?: false
        _state.postValue(State(visible = !newValue))
    }

    data class State(
        val visible: Boolean
    )
}

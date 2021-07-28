package com.example.horizontaldatescrolltest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class DateViewModel : ViewModel() {

	val dayIndexState = MutableLiveData<Int>(0)

	fun onSelectDay(newDayIndex: Int) {
		println("Got here....")
		dayIndexState.value = newDayIndex
	}
}

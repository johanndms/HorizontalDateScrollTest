package com.example.horizontaldatescrolltest

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle


@RequiresApi(Build.VERSION_CODES.O)
class DateViewModel : ViewModel() {

	data class DateList constructor(val dayKey: Int, val dateY9: String, val dateD11: String, val dayOfWeek: String, val theDay: String)

	val dayIndexState = MutableLiveData<Int>(0)

	val dateList = arrayListOf<DateList>()

	init {
		var currentDate = LocalDateTime.now()

		repeat(31) { index ->

			val formatterY9 = DateTimeFormatter.ofPattern("yyy-MM-dd")
			val dateY9 = currentDate.format(formatterY9)

			val formatterD11 = DateTimeFormatter.ofPattern("d MMMM yyyy")
			val dateD11 = currentDate.format(formatterD11)

			val formatterDOW = DateTimeFormatter.ofPattern("EEE")
			val dateDOW = currentDate.format(formatterDOW)

			val formatterDay = DateTimeFormatter.ofPattern("d")
			val dateDay = currentDate.format(formatterDay)

			dateList.add(DateList(dayKey = index, dateY9 = dateY9, dateD11 = dateD11, dayOfWeek = dateDOW, theDay = dateDay))

			currentDate = currentDate.plusDays(1);
		}

	}


	fun onSelectDay(newDayIndex: Int) {
		dayIndexState.value = newDayIndex
	}
}

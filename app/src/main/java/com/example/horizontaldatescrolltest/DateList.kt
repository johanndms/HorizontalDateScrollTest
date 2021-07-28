package com.example.horizontaldatescrolltest


data class DateList constructor(val dayKey: Int, val day: Int, val dow: String, val dateString: String)

val dateList = arrayListOf(
	DateList(0, 1, "M", "2021-07-01"),
	DateList(1, 2, "T", "2021-07-02"),
	DateList(2, 3, "W", "2021-07-03"),
	DateList(3, 4, "T", "2021-07-04"),
	DateList(4, 5, "F", "2021-07-05"),
	DateList(5, 6, "S", "2021-07-06"),
	DateList(6, 7, "S", "2021-07-07"),
	DateList(7, 8, "M", "2021-07-08"),
	DateList(8, 9, "T", "2021-07-09"),
	DateList(9, 10, "W", "2021-07-11"),
	DateList(10, 11, "T", "2021-07-11"),
	DateList(11, 12, "F", "2021-07-12"),
	DateList(12, 13, "S", "2021-07-13"),
	DateList(13, 14, "S", "2021-07-14"),
	DateList(14, 15, "M", "2021-07-15"),
	DateList(15, 16, "T", "2021-07-16"),
	DateList(16, 17, "W", "2021-07-17"),
	DateList(17, 18, "T", "2021-07-18"),
	DateList(18, 19, "F", "2021-07-19"),
	DateList(19, 20, "S", "2021-07-20"),
	DateList(20, 21, "S", "2021-07-21"),
	DateList(21, 22, "M", "2021-07-22"),
	DateList(22, 23, "T", "2021-07-23"),
	DateList(23, 24, "W", "2021-07-24"),
	DateList(24, 25, "T", "2021-07-25"),
	DateList(25, 26, "F", "2021-07-26"),
	DateList(26, 27, "S", "2021-07-27"),
	DateList(27, 28, "S", "2021-07-28"),
	DateList(28, 29, "M", "2021-07-29"),
	DateList(29, 30, "T", "2021-07-30")
)


package com.example.horizontaldatescrolltest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.horizontaldatescrolltest.ui.theme.HorizontalDateScrollTestTheme
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HorizontalDateScrollTestTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					MainScreen(dateList = dateList)
				}
			}
		}
	}
}

@Composable
fun MainScreen(dateVM: DateViewModel = DateViewModel(), dateList: List<DateList>) {

	val dayIndexState = dateVM.dayIndexState.observeAsState(0)

	Column {
		ShowSelectedDate(dateString = dateList[dayIndexState.value].dateString)
		ShowDateScroll(
			dateIndex = dayIndexState.value, dateVM = dateVM)
	}
}

@Composable
fun ShowSelectedDate(dateString: String) {

	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 5.dp, bottom = 10.dp),
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically
	) {
		Text(dateString)
	}
}

@Composable
fun ShowDateScroll(
	dateIndex: Int,
	dateVM: DateViewModel
) {
	LazyRow(
		modifier = Modifier
			.fillMaxWidth()
			.background(Color.LightGray),
		horizontalArrangement = Arrangement.spacedBy(25.dp)
	) {
		items(items = dateList, itemContent = { dateItem ->
			Column(
				horizontalAlignment = Alignment.CenterHorizontally
			) {
				Text(
					text = dateItem.dow,
					modifier = Modifier
						.clickable(
							role = Role.Button
						) {
							dateVM.onSelectDay(dateItem.dayKey)
						}
				)
				Text(
					text = dateItem.day.toString(),
				)
			}
		})
	}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	HorizontalDateScrollTestTheme {
		MainScreen(dateList = dateList)
	}
}
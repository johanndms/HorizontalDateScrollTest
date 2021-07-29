package com.example.horizontaldatescrolltest

import android.os.Build
import android.os.Bundle
import android.view.Gravity
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyGridScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.layout

class MainActivity : ComponentActivity() {
	@RequiresApi(Build.VERSION_CODES.O)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			HorizontalDateScrollTestTheme {
				// A surface container using the 'background' color from the theme
				Surface(color = MaterialTheme.colors.background) {
					MainScreen()
				}
			}
		}
	}
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(dateVM: DateViewModel = DateViewModel()) {

	val dayIndexState = dateVM.dayIndexState.observeAsState(0)

	Scaffold(
		topBar = {
			AppBar()
		}
	) {
		Surface(
			modifier = Modifier
				.fillMaxSize()
		) {
			Column {
				ShowSelectedDate(dateString = dateVM.dateList[dayIndexState.value].dateD11)
				ShowDateScroll(
					dateIndex = dayIndexState.value,
					dateList = dateVM.dateList
				) { newDateIndex ->
					dateVM.onSelectDay(newDayIndex = newDateIndex)
				}
			}
		}
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
		Text(
			style = MaterialTheme.typography.caption,
			text = dateString
		)
	}
}

@Composable
fun TextCircleBackground(theText: String) {
	Box(
		modifier = Modifier
			.size(28.dp)
			.clip(CircleShape)
			.background(Color(0xFF627977))
	) {
		Text(
			style = MaterialTheme.typography.caption,
			modifier = Modifier
				.padding(6.dp)
				//.background(Color.Green)
				.align(Alignment.Center),
			text = theText
		)
	}
}

@Composable
fun ShowDateScroll(
	dateIndex: Int,
	dateList: ArrayList<DateViewModel.DateList>,
	dateIndexUpdate: (newIndexState: Int) -> Unit
) {
	val backgroundShape: Shape = RoundedCornerShape(size = 40.dp)

	LazyRow(
		modifier = Modifier
			.padding(start = 10.dp, end = 10.dp, bottom = 5.dp)
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.spacedBy(25.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		items(items = dateList, itemContent = { dateItem ->
			Column(
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.requiredWidth(28.dp)
					//.background(Color.Cyan)
					.clickable(
						role = Role.Button
					) {
						dateIndexUpdate(dateItem.dayKey)
					}
			) {
				Text(
					text = dateItem.dayOfWeek,
					style = MaterialTheme.typography.caption,
					modifier = Modifier
						.padding(bottom = 10.dp)

				)
				if (dateIndex == dateItem.dayKey)
					TextCircleBackground(theText = dateItem.theDay)
				else
					Text(
						text = dateItem.theDay,
						style = MaterialTheme.typography.caption,
						modifier = Modifier
							.padding(6.dp)
							//.background(Color.Magenta)
					)
			}
		})
	}
}

@Composable
fun AppBar() {

	val result = remember { mutableStateOf("") }

	TopAppBar(
		navigationIcon = {
			// show drawer icon
			IconButton(
				onClick = {
					result.value = "Drawer icon clicked"
				}
			) {
				Icon(
					Icons.Filled.Home, contentDescription = ""
				)
			}
		},
		title = {
			Text(
				style = MaterialTheme.typography.subtitle2,
				color = Color.Black,
				text = "Schedule"
			)
		},
		elevation = AppBarDefaults.TopAppBarElevation,
		backgroundColor = Color.White
	)
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true, device = "Pixel 2 API 30", showSystemUi = true)
@Composable
fun DefaultPreview() {
	HorizontalDateScrollTestTheme {
		MainScreen()
	}
}
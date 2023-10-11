package com.andreisingeleytsev.yogaapp.ui.screens.practice_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.danceclasses.ui.utils.Fonts
import com.andreisingeleytsev.yogaapp.R
import com.andreisingeleytsev.yogaapp.ui.theme.Golden
import com.andreisingeleytsev.yogaapp.ui.theme.MainColor
import com.andreisingeleytsev.yogaapp.ui.utils.Routes

@Composable
fun PracticeScreen(navHostController: NavHostController) {
    val screenState = remember {
        mutableStateOf(0)
    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.practice_screen_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MainColor)
        )
        when (screenState.value) {
            0 -> {
                StartScreen()
            }

            1 -> {
                NextScreen(index = 0)
            }

            2 -> {
                NextScreen(index = 1)
            }

            3 -> {
                NextScreen(index = 2)
            }

            4 -> {
                NextScreen(index = 3)
            }

            5 -> {
                NextScreen(index = 4)
            }
        }
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
            Row(horizontalArrangement = Arrangement.Start) {
                IconButton(onClick = {
                    navHostController.popBackStack()
                }, modifier = Modifier.size(30.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.home_button),
                        contentDescription = null
                    )
                }
            }
            Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
                IconButton(onClick = {
                    if (screenState.value>4) {
                        navHostController.popBackStack()
                        navHostController.navigate(Routes.DETAILS_SCREEN)
                    }
                    screenState.value++
                }, modifier = Modifier.size(60.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.arrow_button),
                        contentDescription = null,
                        tint = Color.Black
                    )
                }
            }
        }
    }
}

@Composable
fun StartScreen() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth(), contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.button_bg),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(R.string.questions_about_yoga).uppercase(), style = TextStyle(
                    color = Color.White, fontSize = 32.sp, fontFamily = Fonts.font, textAlign = TextAlign.Center
                )
            )
        }
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.arrow_button),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Text(
                text = stringResource(R.string.what_is_asana_translation_and_interpretation).uppercase(),
                modifier = Modifier.fillMaxWidth().background(Color.Black.copy(alpha = 0.3F)),
                style = TextStyle(
                    color = Golden, fontSize = 25.sp, textAlign = TextAlign.Center
                )
            )
        }
        Text(
            text = stringResource(R.string.title_second),
            modifier = Modifier
                .padding(40.dp)
                .fillMaxWidth()
                .verticalScroll(
                    rememberScrollState()
                ),
            style = TextStyle(
                color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
fun NextScreen(index: Int) {
    val list = listOf(
        listOf(
            R.string.practice_1_1,
            R.string.practice_1_2
        ),
        listOf(
            R.string.practice_2_1,
            R.string.practice_2_2
        ),
        listOf(
            R.string.practice_3_1,
            R.string.practice_3_2
        ),
        listOf(
            R.string.practice_4_1,
            R.string.practice_4_2
        ),
        listOf(
            R.string.practice_5_1,
            R.string.practice_5_2
        )
    )
    val pair = when (index) {
        0 -> {
            Pair(list[0][0], list[0][1])
        }

        1 -> {
            Pair(list[1][0], list[1][1])
        }

        2 -> {
            Pair(list[2][0], list[2][1])
        }

        3 -> {
            Pair(list[3][0], list[3][1])
        }

        4 -> {
            Pair(list[4][0], list[4][1])
        }

        else -> {
            Pair(list[4][0], list[4][1])
        }
    }
    Column(Modifier.padding(40.dp).fillMaxSize()) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = R.drawable.trapez_bg),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.FillWidth
            )
            Text(
                text = stringResource(id = pair.first),
                modifier = Modifier.padding(horizontal = 20.dp).fillMaxWidth(),
                style = TextStyle(
                    color = Golden, fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = Fonts.font
                )
            )
        }
        Text(
            text = stringResource(id = pair.second), modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(
                    rememberScrollState()
                ), style = TextStyle(
                color = Color.Black, fontSize = 20.sp, textAlign = TextAlign.Center, fontFamily = Fonts.font
            )
        )
    }
}
package com.andreisingeleytsev.yogaapp.ui.screens.detail_screen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.danceclasses.ui.utils.Fonts
import com.andreisingeleytsev.yogaapp.R
import com.andreisingeleytsev.yogaapp.ui.theme.Golden
import com.andreisingeleytsev.yogaapp.ui.theme.MainColor
import com.andreisingeleytsev.yogaapp.ui.utils.AsanaItem
import com.andreisingeleytsev.yogaapp.ui.utils.Routes

@Composable
fun DetailScreen(navHostController: NavHostController) {
    val screenIndex = remember {
        mutableStateOf(0)
    }
    val currentIndex = remember {
        mutableStateOf(0)
    }
    BackHandler(onBack = {
        if (screenIndex.value != 0) screenIndex.value--
        else navHostController.popBackStack()
    })
    val asanaList = listOf(
        AsanaItem(
            imageId = R.drawable.asana_1,
            nameStringId = R.string.asana_1,
            titleStringId = R.string.asana_1_title,
            inAsanaStringId = R.string.asana_1_in,
            exitStringId = R.string.asana_1_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_2,
            nameStringId = R.string.asana_2,
            titleStringId = R.string.asana_2_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_3,
            nameStringId = R.string.asana_3,
            titleStringId = R.string.asana_3_title,
            exitStringId = R.string.asana_3_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_4,
            nameStringId = R.string.asana_4,
            titleStringId = R.string.asana_4_title,
            exitStringId = R.string.asana_4_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_5,
            nameStringId = R.string.asana_5,
            titleStringId = R.string.asana_5_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_6,
            nameStringId = R.string.asana_6,
            titleStringId = R.string.asana_6_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_7,
            nameStringId = R.string.asana_7,
            titleStringId = R.string.asana_7_title,
            exitStringId = R.string.asana_7_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_8,
            nameStringId = R.string.asana_8,
            titleStringId = R.string.asana_8_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_9,
            nameStringId = R.string.asana_9,
            titleStringId = R.string.asana_9_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_10,
            nameStringId = R.string.asana_10,
            titleStringId = R.string.asana_10_title,
            exitStringId = R.string.asana_10_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_11,
            nameStringId = R.string.asana_11,
            titleStringId = R.string.asana_11_title,
            inAsanaStringId = R.string.asana_11_in,
            exitStringId = R.string.asana_11_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_12,
            nameStringId = R.string.asana_12,
            titleStringId = R.string.asana_12_title,
            exitStringId = R.string.asana_12_exit
        ),
        AsanaItem(
            imageId = R.drawable.asana_13,
            nameStringId = R.string.asana_13,
            titleStringId = R.string.asana_13_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_14,
            nameStringId = R.string.asana_14,
            titleStringId = R.string.asana_14_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_15,
            nameStringId = R.string.asana_15,
            titleStringId = R.string.asana_15_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_16,
            nameStringId = R.string.asana_16,
            titleStringId = R.string.asana_16_title
        ),
        AsanaItem(
            imageId = R.drawable.asana_17,
            nameStringId = R.string.asana_17,
            titleStringId = R.string.asana_17_title
        )
    )
    Box(modifier = Modifier.fillMaxSize()) {
        when (screenIndex.value) {
            0 -> {
                DetailsStartScreen(screenIndex)
            }

            1 -> {
                DetailsCategoryScreen(index = currentIndex) {
                    screenIndex.value = 2
                }
            }

            2 -> {
                DetailsInstructionsScreen(asanaItem = asanaList[currentIndex.value])
            }
        }
        Column(Modifier.fillMaxWidth(), verticalArrangement = Arrangement.SpaceBetween) {
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

        }
    }

}

@Composable
fun DetailsStartScreen(screenIndex: MutableState<Int>) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.menu_screen_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MainColor)
        )
        Column(Modifier.padding(horizontal = 70.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        screenIndex.value = 1
                    }, contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.button_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.asana_instructions).uppercase(),
                    style = TextStyle(
                        color = Color.White, fontSize = 24.sp, fontFamily = Fonts.font, textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}

@Composable
fun DetailsCategoryScreen(index: MutableState<Int>, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .padding(vertical = 30.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.asana_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .padding(horizontal = 40.dp)
                .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.asana_instructions), style = TextStyle(
                    color = Color.White, fontSize = 35.sp, fontFamily = Fonts.font
                )
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 0
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 1
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 2
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_3),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 3
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_4),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 4
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_5),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 5
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_6),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 6
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_7),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 7
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_8),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 8
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_9),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 9
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_10),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 10
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_11),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 11
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_12),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 12
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_13),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 13
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_14),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 14
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_15),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 15
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_16),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    modifier = Modifier
                        .size(90.dp)
                        .clickable {
                            onClick.invoke()
                            index.value = 16
                        }, shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.asana_17),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
            }
        }
    }
}

@Composable
fun DetailsInstructionsScreen(asanaItem: AsanaItem) {
    Box(
        modifier = Modifier
            .padding(vertical = 30.dp)
            .fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Image(
            painter = painterResource(id = R.drawable.asana_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(id = R.string.asana_instructions), style = TextStyle(
                    color = Color.White, fontSize = 35.sp, fontFamily = Fonts.font
                )
            )
            Spacer(modifier = Modifier.height(10.dp))
            BoxWithConstraints(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterStart
            ) {
                Card(
                    modifier = Modifier
                        .size(maxWidth - 20.dp), shape = CircleShape
                ) {
                    Image(
                        painter = painterResource(id = asanaItem.imageId),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.FillWidth
                    )
                }
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black.copy(alpha = 0.5F)
                    ), modifier = Modifier.width(200.dp), shape = RoundedCornerShape(
                        topEnd = 20.dp, bottomEnd = 20.dp, topStart = 0.dp, bottomStart = 0.dp
                    )
                ) {
                    Text(
                        text = stringResource(id = asanaItem.nameStringId), style = TextStyle(
                            color = Golden, fontSize = 20.sp,fontFamily = Fonts.font
                        ), modifier = Modifier.padding(top = 10.dp, start = 10.dp, end = 10.dp)
                    )
                }
            }
            Text(
                text = stringResource(id = asanaItem.titleStringId).uppercase(), style = TextStyle(
                    color = Color.White, fontSize = 15.sp,fontFamily = Fonts.font
                ), modifier = Modifier.padding(horizontal = 22.dp)
            )
            if (asanaItem.inAsanaStringId != null) {
                Text(
                    text = stringResource(id = R.string.in_asana).uppercase() + stringResource(
                        id = asanaItem.titleStringId
                    ).uppercase(),
                    style = TextStyle(
                        color = Color.Black, fontSize = 15.sp,fontFamily = Fonts.font
                    ),
                    modifier = Modifier.padding(horizontal = 22.dp)
                )
            }
            if (asanaItem.exitStringId != null) {
                Text(
                    text = stringResource(id = R.string.exit).uppercase() + stringResource(id = asanaItem.titleStringId),
                    style = TextStyle(
                        color = Color.Black, fontSize = 15.sp,fontFamily = Fonts.font
                    ),
                    modifier = Modifier.padding(horizontal = 22.dp)
                )
            }
        }
    }
}
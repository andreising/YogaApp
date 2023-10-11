package com.andreisingeleytsev.yogaapp.ui.screens.start_screen

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.yogaapp.R
import com.andreisingeleytsev.yogaapp.ui.theme.MainColor
import com.andreisingeleytsev.yogaapp.ui.utils.Routes
import kotlinx.coroutines.delay

@Composable
fun StartScreen(navHostController: NavHostController){
//    val size = remember {
//        mutableStateOf(200.dp)
//    }
//    val animatedSize = animateDpAsState(targetValue = size.value, label = "", animationSpec = spring(
//        dampingRatio = Spring.DampingRatioHighBouncy,
//        stiffness = Spring.StiffnessVeryLow
//    ))
    LaunchedEffect(key1 = true) {

    }
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.start_screen_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Box(modifier = Modifier.fillMaxSize().background(MainColor))
        IconButton(
            onClick = {
                navHostController.popBackStack()
                navHostController.navigate(Routes.MENU_SCREEN)
            },
            modifier = Modifier.size(200.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.start_screen_button),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
        }
    }

}
package com.andreisingeleytsev.yogaapp.ui.screens.menu_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.andreisingeleytsev.yogaapp.ui.theme.MainColor
import com.andreisingeleytsev.yogaapp.ui.utils.Routes

@Composable
fun MenuScreen(navHostController: NavHostController) {
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
            Box(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    navHostController.navigate(Routes.PRACTICE_SCREEN)
                }, contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.button_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.yoga_practice).uppercase(), style = TextStyle(
                        color = Color.White, fontSize = 24.sp, fontFamily = Fonts.font, textAlign = TextAlign.Center
                    )
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Box(modifier = Modifier.fillMaxWidth().clickable {
                navHostController.navigate(Routes.DETAILS_SCREEN)
            }, contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.button_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.detailed_exercises).uppercase(),
                    style = TextStyle(
                        color = Color.White, fontSize = 24.sp,fontFamily = Fonts.font, textAlign = TextAlign.Center
                    )
                )
            }
            Spacer(modifier = Modifier.height(18.dp))
            Box(modifier = Modifier.fillMaxWidth().clickable {
                navHostController.navigate(Routes.SETTINGS_SCREEN)
            }, contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(id = R.drawable.button_bg),
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = stringResource(R.string.settings).uppercase(), style = TextStyle(
                        color = Color.White, fontSize = 24.sp,fontFamily = Fonts.font, textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}
package com.andreisingeleytsev.yogaapp.ui.screens.settiings_screen

import android.media.MediaPlayer
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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.andreisingeleytsev.danceclasses.ui.utils.Fonts
import com.andreisingeleytsev.yogaapp.R
import com.andreisingeleytsev.yogaapp.ui.theme.Golden
import com.andreisingeleytsev.yogaapp.ui.theme.MainColor
import com.andreisingeleytsev.yogaapp.ui.utils.Routes

@Composable
fun SettingsScreen(mediaPlayer: MediaPlayer?, navHostController: NavHostController){
    val sound = remember {
        mutableStateOf(mediaPlayer!!.isPlaying)
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
        Column(modifier = Modifier.padding(vertical = 40.dp).fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(id = R.string.sound), style = TextStyle(
                    color = Golden, fontSize = 20.sp, fontFamily = Fonts.font
                )
            )
            Switch(
                checked = sound.value, onCheckedChange = {
                    sound.value = !sound.value
                    if (sound.value) {
                        mediaPlayer?.start()
                    } else mediaPlayer?.pause()
                }, colors = SwitchDefaults.colors(
                    uncheckedTrackColor = Color.White,
                    checkedTrackColor = Color.Black,
                    uncheckedThumbColor = MainColor,
                    checkedThumbColor = MainColor
                )
            )
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
        }
    }
}
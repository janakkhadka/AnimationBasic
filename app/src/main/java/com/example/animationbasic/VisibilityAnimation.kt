package com.example.animationbasic

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VisibilityAnimation(){
    Column(modifier = Modifier
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Spacer(modifier = Modifier.height(130.dp))

        var isVisible by remember{
            mutableStateOf(true)
        }


        Button(onClick = {

            isVisible = !isVisible

        }) {
            Text(text = "Click Me")

        }

        Spacer(modifier = Modifier.height(50.dp))

        Box(modifier = Modifier
            .height(300.dp)
            .width(300.dp)
            .background(color = Color.Cyan),
        ){

            androidx.compose.animation.AnimatedVisibility(
                visible = isVisible,
                enter = slideInVertically() + fadeIn(),
                exit = slideOutVertically() + fadeOut()
            ) {
                Box(modifier = Modifier
                    .padding(45.dp)
                    .height(200.dp)
                    .width(200.dp)
                    .clip(RoundedCornerShape(150.dp))
                    .background(color = Color.Red)
                )
            }
        }



    }
}
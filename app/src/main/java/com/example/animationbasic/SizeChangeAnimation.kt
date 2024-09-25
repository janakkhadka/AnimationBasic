package com.example.animationbasic

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
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
fun SizeChangeAnimator() {

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment= Alignment.CenterHorizontally,
    ) {

        var isVisible by remember{
            mutableStateOf(true)
        }

        val size by animateDpAsState(
            targetValue = if(isVisible) 200.dp else 350.dp,
            animationSpec = tween(
                delayMillis = 100,
                durationMillis = 1400,
                easing = FastOutSlowInEasing
            )
        )
        val corner by animateDpAsState(
            targetValue = if(isVisible) 25.dp else 250.dp,
            animationSpec = tween(
                delayMillis = 100,
                durationMillis = 2000,
                easing = FastOutSlowInEasing
            )
        )

        val color by animateColorAsState(
            targetValue = if(isVisible) Color.Blue else Color.Red,
            label = "color",
            animationSpec = tween(
                durationMillis = 1400,
                delayMillis = 100,
                easing = FastOutSlowInEasing
            )
        )


        Spacer(modifier = Modifier.height(100.dp))

        Button(onClick = {
            isVisible = !isVisible

        }) {
            Text(text = "Click Me")

        }


        Spacer(modifier = Modifier.height(100.dp))

        Box(modifier = Modifier
            .size(size)
            .clip(RoundedCornerShape(corner))
            .background(color = color)
        )

    }

}
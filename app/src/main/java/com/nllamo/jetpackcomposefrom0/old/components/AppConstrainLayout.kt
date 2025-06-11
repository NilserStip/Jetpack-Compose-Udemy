package com.nllamo.jetpackcomposefrom0.old.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout

@Composable
fun AppConstraintLayout() {
    ConstraintLayout(
        modifier = Modifier.fillMaxSize()
    ) {
        val (button, space1, text) = createRefs()

        Button(
            onClick = { },
            modifier = Modifier.constrainAs(button) {
                top.linkTo(parent.top)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(space1.top)
            }
        ) {
            Text("Button",)
        }

        Spacer(modifier = Modifier.height(16.dp).constrainAs(space1) {
            top.linkTo(button.bottom)
            bottom.linkTo(text.top)
        })

        Text(
            text = "Text",
            modifier = Modifier.constrainAs(text) {
                top.linkTo(space1.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            },
            color = Color.Red
        )
    }
}

@Composable
fun AppConstraintLayoutGuide() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val box = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.1f)

        Box(modifier = Modifier
            .size(100.dp)
            .constrainAs(box) {
                top.linkTo(topGuide)
                start.linkTo(startGuide)
            }
            .background(Color.Cyan))
    }
}

@Composable
fun AppConstraintLayoutBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (box1, box2, box3) = createRefs()
        val barrier = createStartBarrier(box1, box2, margin = 20.dp)

        Box(modifier = Modifier
            .size(20.dp)
            .background(Color.Cyan)
            .constrainAs(box1) {
                start.linkTo(parent.start, margin = 12.dp)
                top.linkTo(parent.top)
            })

        Box(modifier = Modifier
            .size(120.dp)
            .background(Color.Red)
            .constrainAs(box2) {
                top.linkTo(box1.bottom)
                start.linkTo(parent.start, margin = 24.dp)
            })

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Green)
            .constrainAs(box3) {
                top.linkTo(box2.bottom)
                start.linkTo(barrier)
            })
    }
}

@Preview
@Composable
fun AppConstrainsLayoutChain() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (box1, box2, box3) = createRefs()

        createHorizontalChain(box1, box2, box3, chainStyle = ChainStyle.Spread)

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Cyan)
            .constrainAs(box1) {
                start.linkTo(parent.start, margin = 12.dp)
                top.linkTo(parent.top)
            })

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Red)
            .constrainAs(box2) {
                top.linkTo(parent.top)
                start.linkTo(box1.end, margin = 24.dp)
            })

        Box(modifier = Modifier
            .size(40.dp)
            .background(Color.Green)
            .constrainAs(box3) {
                top.linkTo(parent.top)
                start.linkTo(box2.end, margin = 24.dp)
            })
    }
}
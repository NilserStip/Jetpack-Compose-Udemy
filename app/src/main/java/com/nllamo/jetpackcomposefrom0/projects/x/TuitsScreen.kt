package com.nllamo.jetpackcomposefrom0.projects.x

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nllamo.jetpackcomposefrom0.R

@Composable
fun TuitsScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding()
            .background(Color.Gray)
    ) {
        Content()
    }
}

@Composable
private fun Content() {
    Row(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "Profile",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
        )

        Column(
            modifier = Modifier
                .padding(start = 12.dp)
        ) {
            Header()
            Spacer(modifier = Modifier.padding(2.dp))
            Body()
            Spacer(modifier = Modifier.padding(8.dp))
            Footer(
                onClickComment = {},
                onClickShare = {},
                onClickLike = {},
            )
        }
    }
}

@Composable
private fun Header() {
    Row {
        Text(
            text = stringResource(R.string.aris),
            color = Color.White,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = stringResource(R.string.aristi_devs),
            color = Color.LightGray,
        )
        Text(
            text = stringResource(R.string.time),
            color = Color.LightGray,
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(R.drawable.ic_dots),
            contentDescription = "More",
            colorFilter = ColorFilter.tint(Color.White),
        )
    }
}

@Composable
private fun Body() {
    Text(
        text = stringResource(R.string.text),
        fontSize = 11.sp,
        color = Color.White,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.padding(4.dp))
    Image(
        alignment = Alignment.Center,
        painter = painterResource(R.drawable.profile),
        contentDescription = "Image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .clip(RoundedCornerShape(16.dp)),
    )
}

@Composable
private fun Footer(
    onClickComment: () -> Unit,
    onClickShare: () -> Unit,
    onClickLike: () -> Unit,
) {

    var isComment by rememberSaveable { mutableStateOf(false) }
    var isShare by rememberSaveable { mutableStateOf(false) }
    var isLiked by rememberSaveable { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(horizontal = 24.dp)
    ) {
        Image(
            painter = painterResource(if (isComment) R.drawable.ic_chat_filled else R.drawable.ic_chat),
            contentDescription = "Like",
            colorFilter = ColorFilter.tint(Color.White),
            modifier = Modifier.clickable {
                isComment = !isComment
                onClickComment()
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(if (isShare) R.drawable.ic_rt else R.drawable.ic_share),
            contentDescription = "Comment",
            colorFilter = ColorFilter.tint(if (isShare) Color.Green else Color.White),
            modifier = Modifier.clickable {
                isShare = !isShare
                onClickShare()
            }
        )
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(if (isLiked) R.drawable.ic_like_filled else R.drawable.ic_like),
            contentDescription = "Share",
            colorFilter = ColorFilter.tint(if (isLiked) Color.Red else Color.White),
            modifier = Modifier.clickable {
                isLiked = !isLiked
                onClickLike()
            }
        )
    }
}
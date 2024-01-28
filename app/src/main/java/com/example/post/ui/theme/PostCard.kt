package com.example.post.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.post.R

@Preview(showBackground = true)
@Composable
fun PostCard() {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

        Card {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                PostHeader()
                Spacer(modifier = Modifier.padding(5.dp))
                TitleText()
                Spacer(modifier = Modifier.padding(5.dp))
                Image(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp)),
                    painter = painterResource(id = R.drawable.main_pic),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(5.dp))
                Footer()
            }
        }
    }
}


@Composable
private fun PostHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape),
            painter = painterResource(id = R.drawable.post_icon),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,

            )
        Spacer(modifier = Modifier.width(8.dp))

        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            Text(text = "запостил")
            Spacer(modifier = Modifier.width(4.dp))
            Text(text = "14:00")
        }
        Icon(
            imageVector = ImageVector.vectorResource(id = R.drawable.points),
            contentDescription = null
        )

    }
}

@Composable
private fun TitleText() {
    Text(text = stringResource(R.string.template_text))
}

@Composable
private fun Footer() {
    Row {
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconWithText(icon = R.drawable.eye, text = "966")
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconWithText(icon = R.drawable.arrow, text = "7")
            IconWithText(icon = R.drawable.comments, text = "8")
            IconWithText(icon = R.drawable.heart, text = "27")
        }
    }
}

@Composable
private fun IconWithText(icon: Int, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(painter = painterResource(id = icon), contentDescription = null)
        Spacer(modifier = Modifier.padding(4.dp))
        Text(text = text)
    }
}



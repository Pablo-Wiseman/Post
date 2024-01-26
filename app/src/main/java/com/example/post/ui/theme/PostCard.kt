package com.example.post.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
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
fun PostCard(){

    Card(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
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
        Column(
            modifier = Modifier
                .padding(8.dp)
                .weight(1f)
        ) {
            Text(
                modifier = Modifier
                    .padding(bottom = 8.dp),
                text = stringResource(R.string.template_text)
            )
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(10.dp)),
                painter = painterResource(id = R.drawable.main_pic),
                contentScale = ContentScale.Crop,
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.eye),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.padding(2.dp))
                Text(text = "916")
            }
            Row {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.arrow),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = "7")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.comments),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = "8")
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.heart),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.padding(2.dp))
                    Text(text = "23")
                }
            }

        }
    }
}
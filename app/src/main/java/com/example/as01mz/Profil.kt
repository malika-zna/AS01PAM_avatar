package com.example.as01mz

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import com.example.as01mz.ui.theme.AS01MZTheme

@Composable
fun FProfil(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onNavigateToAvatar: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier= Modifier.padding(
                top = 24.dp,
                bottom = 40.dp
            ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onBack() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIosNew,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Profile Page",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.profile),
            contentDescription = "hai",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
        )
        Text(
            text = "Malika Zahro Nadia Aulia",
        )
        Row {
            Text(
                text = "@malikazahro",
            )
            Text(
                text = " | ",
            )
            Text(
                text = "malikazahro@student.ub.ac.id",
            )
        }
        Row {
            Text(
                text = "20 yo",
            )
            Text(
                text = " | ",
            )
            Text(
                text = "Female",
            )
        }
        Text(
            text = "Bachelor of Computer Science",
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigateToAvatar() }
        ) {
            Text(text = "See Avatar")
        }
    }
}
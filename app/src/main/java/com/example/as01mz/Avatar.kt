package com.example.as01mz

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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew

@Composable
fun FAvatar(
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {

    val partList = listOf("brow", "eye", "nose", "mouth");
    val partMap = mapOf(
        "brow" to R.drawable.brow,
        "eye" to R.drawable.eye,
        "nose" to R.drawable.nose,
        "mouth" to R.drawable.mouth
    )
    val partSizeMap = mapOf(
        "brow" to 180,
        "eye" to 160,
        "nose" to 40,
        "mouth" to 60
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = Color.hsl(
                    hue = 240f,
                    saturation = 1f,
                    lightness = 0.93f,
                    alpha = 1f,
                )
            ),
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
                text = "Avatar Page",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(1f)
            )
        }

        val checkedPart = remember { mutableStateListOf("") }

        fun handleCheck(part: String) {
            if (checkedPart.contains(part)) {
                checkedPart.remove(part)
            } else {
                checkedPart.add(part)
            }
        }

        Box(
            modifier = Modifier.padding(48.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.face),
                contentDescription = ""
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 70.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                partMap.map { part ->
                    Image(
                        painter = painterResource(id = part.value),
                        contentDescription = part.key,
                        modifier = Modifier.width((partSizeMap[part.key] ?: 0).dp),
                        alpha = if (checkedPart.contains(part.key)) 1f else 0f
                    )
                }
            }
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            partList.forEach { part ->
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        checked = checkedPart.contains(part),
                        onCheckedChange = {handleCheck(part)},
                        modifier = Modifier.size(32.dp)
                    )
                    Text(
                        text = part.capitalize(Locale.current),
                        fontSize = 14.sp
                    )
                }
            }
        }
    }
}

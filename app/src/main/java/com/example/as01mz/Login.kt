package com.example.as01mz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.rememberTextFieldState
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import com.example.as01mz.ui.theme.AS01MZTheme

@Composable
fun FLogin(
    modifier: Modifier = Modifier,
    onBack: () -> Unit,
    onNavigateToProfil: () -> Unit,
    ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login User",
            modifier = Modifier.padding(
                bottom = 40.dp
            ),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        OutlinedTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Username") },
            placeholder = { Text(text = "malikazahro") },
        )
        BasicSecureTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth().border(
                width = 1.dp,
                color = Color.Black,
                shape = RectangleShape
            ),
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            var checked by remember { mutableStateOf(false) }
            Checkbox(
                checked = checked,
                onCheckedChange = {checked = !checked}
            )
            Text(
                text = "Remember Me"
            )
        }
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigateToProfil() }
        ) {
            Text(text = "Login")
        }
        Text(
            buildAnnotatedString {
                append("Belum punya akun? ")

                val loginLink = LinkAnnotation.Clickable(
                    tag = "Register",
                    linkInteractionListener = { onBack() }
                )

                withLink(loginLink) {
                    append("Daftar")
                }
            }
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun FLoginPreview() {
//    AS01MZTheme {
//        FLogin()
//    }
//}
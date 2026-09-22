package com.example.as01mz

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink

@Composable
fun FRegister(
    modifier: Modifier = Modifier,
    onNavigateToLogin: () -> Unit,
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
            .verticalScroll(scrollState),
        verticalArrangement = Arrangement.spacedBy(8.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Registrasi User",
            modifier = Modifier.padding(
                bottom = 32.dp
            ),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            OutlinedTextField(
                state = rememberTextFieldState(),
                modifier = Modifier.weight(1f),
                label = { Text(text = "First Name") },
                placeholder = { Text(text = "Malika") },
            )
            OutlinedTextField(
                state = rememberTextFieldState(),
                modifier = Modifier.weight(2f),
                label = { Text(text = "Last Name") },
                placeholder = { Text(text = "Zahro") },
            )
        }
        OutlinedTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Username") },
            placeholder = { Text(text = "malikazahro") },
        )
        OutlinedTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Email") },
            placeholder = { Text(text = "malikazahro@student.ub.ac.id") },
        )
        OutlinedTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Password") },
        )

        val genderList = listOf("Male", "Female");
        var selectedOption by remember { mutableStateOf("") }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Select Gender")
            genderList.forEach { gender ->
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedOption == gender,
                        onClick = {selectedOption = gender}
                    )
                    Text(
                        text = gender
                    )
                }
            }
        }
        OutlinedTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Age") },
            placeholder = { Text(text = "20") },
        )
        OutlinedTextField(
            state = rememberTextFieldState(),
            modifier = Modifier.fillMaxWidth(),
            label = { Text(text = "Education") },
            placeholder = { Text(text = "Bachelor") },
        )
        Button(
            modifier = Modifier.fillMaxWidth(),
            onClick = { onNavigateToLogin() }
        ) {
            Text(text = "Save")
        }
        Text(
            buildAnnotatedString {
                append("Sudah punya akun? ")

                val loginLink = LinkAnnotation.Clickable(
                    tag = "Login",
                    linkInteractionListener = { onNavigateToLogin() }
                )

                withLink(loginLink) {
                    append("Login")
                }
            }
        )
    }
}
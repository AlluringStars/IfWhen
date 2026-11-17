package com.example.ifwhen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                DayOfWeekScreen()
            }
        }
    }
}

@Composable
fun DayOfWeekScreen() {
    var input by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Введите номер дня недели (1–7):",
            fontSize = 20.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth(),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color.DarkGray,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.DarkGray,
                unfocusedTextColor = Color.Black
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                val dayNumber = input.toIntOrNull()
                result = when (dayNumber) {
                    1 -> "Понедельник"
                    2 -> "Вторник"
                    3 -> "Среда"
                    4 -> "Четверг"
                    5 -> "Пятница"
                    6 -> "Суббота"
                    7 -> "Воскресенье"
                    else -> "Ошибка: введите число от 1 до 7"
                }
            },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Magenta,
                contentColor = Color.White
            )
        ) {
            Text("Показать день недели", fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = result,
            fontSize = 22.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDayOfWeek() {
    MaterialTheme {
        DayOfWeekScreen()
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.praktik_48


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.praktik_48.ui.theme.Praktik48Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Praktik48Theme {
                MainScreen { inputText ->
                    // Переход в DisplayActivity
                    val intent = Intent(this, DisplayActivity::class.java)
                    intent.putExtra("INPUT_TEXT", inputText)
                    startActivity(intent)
                }
            }
        }
    }
}

@Composable
fun MainScreen(onSendClick: (String) -> Unit) {
    var text by remember { mutableStateOf("") }

    Scaffold(
        topBar = { TopAppBar(title = { Text("Отправка текста") }) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center
            ) {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    label = { Text("Введите текст") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = { onSendClick(text) },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Отправить")
                }
            }
        }
    )
}

package com.CounterApp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CounterCard(modifier: Modifier = Modifier) {
    var textState by remember { mutableStateOf("0") }
    var currentCount by remember { mutableStateOf(0) }

    fun commitTextToCount() {
        val parsed = textState.toIntOrNull()
        if (parsed != null) {
            currentCount = parsed
        } else {
            textState = currentCount.toString()
        }
    }

    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                OutlinedTextField(
                    value = textState,
                    onValueChange = { newText ->
                        if (newText.isEmpty() || newText.matches(Regex("-?\\d*"))) {
                            textState = newText
                        }
                    },
                    singleLine = true,
                    modifier = Modifier.weight(1f),
                    label = { Text("Start value") },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(onDone = { commitTextToCount() })
                )

                Button(
                    onClick = {
                        currentCount -= 1
                        textState = currentCount.toString()
                    },
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .size(48.dp)
                ) {
                    Text("-")
                }

                Text(
                    text = currentCount.toString(),
                    style = MaterialTheme.typography.headlineSmall,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )

                Button(
                    onClick = {
                        currentCount += 1
                        textState = currentCount.toString()
                    },
                    modifier = Modifier.size(48.dp)
                ) {
                    Text("+")
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Button(onClick = { commitTextToCount() }) {
                    Text("Set Start")
                }
            }
        }
    }
}

@Composable
fun CounterScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        CounterCard()
        CounterCard()
        CounterCard()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCounters() {
    CounterScreen()
}

package com.example.unitconverter.ui

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

@Composable
fun UnitConverterApp(
    modifier: Modifier = Modifier
) {


    var stateValue by remember {
        mutableStateOf("")
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp, start = 16.dp, end = 16.dp)
            .border(
                width = 2.dp,
                color = Color.Red
            ),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TextField(
            value = stateValue,
            onValueChange = { newText ->
                stateValue = newText
            },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(width = 2.dp, color = Color.Blue),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            UnitSelector(
                label = "From"
            )
            UnitSelector(
                label = "To"
            )
        }
    }
}

@Composable
fun UnitSelector(
    label: String
) {
    val units = listOf("Meter", "Kilometer", "Mile")
    var stateExpanded by remember {
        mutableStateOf(false)
    }
    var stateSelectedUnit by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
    ) {
        Text(text = label)
        TextButton(
            onClick = { stateExpanded = true }
        ) {
            Text(text = "Meter")
        }
        DropdownMenu(
            expanded = stateExpanded,
            onDismissRequest = { stateExpanded = false }
        ) {
            units.forEach { unit ->

                DropdownMenuItem(
                    text = { Text(text = unit) },
                    onClick = { stateSelectedUnit = unit }
                )

            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun UnitConverterAppPrev() {
    UnitConverterTheme {
        UnitConverterApp()
    }
}

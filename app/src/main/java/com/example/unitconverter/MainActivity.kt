package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.unitconverter.ui.theme.UnitConverterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                UnitConverter()
            }
        }
    }
}

@Composable
fun UnitConverter() {

    var inputValue by remember { mutableStateOf("") }
    var outputValue by remember { mutableStateOf("") }
    var inputUnit by remember { mutableStateOf("Centimeters") }
    var outputUnit by remember { mutableStateOf("Meters") }
    var iExpanded by remember { mutableStateOf(false) }
    var oExpanded by remember { mutableStateOf(false) }
    val conversionFactor = remember { mutableStateOf(0.01) }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = (Arrangement.Center),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Here all the UI elements will be stacked below each other

        Text(
            "Unit Converter",
            //modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = inputValue, onValueChange = {
            inputValue = it
            // Here goes what should happen, when the Value of our OutlinedTextField changes
        },
            label = { Text(text = "Insert Value") })

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            // Input Box
            Box {
                Button(onClick = {
                    iExpanded = true
                }) {
                    Text(inputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
                DropdownMenu(expanded = iExpanded, onDismissRequest = { iExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeters") },
                        onClick = {
                            inputUnit = "Centimeters"
                            iExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            inputUnit = "Meters"
                            iExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            inputUnit = "Feet"
                            iExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            inputUnit = "Millimeters"
                            iExpanded = false
                        })
                }
            }

            Spacer(modifier = Modifier.width(16.dp))

            // Output Box
            Box {
                Button(onClick = {
                    oExpanded = true
                }) {
                    Text(outputUnit)
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")

                }

                DropdownMenu(expanded = oExpanded, onDismissRequest = { oExpanded = false }) {
                    DropdownMenuItem(
                        text = { Text("Centimeter") },
                        onClick = {
                            outputUnit = "Centimeters"
                            oExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text("Meters") },
                        onClick = {
                            outputUnit = "Meters"
                            oExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text("Feet") },
                        onClick = {
                            outputUnit = "Feet"
                            oExpanded = false
                        })

                    DropdownMenuItem(
                        text = { Text("Millimeters") },
                        onClick = {
                            outputUnit = "Millimeters"
                            oExpanded = false
                        })
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Result:  ")

    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}
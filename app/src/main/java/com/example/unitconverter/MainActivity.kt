package com.example.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
        // Here all the UI elements will be stacked below each other
        Text("Unit Converter")
        OutlinedTextField(value = "", onValueChange = {
            // Here goes what should happen, when the Value of our OutlinedTextField changes
        })

        Row {
            Box{
                Button(onClick = { }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }

            Box{
                Button(onClick = { }) {
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown, contentDescription = "")
                }
            }
        }

        Text("Result: ")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview() {
    UnitConverter()
}
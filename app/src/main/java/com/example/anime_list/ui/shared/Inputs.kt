package com.example.anime_list.ui.shared

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun DefaultInput(
    value: String,
    onChange: (String)->Unit,
    label: String,
    modifier: Modifier= Modifier.fillMaxWidth().padding(vertical = 8.dp)) {

    OutlinedTextField(
        value = value,
        onValueChange = onChange,
        label = {
            Text(label)
        },
        modifier = modifier,
        shape = RoundedCornerShape(12.dp)
    )
}
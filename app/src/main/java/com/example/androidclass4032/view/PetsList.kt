package com.example.androidclass4032.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items // This is import
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidclass4032.viewmodel.PetsViewModel
import com.example.androidclass4032.ui.theme.AndroidClass4032Theme

@Composable
fun PetList(modifier: Modifier = Modifier) {
    val petsViewModel: PetsViewModel = viewModel()

    LazyColumn(modifier = modifier) {
        items(petsViewModel.getPets()) { pet ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Name: ${pet.name}")
                Text(text = "Species: ${pet.species}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PetListPreview() {
    AndroidClass4032Theme {
        PetList()
    }
}
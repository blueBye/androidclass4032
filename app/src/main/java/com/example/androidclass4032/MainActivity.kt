package com.example.androidclass4032

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidclass4032.ui.theme.AndroidClass4032Theme
import com.example.androidclass4032.ui.theme.Pink40
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidClass4032Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    MyApp()
                }
            }
        }
    }
}

data class UserProfile(
    val id: Int,
    val name: String,
    val age: Int,
    val preferences: List<String>
)

val UserProfileSaver: Saver<UserProfile, Any> = listSaver(
    save = { listOf(it.id, it.name, it.age, it.preferences) }, // Convert to list
    restore = {
        UserProfile(
            id = it[0] as Int,
            name = it[1] as String,
            age = it[2] as Int,
            preferences = it[3] as List<String>
        )
    }
)

@Composable
fun MyApp() {
    var userProfile by rememberSaveable(stateSaver = UserProfileSaver) {
        mutableStateOf(UserProfile(1, "Alice", 25, listOf("Reading", "Gaming")))
    }

    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
            .background(color = Pink40),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(text = "User: ${userProfile.name}, Age: ${userProfile.age}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Preferences: ${userProfile.preferences.joinToString()}", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { userProfile = userProfile.copy(age = userProfile.age + 1) }) {
            Text("Increase Age")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { userProfile = userProfile.copy(preferences = userProfile.preferences + "New Hobby") }) {
            Text("Add Hobby")
        }
    }
}

@Preview(
    showSystemUi = true
)
@Composable()
fun MyAppPreview() {
    MyApp();
}

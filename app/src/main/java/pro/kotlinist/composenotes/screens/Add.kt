package pro.kotlinist.composenotes.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pro.kotlinist.composenotes.navigation.NavRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(navController: NavHostController) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    Scaffold { it ->
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Новая заметка",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            OutlinedTextField(value = title, onValueChange = { title = it },
                label = { Text(text = "Заголовок") })

            OutlinedTextField(value = subtitle, onValueChange = { subtitle = it },
                label = { Text(text = "Заметка") })

            Button(
                onClick = {
                    navController.navigate(route = NavRoute.Main.route)
                },
                modifier = Modifier
                    .width(200.dp)
                    .padding(vertical = 8.dp)
            ) {
                Text(text = "Добавить")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewAddScreen() {
    AddScreen(navController = rememberNavController())
}
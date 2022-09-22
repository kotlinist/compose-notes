package pro.kotlinist.composenotes.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import pro.kotlinist.composenotes.navigation.NavRoute

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navController.navigate(NavRoute.Add.route)
            },
            elevation = FloatingActionButtonDefaults.elevation(8.dp),
            containerColor = Color(0xff2a6fdb)
        ) {
            Icon(
                imageVector = Icons.Filled.Add,
                contentDescription = "Add note",
                tint = Color.White
            )
        }
    }) {
        Column(modifier = Modifier.padding(it)) {
            NoteItem(title = "Note1", subtitle = "Subtitle", navController)
            NoteItem(title = "Note2", subtitle = "Subtitle", navController)
            NoteItem(title = "Note3", subtitle = "Subtitle", navController)
            NoteItem(title = "Note4", subtitle = "Subtitle", navController)
        }
    }
}

@Composable
fun NoteItem(title: String, subtitle: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = CardDefaults.cardElevation(6.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = subtitle,
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PreviewMainScreen() {
    MainScreen(navController = rememberNavController())
}
package pro.kotlinist.composenotes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import pro.kotlinist.composenotes.navigation.NotesNavHost
import pro.kotlinist.composenotes.ui.theme.ComposeNotesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNotesTheme {
                Scaffold(
                    topBar = {
                             TopAppBar(
                                 title = { Text(text = "Notes app")},
                                 colors = TopAppBarDefaults.smallTopAppBarColors(
                                     containerColor = Color(0xff2a6fdb),
                                     titleContentColor = Color.White,
                                 ),
                                 modifier = Modifier.shadow(12.dp)
                             )
                    },
                    content = {
                        Surface(
                            modifier = Modifier.fillMaxSize().padding(it),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            NotesNavHost()
                        }
                    })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeNotesTheme {
        NotesNavHost()
    }
}
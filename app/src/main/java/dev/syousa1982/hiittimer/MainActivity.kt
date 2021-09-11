package dev.syousa1982.hiittimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.syousa1982.hiittimer.ui.theme.HIITTimerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HIITTimerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "Screen1") {
        composable("Screen1") {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(20) {
                    Text(
                        text = "Item : $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
//                                navController.navigate("Screen2/$it")
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

/**
 *
 */
@Composable
fun IntervalTimer() {
    Column {
        Text(text = "30")
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Start")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HIITTimerTheme {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(20) {
                    Text(
                        text = "Item : $it",
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
//                                navController.navigate("Screen2/$it")
                            }
                            .padding(16.dp)
                    )
                }
            }
        }
    }
}
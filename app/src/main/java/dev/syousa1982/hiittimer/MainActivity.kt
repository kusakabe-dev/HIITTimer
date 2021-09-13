package dev.syousa1982.hiittimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
//                    TimerApp()
                }
            }
        }
    }
}

@Composable
fun TimerApp(countTimeViewModel: CountTimeViewModel, modifier: Modifier = Modifier) {
    val secs = countTimeViewModel.seconds.observeAsState()
    val minutes = countTimeViewModel.minutes.observeAsState()
    val hours = countTimeViewModel.hours.observeAsState()

    val resumed = countTimeViewModel.isRunning.observeAsState()
//    val progress = countTimeViewModel.progress.observeAsState(1f)
//    val timeShow = countTimeViewModel.time.observeAsState(initial = "00:00:00")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HIITTimerTheme {
        Surface(color = MaterialTheme.colors.background) {
//            TimerApp()
        }
    }
}
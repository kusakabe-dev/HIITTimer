package net.kusakabetech.hiittimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dagger.hilt.android.AndroidEntryPoint
import net.kusakabetech.hiittimer.ui.theme.HIITTimerTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HIITTimerTheme {
                TimerApp()
            }
        }
    }
}

@Composable
fun TimerApp(
    modifier: Modifier = Modifier
) {
    Surface(color = MaterialTheme.colors.background) {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding()
        ) {
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 40.dp, end = 40.dp, top = 10.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Let's start the countdown!",
                    fontSize = 24.sp,
                    style = typography.h4,
                    fontStyle = FontStyle.Italic
                )
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.Center
            ) {
                Box(Modifier.padding(40.dp), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator(
                        color = Color.Blue,
                        modifier = Modifier.size(250.dp),
                        progress = 0.75f, // Todo:ViewModelから取得
                        strokeWidth = 12.dp
                    )
                    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        ReusableHeaderText(text = "00:00:00")// Todo:ViewModelから取得
                    }
                }

            }

            Spacer(modifier = Modifier.height(12.dp))
            
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 2.dp, end = 2.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Todo:テキストを定数化
                Text(
                    text = "HOUR",
                    fontSize = 20.sp,
                    style = typography.caption
                )
                Text(
                    text = "MIN",
                    fontSize = 20.sp,
                    style = typography.caption
                )
                Text(
                    text = "SEC",
                    fontSize = 20.sp,
                    style = typography.caption
                )
            }

            Spacer(modifier = Modifier.height(6.dp))
        }
    }
//    val secs = countTimeViewModel.seconds.observeAsState()
//    val minutes = countTimeViewModel.minutes.observeAsState()
//    val hours = countTimeViewModel.hours.observeAsState()
//
//    val resumed = countTimeViewModel.isRunning.observeAsState()
//    val progress = countTimeViewModel.progress.observeAsState(1f)
//    val timeShow = countTimeViewModel.time.observeAsState(initial = "00:00:00")
}

@Composable
fun ReusableHeaderText(text: String, color: Color = Color.Black) {
    Text(text = text, fontSize= 42.sp, textAlign = TextAlign.Center,style = MaterialTheme.typography.h1, color = color)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HIITTimerTheme {
        TimerApp()
    }
}
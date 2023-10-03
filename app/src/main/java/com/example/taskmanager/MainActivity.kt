package com.example.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskManagerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TasksComplete(image = R.drawable.ic_task_completed, p1 = R.string.p1, p2 = R.string.p2)
                }
            }
        }
    }
}

@Composable
fun TasksComplete(image: Int, p1: Int, p2: Int, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            TasksCompleteImage(image = image, modifier = modifier)
            TasksCompleteText(p1 = p1, p2 = p2, modifier = modifier)
        }
    )
}

@Composable
fun TasksCompleteImage(image: Int, modifier: Modifier) {
    Image(painter = painterResource(image), contentDescription = "All Tasks Completed", modifier = modifier)
}

@Composable
fun TasksCompleteText(p1: Int, p2: Int, modifier: Modifier) {
    Text(text = stringResource(p1), fontWeight = FontWeight.Bold, modifier = modifier.padding(top = 24.dp, bottom = 8.dp))
    Text(text = stringResource(p2), fontSize = 16.sp, modifier = modifier)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TaskManagerTheme {
        TasksComplete(image = R.drawable.ic_task_completed, p1 = R.string.p1, p2 = R.string.p2)
    }
}
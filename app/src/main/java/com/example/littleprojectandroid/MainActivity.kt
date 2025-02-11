package com.example.littleprojectandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.littleprojectandroid.ui.theme.LittleProjectAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            LittleProjectAndroidTheme {
                Column(){
                    Column() {
                        TextComposable("Marco")
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Row() {
                        TextComposable()
                        TextComposable()
                        TextComposable()
                        TextComposable()
                    }
                    Column {
                        ModifierExampleTwo()
                    }
                }

                /*
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

                 */
            }
        }
    }

    private fun column(function: () -> Unit) {

    }
    @Preview(showBackground = true)
    @Composable
    fun TextComposable(name:String = "Vacio"){
        Text("Weeeeelcoooomeeee")
        Text(name)
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExampleOne(){
        Column (
            modifier = Modifier
                .padding(24.dp,10.dp,5.dp,20.dp)

        ){
            Text("My name is")
        }
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExampleTwo(){
        Column (
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .clickable(onClick={})
        ){
            Text("My name is")
        }
    }
    fun clickAction(){
        println("column clicked")
    }
    @Preview(showBackground = true)
    @Composable
    fun ModifierExampleThree(){
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .background(Color.Cyan)
                .border(width = 2.dp, Color.Black)
                .width(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            TextComposable("1")
            TextComposable("2")
            TextComposable("3")
            TextComposable("4")
        }
    }


}
/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LittleProjectAndroidTheme {
        Greeting("Android")
    }
}*/
package com.example.littleprojectandroid.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littleprojectandroid.R


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
        TextComposable("1.")
        TextComposable("2")
        TextComposable("3")
        TextComposable("4")
    }
}
@Preview(showBackground = true)
@Composable
fun ModifierExampleFour(){
    Box(
        modifier = Modifier
            .background(Color.Green)
            .padding(10.dp)
            .height(300.dp)
            .width(300.dp)
    ){
        Text("1", Modifier.align(Alignment.TopStart))
        Text("2", Modifier.align(Alignment.TopCenter))
        Text("3", Modifier.align(Alignment.TopEnd))
        Text("4", Modifier.align(Alignment.CenterStart))
        Text("5", Modifier.align(Alignment.Center))
        Text("6", Modifier.align(Alignment.CenterEnd))
        Text("7", Modifier.align(Alignment.BottomStart))
        Text("8", Modifier.align(Alignment.BottomCenter))
        Text("9", Modifier.align(Alignment.BottomEnd))

    }
}
@Preview(showBackground = true)
@Composable
fun CustomText(){
    Column() {
        Text(
            stringResource(R.string.SampleText),
            color = colorResource(R.color.teal_700),
            fontSize = 90.sp,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.Thin
        )
        val gradientColor = listOf(Color.Cyan, Color.Magenta, Color.Green)
        Text(
            stringResource(R.string.SampleText),
            style = TextStyle(Brush.linearGradient(colors = gradientColor))
        )
    }
}
@Preview(showBackground = true)
@Composable
fun picture(){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black)
            .height(300.dp)
    ){
        Image(
            modifier = Modifier
                .fillMaxWidth(),
            painter = painterResource(R.drawable.outlast),
            contentDescription = "Logo Outlast",
            contentScale = ContentScale.FillHeight
        )
    }
}


@Composable
fun ScreenTest(navController: NavHostController){
    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
    ){
        Text("ScreenTest")
        Button(
            onClick = {navController.navigate("HomeScreen")},
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to Home Screen")
        }
        Button(
            onClick = {navController.navigate("MainMenu")},
            modifier = Modifier
                .background(Color.Cyan)

        ) {
            Text("Go to MainMenu Screen")
        }
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
         ModifierExampleFour()
         CustomText()
        }
          }
    }

}
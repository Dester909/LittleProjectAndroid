package com.example.littleprojectandroid.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.littleprojectandroid.R
import com.example.littleprojectandroid.data.model.MenuModel
import com.example.littleprojectandroid.data.model.PostCardModel
import com.example.littleprojectandroid.ui.components.PoastCardComponent
import kotlinx.coroutines.launch

@Composable
fun componentsScreen(navController: NavHostController) {
    val menuOptions = arrayOf(
        MenuModel(1,"Buttons","First",Icons.Filled.AccountBox),
        MenuModel(2,"Floating Buttons","Second",Icons.Filled.AccountBox),
        MenuModel(3,"Progress","Three",Icons.Filled.AccountBox),
        MenuModel(4,"Chips","Four",Icons.Filled.AccountBox),
        MenuModel(5,"Sliders","Five",Icons.Filled.AccountBox),
        MenuModel(6,"Switches","Six",Icons.Filled.AccountBox),
        MenuModel(7,"Badges","Seven",Icons.Filled.AccountBox),
        MenuModel(8,"Snackbars","Eight",Icons.Filled.AccountBox),
        MenuModel(9,"AlertDialogs","Nine",Icons.Filled.AccountBox),
        MenuModel(10,"Bars","Ten",Icons.Filled.AccountBox)
    )
    var option by remember{ mutableStateOf("") }
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var scope = rememberCoroutineScope ()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Menu", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                LazyColumn {
                    items(menuOptions){item ->
                    NavigationDrawerItem(
                        icon = { Icon(item.icon, contentDescription = "") },
                        label = { Text(item.tittle) },
                        selected = false,
                        onClick = {
                            option = item.option
                            scope.launch {
                                drawerState.apply {
                                    close()
                                }
                            }
                        }
                    )
                        }
                }
            }
        }
    ) {
        Column {
            when (option){
                "First" -> {
                    Buttons()
                }
                "Second" ->{
                    FloatingButtons()
                }
                "Three" ->{
                    Progress()
                }
                "Four" ->{
                    Chips()
                }
                "Five" ->{
                    Sliders()
                }
                "Six" ->{
                    Switches()
                }
                "Seven" ->{
                    Badges()
                }
                "Eight" ->{
                    SnackBars()
                }
                "Nine" ->{
                    AlertDialogs()
                }
                "Ten" ->{
                    Bars()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Buttons() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Button(onClick = {}) {
            Text("Filled")
        }
        FilledTonalButton(onClick = {}) {
            Text("Tonal")
        }
        OutlinedButton(onClick = {}) {
            Text("Outline")
        }
        ElevatedButton(onClick = {}) {
            Text("Elevated")
        }
        TextButton(onClick = {}) {
            Text("Text")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FloatingButtons() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        FloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        SmallFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        LargeFloatingActionButton(onClick = {}) {
            Icon(Icons.Filled.Add, contentDescription = "Add Button")
        }
        ExtendedFloatingActionButton(
            onClick = {},
            icon = { Icon(Icons.Filled.Add, contentDescription = "Add Button") },
            text = { Text("Button") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Progress() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        CircularProgressIndicator(modifier = Modifier.size(64.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun Chips() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        AssistChip(
            onClick = {},
            label = { Text("Assist Chip") },
            leadingIcon = {
                Icon(
                    Icons.Filled.AccountBox,
                    contentDescription = "Assist Chip",
                    modifier = Modifier.size(AssistChipDefaults.IconSize)
                )
            }
        )
        var selected by remember { mutableStateOf(false) }
        FilterChip(
            selected = selected,
            onClick = { selected = !selected },
            label = { Text("Filter Chip") },
            leadingIcon = if (selected) {
                {
                    Icon(
                        Icons.Filled.AccountBox,
                        contentDescription = "Filter Chip",
                        modifier = Modifier.size(AssistChipDefaults.IconSize)
                    )
                }
            } else {
                null
            }
        )
        InputChipExample("Dismiss") {}
    }
}

@Composable
fun InputChipExample(text: String, onDismiss: () -> Unit) {
    var enabled by remember { mutableStateOf(true) }
    if (!enabled) return

    InputChip(
        label = { Text(text) },
        selected = enabled,
        onClick = {
            onDismiss()
            enabled = !enabled
        },
        avatar = {
            Icon(
                Icons.Filled.Person,
                contentDescription = "Icon Person",
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        },
        trailingIcon = {
            Icon(
                Icons.Filled.Close,
                contentDescription = "Close Icon",
                modifier = Modifier.size(InputChipDefaults.AvatarSize)
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
fun Sliders() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var sliderPosition by remember { mutableStateOf(50f) }
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            steps = 10,
            valueRange = 0f..100f
        )
        Text(
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth(),
            text = sliderPosition.toString()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Switches() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var checked by remember { mutableStateOf(true) }
        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
        var checked2 by remember { mutableStateOf(true) }
        Switch(
            checked = checked2,
            onCheckedChange = { checked2 = it },
            thumbContent = if (checked2) {
                {
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = "Switch Checked",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            } else {
                null
            }
        )
        var checked3 by remember { mutableStateOf(true) }
        Checkbox(
            checked = checked3,
            onCheckedChange = { checked3 = it }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun Badges() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var itemCount by remember{ mutableStateOf(0) }
        BadgedBox(
            badge = {
                if (itemCount > 0){
                    Badge(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    ){
                        Text(itemCount.toString())
                    }
                }
            }
        ) {
            Icon(
                imageVector = Icons.Filled.ShoppingCart,
                contentDescription = "Shopping Cart Icon"
            )
        }
        Button(
            onClick = {itemCount++}
        ) {
            Text("Add Item")
        }

    }
}
@Preview(showBackground = true)
@Composable
fun SnackBars() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        val snackState = remember {SnackbarHostState()}
        val snackScope = rememberCoroutineScope()

        SnackbarHost(hostState = snackState)

        fun launchSnackBar(){
            snackScope.launch { snackState.showSnackbar("The message has been sent") }
        }
        Button(::launchSnackBar) {
            Text("Send message")
        }

    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogs() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        var showAlertDialog by remember { mutableStateOf(false) }
        var selectedOption by remember { mutableStateOf("") }

        if (showAlertDialog) {
            AlertDialog(
                icon = { Icon(Icons.Filled.Warning, contentDescription = "Warning Icon") },
                title = { Text("Confirm Deletion") },
                text = { Text("Are you sure you want to delete the file?") },
                onDismissRequest = { showAlertDialog = false },
                confirmButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Confirmed"
                            showAlertDialog = false
                        }
                    ) {
                        Text("Yes")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = {
                            selectedOption = "Canceled"
                            showAlertDialog = false
                        }
                    ) {
                        Text("No")
                    }
                }
            )
        }
        Button(onClick = { showAlertDialog = true }) {
            Text("Delete file")
        }
        Text(selectedOption)
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Bars() {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        MediumTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Gray,
                titleContentColor = Color.Green
            ),
            title = { Text("Screen title") },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Search, contentDescription = "Search Button")
                }
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Filled.Settings, contentDescription = "Search Button")
                }
            }
        )
        val arrayPosts = arrayOf(
            PostCardModel(1,"title 1","Text 1", R.drawable.dompag),
            PostCardModel(2,"title 2","Text 2", R.drawable.proyectoextraccion),
            PostCardModel(3,"title 3","Text 3", R.drawable.fugadereinas)
        )
        //LazyColumn
        LazyRow(
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            items(arrayPosts){item ->
                PoastCardComponent(item.id,item.tittle,item.text,item.image)
            }
        }
        BottomAppBar(
            containerColor = Color.Red,
            contentColor = Color.Magenta
        ) {
            IconButton(
                //modifier = Modifier,
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Build, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
            IconButton(
                modifier = Modifier.weight(1f),
                onClick = {},
            ) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "")
            }
        }
    }
}

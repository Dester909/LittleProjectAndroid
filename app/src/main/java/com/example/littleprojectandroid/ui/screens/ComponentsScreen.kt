package com.example.littleprojectandroid.ui.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.window.core.layout.WindowHeightSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import com.example.littleprojectandroid.R
import com.example.littleprojectandroid.data.model.MenuModel
import com.example.littleprojectandroid.data.model.PostCardModel
import com.example.littleprojectandroid.ui.components.PoastCardComponent
import com.example.littleprojectandroid.ui.components.PostCardCompactContent
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.delay


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
        MenuModel(10,"Bars","Ten",Icons.Filled.AccountBox),
        MenuModel(11,"Adaptive","Eleven",Icons.Filled.AccountBox),
        MenuModel(12,"InputFields","Twelve",Icons.Filled.AccountBox),
        MenuModel(13,"Date Pickers","Thirteen",Icons.Filled.AccountBox),
        MenuModel(14,"Pull to refresh","Fourteen",Icons.Filled.AccountBox),
        MenuModel(15,"Botton sheets","Fiveteen",Icons.Filled.AccountBox),
        MenuModel(16,"SegmentedButtons","Sixteen",Icons.Filled.AccountBox)
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
                "Eleven" ->{
                    Adaptive()
                }
                "Twelve" ->{
                    InputFields()
                }
                "Thirteen" ->{
                    DatePicker()
                }
                "Fourteen" ->{
                    PullToRefresh()
                }
                "Fiveteen" ->{
                    BottomSheets()
                }
                "Sixteen" ->{
                    SegmentedButtons()
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
        LargeTopAppBar(
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.secondary
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
        /*
        val arrayPosts = arrayOf(
            PostCardModel(1,"title 1","Text 1", R.drawable.dompag),
            PostCardModel(2,"title 2","Text 2", R.drawable.proyectoextraccion),
            PostCardModel(3,"title 3","Text 3", R.drawable.fugadereinas),
            PostCardModel(4,"title 1","Text 4", R.drawable.dompag),
            PostCardModel(5,"title 2","Text 5", R.drawable.proyectoextraccion),
            PostCardModel(6,"title 3","Text 6", R.drawable.fugadereinas),
            PostCardModel(7,"title 1","Text 7", R.drawable.dompag),
            PostCardModel(8,"title 2","Text 8", R.drawable.proyectoextraccion),
            PostCardModel(9,"title 3","Text 9", R.drawable.fugadereinas),
        )
        //LazyColumn
        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        ) {
            items(arrayPosts){item ->
                PoastCardComponent(item.id,item.tittle,item.text,item.image)
            }
        }

         */
        Column (
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
        ){

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
@Composable
fun Adaptive() {
    var windowSize = currentWindowAdaptiveInfo().windowSizeClass
    var heigt = currentWindowAdaptiveInfo().windowSizeClass.windowHeightSizeClass
    var width = currentWindowAdaptiveInfo().windowSizeClass.windowWidthSizeClass
    // Compact width < 600 dp Phone Portrait
    // Medium width >= 600 dp < 840 dp Tablet Portrait
    // Expanded width >= 840 dp Tablet LandScape

    //Compact height < 480 dp Phone Landscape
    // Medium height >= 480 dp < 900 dp Tablet LandScape or Phone Portrait
    // Expanded height >=900 dp Tablet Portrait

// Lista de elementos con peso para ocupar el espacio disponible
    val arrayPost = arrayOf(
        PostCardModel(1, "Title1", "Text1", R.drawable.outlast),
        PostCardModel(2, "Title2", "Text2", R.drawable.fugadereinas),
        PostCardModel(3, "Title3", "Text3", R.drawable.madredealquiler),
        PostCardModel(1, "Title4", "Text4", R.drawable.onepiece),
        PostCardModel(2, "Title5", "Text5", R.drawable.proyectoextraccion),
        PostCardModel(3, "Title6", "Text6", R.drawable.fugadereinas),
        PostCardModel(1, "Title7", "Text7", R.drawable.nowhere),
        PostCardModel(2, "Title8", "Text8", R.drawable.outlast),
        PostCardModel(3, "Title9", "Text9", R.drawable.agentstone)
    )
    if (width == WindowWidthSizeClass.COMPACT) {
        LazyColumn(
            modifier = Modifier
                // Permite que la lista ocupe el espacio disponible
                .fillMaxSize()
        ) {
            items(arrayPost) { item ->
                PoastCardComponent(
                    item.id,
                    item.tittle,
                    item.text,
                    item.image
                )
            }
        }
    } else if (heigt == WindowHeightSizeClass.COMPACT) {
        if (width == WindowWidthSizeClass.COMPACT) {
            LazyColumn(
                modifier = Modifier
                    // Permite que la lista ocupe el espacio disponible
                    .fillMaxSize()
            ) {
                items(arrayPost) { item ->
                    PostCardCompactContent(
                        item.id,
                        item.tittle,
                        item.text,
                        item.image
                    )
                }

            }

        }
    }
}
@Composable
fun InputFields() {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text") },
            leadingIcon = { Icon(Icons.Filled.Edit, contentDescription = "Edit Icon") }
        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePicker() {
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = calendar.timeInMillis)
    val openDialog = remember { mutableStateOf(false) }

    if (openDialog.value) {
        DatePickerDialog(
            onDismissRequest = { openDialog.value = false },
            confirmButton = {
                TextButton(onClick = { openDialog.value = false }) {
                    Text("OK")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    Button(onClick = { openDialog.value = true }) {
        Text("Pick a date")
    }
}

@Composable
fun PullToRefresh() {
    var refreshing by remember { mutableStateOf(false) }
    val refreshState = rememberSwipeRefreshState(isRefreshing = refreshing)
    var message by remember { mutableStateOf("Hola") }

    LaunchedEffect(refreshing) {
        if (refreshing) {
            delay(2000) // Simula la carga de datos por 2 segundos
            message = if (message == "Hola") "¿Cómo estás?" else "Hola" // Alterna entre los mensajes
            refreshing = false
        }
    }

    SwipeRefresh(
        state = refreshState,
        onRefresh = { refreshing = true }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()), // Hace que el contenido sea desplazable
            contentAlignment = Alignment.Center
        ) {
            Text(text = message, modifier = Modifier.padding(16.dp))
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheets() {
    var showSheet by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { showSheet = true }) {
            Text("Mostrar Bottom Sheet")
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = { showSheet = false }
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Este es un Bottom Sheet", style = MaterialTheme.typography.headlineSmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Aquí puedes agregar el contenido que desees.")
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        // Cierra el bottom sheet
                        showSheet = false
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cerrar")
                }
            }
        }
    }
}

@Composable
fun SegmentedButtons() {
    var selectedOption by remember { mutableStateOf("Option 1") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    Row(modifier = Modifier.padding(16.dp)) {
        options.forEach { option ->
            Button(
                onClick = { selectedOption = option },
                colors = ButtonDefaults.buttonColors(if (selectedOption == option) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary)
            ) {
                Text(option)
            }
        }
    }
}

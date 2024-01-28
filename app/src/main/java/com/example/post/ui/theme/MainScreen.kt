package com.example.post.ui.theme

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@Preview(
    name = "Light mode",
    showSystemUi = true,
    device = Devices.NEXUS_5,
    showBackground = true
)
@Preview(
    name = "Night mode",
    group = "Devices",
    showSystemUi = true,
    device = Devices.NEXUS_5,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
fun App() {
    PostTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
        ) {
            MainScreen()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val snackbarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    val fabIsVisible = remember { mutableStateOf(true) }

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = {
            if (fabIsVisible.value) {
                FloatingActionButton(
                    onClick = {
                        scope.launch {
                            val action = snackbarHostState.showSnackbar(
                                "This is snack bar",
                                actionLabel = "Hide FAB",
                                duration = SnackbarDuration.Long
                            )

                            if (action == SnackbarResult.ActionPerformed) {
                                fabIsVisible.value = false
                            }
                        }
                    }) {
                    Icon(
                        Icons.Filled.Favorite,
                        contentDescription = null
                    )
                }
            }
        },
        bottomBar = {
            NavigationBar {

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favourite,
                    NavigationItem.Profile
                )
                items.forEach {
                    NavigationBarItem(
                        selected = false,
                        onClick = { },
                        icon = {
                            Icon(it.icon, contentDescription = null)
                        },
                        label = {
                            Text(text = stringResource(id = it.titleResId))
                        }
                    )
                }
            }
        }
    ) {

    }
}
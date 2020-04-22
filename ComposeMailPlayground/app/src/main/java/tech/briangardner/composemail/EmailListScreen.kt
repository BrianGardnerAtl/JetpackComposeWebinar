package tech.briangardner.composemail

import androidx.compose.Composable
import androidx.compose.state
import androidx.ui.material.DrawerState
import androidx.ui.material.Scaffold
import androidx.ui.material.ScaffoldState

@Composable
fun EmailListScreen(
    list: List<Email>,
    navItems: List<EmailNavigationItem>
) {
    val (drawerState, onDrawerStateChange) = state {
        ScaffoldState()
    }
    Scaffold(
        scaffoldState = drawerState,
        topAppBar = {
            EmailAppBar {
                val newState = if (drawerState.drawerState == DrawerState.Closed) {
                    ScaffoldState(drawerState = DrawerState.Opened)
                } else {
                    ScaffoldState(drawerState = DrawerState.Closed)
                }
                onDrawerStateChange(newState)
            }
        },
        drawerContent = {
            EmailNavigation(navItems = navItems)
        },
        floatingActionButton = {
            NewEmailButton(onClick = {})
        }
    ) {
        EmailList(list = list)
    }
}
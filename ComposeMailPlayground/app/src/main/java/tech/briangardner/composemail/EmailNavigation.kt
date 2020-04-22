package tech.briangardner.composemail

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.*
import androidx.ui.graphics.Color
import androidx.ui.layout.Column
import androidx.ui.layout.Row
import androidx.ui.layout.padding
import androidx.ui.layout.preferredSize
import androidx.ui.material.Divider
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun EmailNavigation(navItems: List<EmailNavigationItem>) {
    AdapterList(data = navItems) { navItem ->
        when(navItem) {
            is EmailNavigationItem.AppNameItem -> AppName()
            is EmailNavigationItem.DividerItem -> NavigationDivider()
            is EmailNavigationItem.SectionLabelItem -> SectionLabel(label = navItem.label)
            is EmailNavigationItem.NavigationDestinationItem -> {
                NavigationDestination(
                    name = navItem.name,
                    icon = navItem.icon,
                    count = navItem.count,
                    onClick = navItem.onClick
                )
            }
        }.exhaustive
    }
}

sealed class EmailNavigationItem() {
    object AppNameItem : EmailNavigationItem()
    object DividerItem : EmailNavigationItem()
    class SectionLabelItem(val label: String) : EmailNavigationItem()
    class NavigationDestinationItem(
        val name: String,
        val icon: Int?,
        val count: String?,
        val onClick: () -> Unit) : EmailNavigationItem()
}

@Composable
fun AppName() {
    Text(
        text = "FauxMail",
        style = TextStyle(
            color = Color.Black,
            fontSize = 24.sp
        ),
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun NavigationDivider() {
    Divider(
        color = Color.DarkGray,
        thickness = 2.dp,
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
    )
}

@Composable
fun SectionLabel(label: String) {
    Text(
        text = label,
        style = TextStyle(
            color = Color.DarkGray
        ),
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
    )
}

@Composable
fun NavigationDestination(name: String, icon: Int?, count: String?, onClick: () -> Unit) {
    Row(
        modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
    ) {
        Box(
            modifier = Modifier.preferredSize(36.dp)
        ) {
            icon?.let { iconId ->
                Icon(
                    asset = vectorResource(id = iconId),
                    tint = Color.Black
                )
            }
        }
        Text(
            text = name,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp
            ),
            modifier = Modifier.weight(1f)
        )
        count?.let {
            Text(
                text = count,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp
                )
            )
        }
    }
}

// sneaky hack to force the when statement to account for all of the branches
val <T> T.exhaustive: T
    get() = this
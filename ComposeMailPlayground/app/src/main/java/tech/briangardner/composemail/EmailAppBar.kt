package tech.briangardner.composemail

import androidx.compose.Composable
import androidx.ui.core.Modifier
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.TextField
import androidx.ui.foundation.TextFieldValue
import androidx.ui.layout.padding
import androidx.ui.material.IconButton
import androidx.ui.material.TopAppBar
import androidx.ui.res.vectorResource
import androidx.ui.unit.dp

@Composable
fun EmailAppBar(onNavigationClick: () -> Unit) {
    TopAppBar(
        title = {
            Text("FauxMail")
        },
        navigationIcon = {
            IconButton(onClick = onNavigationClick) {
                Icon(asset = vectorResource(id = R.drawable.ic_navigation))
            }
        },
        actions = {
            Icon(asset = vectorResource(id = R.drawable.ic_person))
        }
    )
}
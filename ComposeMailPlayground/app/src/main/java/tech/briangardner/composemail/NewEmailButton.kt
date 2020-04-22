package tech.briangardner.composemail

import androidx.compose.Composable
import androidx.ui.foundation.Icon
import androidx.ui.material.FloatingActionButton
import androidx.ui.res.vectorResource

@Composable
fun NewEmailButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(asset = vectorResource(id = R.drawable.ic_add))
    }
}
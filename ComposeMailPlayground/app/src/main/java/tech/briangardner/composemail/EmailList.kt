package tech.briangardner.composemail

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.mutableStateOf
import androidx.ui.foundation.AdapterList

@Composable
fun EmailList(list: List<Email>) {
    AdapterList(data = list) { email ->
        val state = mutableStateOf(email)
        EmailView(state)
    }
}
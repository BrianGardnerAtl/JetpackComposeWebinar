package tech.briangardner.composemail

import androidx.compose.Composable
import androidx.compose.MutableState
import androidx.compose.mutableStateOf
import androidx.ui.core.Alignment
import androidx.ui.core.ContextAmbient
import androidx.ui.core.Modifier
import androidx.ui.core.clip
import androidx.ui.foundation.Box
import androidx.ui.foundation.Icon
import androidx.ui.foundation.Text
import androidx.ui.foundation.selection.Toggleable
import androidx.ui.foundation.shape.corner.CircleShape
import androidx.ui.graphics.Color
import androidx.ui.layout.*
import androidx.ui.res.vectorResource
import androidx.ui.text.TextStyle
import androidx.ui.text.font.FontWeight
import androidx.ui.text.style.TextOverflow
import androidx.ui.tooling.preview.Preview
import androidx.ui.unit.dp
import androidx.ui.unit.sp

@Composable
fun EmailView(state: MutableState<Email>) {
    val email = state.value
    Row(
        modifier = Modifier.padding(16.dp)
    ) {
        SenderIcon()
        Column(
            modifier = Modifier.padding(start = 8.dp, top = 0.dp, end = 0.dp, bottom = 0.dp)
        ) {
            EmailHeader(sender = email.sender, time = email.time, important = email.important)
            Row(
                verticalGravity = Alignment.Bottom
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Subject(subject = email.subject)
                    Body(body = email.body)
                }
                Star(
                    starred = email.starred
                ) { newValue ->
                    val newState = email.copy(
                        starred = newValue
                    )
                    state.value = newState
                }
            }
        }
    }
}

@Composable
fun EmailHeader(sender: String, time: String, important: Boolean) {
    Row(
        verticalGravity = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        if (important) {
            Important()
        }
        Sender(sender = sender, modifier = Modifier.weight(1f))
        ReceiptTime(time = time)
    }
}

@Composable
fun Sender(sender: String, modifier: Modifier = Modifier) {
    Text(
        text = sender,
        style = TextStyle(
            color = Color.Black,
            fontSize = 20.sp
        ),
        modifier = modifier,
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun Important() {
    Icon(
        asset = vectorResource(id = R.drawable.ic_important),
        tint = Color(0xFFFDD663)
    )
}

@Composable
fun ReceiptTime(time: String) {
    Text(
        text = time,
        style = TextStyle(
            color = Color.Black,
            fontSize = 14.sp
        )
    )
}

@Composable
fun Subject(subject: String) {
    Text(
        text = subject,
        style = TextStyle(
            color = Color.Black,
            fontSize = 16.sp
        ),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun Body(body: String) {
    Text(
        text = body,
        style = TextStyle(
            color = Color.DarkGray,
            fontSize = 16.sp
        ),
        overflow = TextOverflow.Ellipsis,
        maxLines = 1
    )
}

@Composable
fun Star(starred: Boolean, onValueChange: (Boolean) -> Unit) {
    val tint = if (starred) {
        Color(0xFFFDD663)
    } else {
        Color.DarkGray
    }
    Toggleable(
        value = starred,
        onValueChange = onValueChange
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_star),
            tint =  tint
        )
    }
}

@Composable
fun SenderIcon() {
    Box(
        backgroundColor = Color.DarkGray,
        modifier = Modifier.clip(CircleShape)
            .preferredSize(36.dp)
    ) {
        Icon(
            asset = vectorResource(id = R.drawable.ic_person),
            tint = Color.LightGray,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview
@Composable
fun EmailViewPreview() {
    val email = Email(
        sender = "Test sender",
        time = "10:00 AM",
        important = true,
        subject = "Email subject",
        body = "Email body text",
        starred = false
    )
    val state = mutableStateOf(email)
    EmailView(state)
}
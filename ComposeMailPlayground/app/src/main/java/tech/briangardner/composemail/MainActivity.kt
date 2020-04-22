package tech.briangardner.composemail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.mutableStateOf
import androidx.ui.core.setContent
import tech.briangardner.composemail.EmailNavigationItem.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val list = generateEmailList()
            val navItems = generateNavigation()
            EmailListScreen(list, navItems)
        }
    }
}

fun generateEmailList(): MutableList<Email> {
    return (0..100).map {
        Email(
            sender = "Test sender $it",
            time = "10:00 AM",
            important = it % 3 == 0,
            subject = "Email subject",
            body = "Email body text Email body text Email body text Email body text Email body text ",
            starred = it % 2 == 0
        )
    }.toMutableList()
}

fun generateNavigation(): List<EmailNavigationItem> {
    return listOf<EmailNavigationItem>(
        AppNameItem,
        DividerItem,
        NavigationDestinationItem("All inboxes", icon = R.drawable.ic_all_inbox, count = null, onClick = {}),
        DividerItem,
        NavigationDestinationItem("Inbox", icon = R.drawable.ic_inbox, count = "2", onClick = {}),
        NavigationDestinationItem("Unread", icon = null, count = "4", onClick = {}),
        SectionLabelItem(label = "ALL LABELS"),
        NavigationDestinationItem("Starred", icon = R.drawable.ic_star_border, count = null, onClick = {}),
        NavigationDestinationItem("Snoozed", icon = R.drawable.ic_snoozed, count = null, onClick = {}),
        NavigationDestinationItem("Important", icon = R.drawable.ic_important, count = null, onClick = {}),
        NavigationDestinationItem("Sent", icon = R.drawable.ic_sent, count = null, onClick = {}),
        NavigationDestinationItem("Scheduled", icon = R.drawable.ic_scheduled, count = null, onClick = {}),
        NavigationDestinationItem("Outbox", icon = R.drawable.ic_outbox, count = null, onClick = {}),
        NavigationDestinationItem("Drafts", icon = R.drawable.ic_drafts, count = null, onClick = {}),
        NavigationDestinationItem("All mail", icon = R.drawable.ic_all_mail, count = null, onClick = {}),
        NavigationDestinationItem("Spam", icon = R.drawable.ic_spam, count = "99+", onClick = {}),
        NavigationDestinationItem("Trash", icon = R.drawable.ic_trash, count = "99+", onClick = {}),
        DividerItem,
        NavigationDestinationItem("Settings", icon = R.drawable.ic_settings, count = null, onClick = {}),
        NavigationDestinationItem("Help & feedback", icon = R.drawable.ic_help, count = null, onClick = {})

    )
}

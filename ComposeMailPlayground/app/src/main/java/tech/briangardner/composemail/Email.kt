package tech.briangardner.composemail

data class Email(
    val sender: String,
    val time: String,
    val important: Boolean,
    val subject: String,
    val body: String,
    val starred: Boolean
)
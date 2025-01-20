package com.example.innerpeace.DateExten

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDateTime(date: Date): String {
    val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
    return dateFormat.format(date)
}
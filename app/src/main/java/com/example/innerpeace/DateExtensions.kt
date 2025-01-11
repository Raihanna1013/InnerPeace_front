package com.example.innerpeace

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun Date.formatToDateTimeString(): String {
    val dateFormat = SimpleDateFormat("dd MMM yyyy, HH:mm", Locale.getDefault())
    return dateFormat.format(this)
}
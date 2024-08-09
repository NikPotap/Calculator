package com.example.calculator

class Action(private val t1: String, private val t2: String) {
    fun sum(): String {
        var seconds = convertToSeconds(t1) + convertToSeconds(t2)
        val hours = (seconds / 3600).toInt()
        val minutes = (seconds / 60).toInt() - hours * 60
        seconds %= 60
        return hours.toString() + " ч. " + minutes.toString() + " м. " + seconds.toString() + " с. "
    }

    fun dif(): String {
        var seconds = convertToSeconds(t1) - convertToSeconds(t2)
        var prefix = ""
        if (seconds < 0) {
            seconds *= -1
        prefix = "-"}
        val hours = (seconds / 3600).toInt()
        val minutes = (seconds / 60).toInt() - hours * 60
        seconds %= 60
        return prefix + hours.toString() + " ч. " + minutes.toString() + " м. " + seconds.toString() + " с."
    }

}
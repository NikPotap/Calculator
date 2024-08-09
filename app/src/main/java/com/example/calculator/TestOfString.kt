package com.example.calculator

fun testOfString(inp: String): Boolean {
    val listOfSymbols = listOf(
        'ч',
        'м',
        'с',
        '0',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9'
    )
    if (inp.any { c -> c !in listOfSymbols }) return false
    val indexOfH = inp.indexOf('ч')
    val indexOfM = inp.indexOf('м')
    val indexOfS = inp.indexOf('с')
    if (indexOfM > indexOfS || indexOfH > indexOfM) return false
    if (indexOfH == null || indexOfH == null || indexOfS == null) return false
    return true
}
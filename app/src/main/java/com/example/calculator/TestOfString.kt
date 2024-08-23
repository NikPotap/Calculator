package com.example.calculator

fun testOfString(inp: String): Boolean {
    val listOfSymbols = listOf(
        'm',
        's',
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
    if (inp == "") return false
    if (inp.any { c -> c !in listOfSymbols }) return false
    val indexOfM = inp.indexOf('m')
    val indexOfS = inp.indexOf('s')
    if (indexOfM > indexOfS) return false
    if (indexOfS == null || indexOfS == null) return false
    return true
}
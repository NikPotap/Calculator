package com.example.calculator

fun convertToSeconds(time: String): Int {
    var m = 0
    var s = 0
    var indexOfM = time.indexOf('m')
    var indexOfS = time.indexOf('s')
    if (indexOfM == 0) m = 0
    else m = time.substring(0, indexOfM).toInt()
    if (indexOfS == indexOfM + 1) s = 0
    else s = time.substring(indexOfM + 1, indexOfS).toInt()
    return s + m * 60
}
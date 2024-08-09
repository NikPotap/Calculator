package com.example.calculator

fun convertToSeconds(time: String): Int {
    var h = 0
    var m = 0
    var s = 0
    var indexOfH = time.indexOf('ч')
    var indexOfM = time.indexOf('м')
    var indexOfS = time.indexOf('с')
    if (indexOfH == 0) h = 0
    else h = time.substring(0, indexOfH).toInt()
    if (indexOfM == indexOfH + 1) m = 0
    else m = time.substring(indexOfH + 1, indexOfM).toInt()
    if (indexOfS == indexOfM + 1) s = 0
    else s = time.substring(indexOfM + 1, indexOfS).toInt()
    return s+m*60+h*3600
}
package xyz.xyz0z0.androidadvanced

/**
 * Author: Cheng
 * Date: 2021/6/8 9:18
 * Description: xyz.xyz0z0.androidadvanced
 */


fun String?.toTest(): Int {
    if (this.isNullOrEmpty()) {
        return 0
    }
    try {
        return this.toInt()
    } catch (e: NumberFormatException) {
        e.printStackTrace()
    }
    return 0
}
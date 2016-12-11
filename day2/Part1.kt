package com.adventofcode.day2

fun main(args: Array<String>) {
  val keypad = Keypad(arrayOf(
    charArrayOf('1', '2', '3'),
    charArrayOf('4', '5', '6'),
    charArrayOf('7', '8', '9')))

  val code = System.`in`.bufferedReader().lineSequence().map {
    it.reduce { last, next -> keypad.get(next) }
  }.joinToString("")

  print(code)
}

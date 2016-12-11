package com.adventofcode.day2

fun main(args: Array<String>) {
  val entries = arrayOf(
     charArrayOf(' ', ' ', '1', ' ', ' '),
     charArrayOf(' ', '2', '3', '4', ' '),
     charArrayOf('5', '6', '7', '8', '9'),
     charArrayOf(' ', 'A', 'B', 'C', ' '),
     charArrayOf(' ', ' ', 'D', ' ', ' '))

  val keypad = Keypad(entries, Coordinates(0, 2))

  val code = System.`in`.bufferedReader().lineSequence().map {
    it.reduce { last, next -> keypad.get(next) }
  }.joinToString("")

  print(code)
}

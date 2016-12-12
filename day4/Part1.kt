package com.adventofcode.day4

fun main(args: Array<String>) {
  val result = System.`in`.bufferedReader().lineSequence()
    .map { Room.parse(it) }
    .filter(Room::isValid)
    .sumBy(Room::id)

  println(result)
}

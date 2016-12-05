package com.adventofcode.day1

fun main(args: Array<String>) {
  val player = Player()
  readLine()?.splitToSequence(", ")?.forEach { player.move(it) }

  val (x, y) = player.coordinates
  println(Math.abs(x) + Math.abs(y))
}

package com.adventofcode.day1

import java.util.HashSet

fun main(args: Array<String>) {
  val player = Player()
  val path = HashSet<Coordinates>()

  readLine()?.splitToSequence(", ")?.find visited@ {
    val (direction, distance) = Instruction.parse(it)
    player.turn(direction)

    repeat(distance) {
      player.walk(1)
      val coordinates = player.coordinates
      if (coordinates in path) { return@visited true; }
      path.add(coordinates.clone())
    }

    return@visited false;
  }

  val (x, y) = player.coordinates
  println(Math.abs(x) + Math.abs(y))
}

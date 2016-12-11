package com.adventofcode.day2

data class Coordinates(val x: Int, val y: Int)

class Keypad(val entries: Array<CharArray>, var position: Coordinates = Coordinates(1, 1)) {
  private fun move(position: Int, translation: Int) =
    Math.min(Math.max(0, position + translation), entries.size - 1)

  public fun get(code: Char): Char {
    val coordinates = when (code) {
      'L' -> Coordinates(move(position.x, -1), position.y)
      'U' -> Coordinates(position.x, move(position.y, -1))
      'R' -> Coordinates(move(position.x, 1), position.y)
      'D' -> Coordinates(position.x, move(position.y, 1))
      else -> throw IllegalArgumentException("Movement must be one of L, U, R, or D")
    }

    if (entries[coordinates.y][coordinates.x] != ' ') {
      position = coordinates
    }

    return entries[position.y][position.x]
  }
}

package com.adventofcode.day1

enum class Bearing {
  NORTH,
  EAST,
  SOUTH,
  WEST;

  fun left() = if (ordinal == 0) WEST else values()[ordinal - 1]
  fun right() = if (ordinal == 3) NORTH else values()[ordinal + 1]
}

data class Instruction(val direction: Char, val distance: Int) {
  companion object {
    public fun parse(instruction: String): Instruction {
      val direction = instruction[0]
      val distance = instruction.substring(1).toInt()
      return Instruction(direction, distance)
    }
  }
}

data class Coordinates(var x: Int = 0, var y: Int = 0): Cloneable {
  override public fun clone() = Coordinates(x, y)
}

class Player(val coordinates: Coordinates = Coordinates(), var bearing: Bearing = Bearing.NORTH) {
  public fun move(instruction: String) = move(Instruction.parse(instruction))

  public fun move(instruction: Instruction) {
    turn(instruction.direction)
    walk(instruction.distance)
  }

  public fun turn(direction: Char) {
    when (direction) {
      'L' -> bearing = bearing.left()
      'R' -> bearing = bearing.right()
    }
  }

  public fun walk(distance: Int) {
    when (bearing) {
      Bearing.NORTH -> coordinates.y += distance
      Bearing.EAST -> coordinates.x += distance
      Bearing.SOUTH -> coordinates.y -= distance
      Bearing.WEST -> coordinates.x -= distance
    }
  }
}

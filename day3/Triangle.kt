package com.adventofcode.day3

fun isValidTriangle(triangle: Triple<Int, Int, Int>): Boolean {
  val (a, b, c) = triangle
  return a + b > c && a + c > b && b + c > a
}

open class TriangleIterator: Iterator<Triple<Int, Int, Int>> {
  companion object {
    private val sides = Regex("\\d+")
  }

  var line: CharSequence? = readLine();

  protected fun parse(): Triple<Int, Int, Int> {
    val (a, b, c) = sides.findAll(line!!).map { it.value.toInt() }.toList()
    return Triple(a, b, c)
  }

  override public fun next(): Triple<Int, Int, Int> {
    val result = parse()
    line = readLine()
    return result
  }

  override public fun hasNext() = line != null
}

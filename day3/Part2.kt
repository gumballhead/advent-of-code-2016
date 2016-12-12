package com.adventofcode.day3

class ColumnIterator: TriangleIterator() {
  val buffer = mutableListOf<Triple<Int, Int, Int>>()

  private fun fillBuffer() {
    val (a1, a2, a3) = parse()
    line = readLine()

    val (b1, b2, b3) = parse()
    line = readLine()

    val (c1, c2, c3) = parse()
    line = readLine()

    buffer.add(Triple(a1, b1, c1))
    buffer.add(Triple(a2, b2, c2))
    buffer.add(Triple(a3, b3, c3))
  }

  override public fun next(): Triple<Int, Int, Int> {
    if (buffer.size == 0) { fillBuffer(); }
    return buffer.removeAt(0)
  }

  override public fun hasNext() = buffer.size > 0 || super.hasNext()
}

fun main(args: Array<String>) = println(ColumnIterator().asSequence().count(::isValidTriangle))

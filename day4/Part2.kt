package com.adventofcode.day4

fun ShiftCipher(distance: Int): (Char) -> Char {
  val a = 'a';
  val z = 'z';
  val shift = distance % 26

  return fun(char: Char): Char {
    if (char == ' ') { return ' ' }
    val shifted = char + shift

    return if (shifted <= z) shifted else a + shifted.toInt() % z.toInt() - 1
  }
}

fun Room.decipher(): String {
  val decipher = ShiftCipher(this.id)
  return this.name.replace('-', ' ').map { decipher(it) }.joinToString("")
}

fun main(args: Array<String>) {
  System.`in`.bufferedReader().lineSequence()
    .map { Room.parse(it) }
    .filter(Room::isValid)
    .find {
      val name = it.decipher()
      println("id: ${ it.id }, name: ${ name }")
      name == "northpole object storage"
    }
}

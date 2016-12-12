package com.adventofcode.day4

class CharCount(val char: Char, var count: Int): Comparable<CharCount> {
  companion object {
    public fun get(chars: String): Set<CharCount> {
      val sorted = chars.toCharArray().sorted()
      val result = hashSetOf<CharCount>()
      var last: CharCount? = null

      for (char in sorted) {
        if (last == null || char != last.char) {
          last = CharCount(char, 0)
          result.add(last)
        }

        last.count++
      }

      if (last != null) { result.add(last) }
      return result
    }
  }

  override fun compareTo(other: CharCount): Int {
    val compareCount = other.count.compareTo(count)
    return if (compareCount == 0) char.compareTo(other.char) else compareCount
  }

  override fun equals(other: Any?) = other is CharCount && other.char == char
  override fun hashCode() = char.hashCode()
  override fun toString() = "$char: $count"
}

class Room(val name: String, val id: Int, val check: String) {
  companion object {
    private val pattern = Regex("([a-z\\-]+)-(\\d+)\\[([a-z]+)\\]")

    public fun parse(line: CharSequence): Room {
      val matches = pattern.matchEntire(line)!!
      val (name, id, check) = matches.destructured
      return Room(name, id.toInt(), check)
    }
  }

  public fun isValid(): Boolean {
    val chars = name.split('-').joinToString("")
    return CharCount.get(chars).sorted().take(5).map(CharCount::char).joinToString("") == check
  }
}

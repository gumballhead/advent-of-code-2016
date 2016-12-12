val counts = Array<MutableMap<Char, Int>>(8, { mutableMapOf<Char, Int>() })

System.`in`.bufferedReader().lineSequence().forEach {
  it.forEachIndexed { i, it ->
    val map = counts[i]
    val count = map.get(it) ?: 0
    map.put(it, count + 1)
  }
}

println(counts.map { it.asSequence().minBy { it.value }?.key }.joinToString(""))

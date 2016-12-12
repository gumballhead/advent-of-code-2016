fun main(args: Array<String>) {
  val secret = args[0]
  val prefix = "00000"
  val start = System.currentTimeMillis()

  val hashIterator = HashIterator(secret)
  val result = CharArray(8)

  repeat(8) {
    var i: Int = 0

    val hash = hashIterator.asSequence().find {
      i = it[5] - '0'
      it.startsWith(prefix) && 0 <= i && i < 8 && result[i].toInt() == 0
    }!!

    result[i] = hash[6]
  }

  println("Found answer ${ result.joinToString("").toLowerCase() } in ${ (System.currentTimeMillis() - start) / 1000 } seconds")
}

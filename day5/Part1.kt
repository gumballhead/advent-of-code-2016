fun main(args: Array<String>) {
  val secret = args[0]
  val prefix = "00000"
  val start = System.currentTimeMillis()

  val hashIterator = HashIterator(secret)

  val result = CharArray(8).map {
    val hash = hashIterator.asSequence().find { it.startsWith(prefix) }!!
    hash[5]
  }

  println("Found answer ${ result.joinToString("").toLowerCase() } in ${ (System.currentTimeMillis() - start) / 1000 } seconds")
}

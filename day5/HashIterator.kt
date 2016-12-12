import java.security.MessageDigest
import javax.xml.bind.DatatypeConverter

class HashIterator (
  private val secret: String,
  private val digest: MessageDigest = MessageDigest.getInstance("MD5"))

: Iterator<String> {

  private var i = 0

  override fun next(): String {
    return DatatypeConverter.printHexBinary(digest.digest((secret + i++).toByteArray()))
  }

  override fun hasNext(): Boolean = true
}

object Solution {
  def sortString(s: String): String = {
    val alpabet = new Array[Int](26)
    var count = s.length
    for (c <- s.toCharArray) {
      alpabet(c - 'a') += 1
    }
    val sb = new StringBuilder
    while ( {count > 0 }) {
      for (i <- 0 until 26) {
        if (alpabet(i) > 0) {
          sb.append((i + 'a').toChar)
          alpabet(i) -= 1
          count -= 1
        }
      }
      for (i <- 25 to 0 by -1) {
        if (alpabet(i) > 0) {
          sb.append((i + 'a').toChar)
          alpabet(i) -= 1
          count -= 1
        }
      }
    }
    sb.toString
  }
}
object Solution {
  def sortString(s: String): String = {
    // array for alphabet with capacity 26
    val alpabet = new Array[Int](26)
    var count = s.length

    for (c <- s.toCharArray) {
      // задаем номер
      alpabet(c - 'a') += 1
    }
    // Создаем String Builder, так как нужен String типа mutable для изменения (append)
    val sb = new StringBuilder
    // цикл действителен до s.length
    while ( {count > 0 }) {
      // цикл с a до z
      for (i <- 0 until 26) {
        // если в массиве есть значение, то добавляем 'a' к i значению, затем уменьшаем его в массиве и уменьшаем counter
        if (alpabet(i) > 0) {
          sb.append((i + 'a').toChar)
          alpabet(i) -= 1
          count -= 1
        }
      }
      // цикл с z до a
      for (i <- 25 to 0 by -1) {
        // если в массиве есть значение, то добавляем 'a' к i значению, затем уменьшаем его в массиве и уменьшаем counter
        if (alpabet(i) > 0) {
          sb.append((i + 'a').toChar)
          alpabet(i) -= 1
          count -= 1
        }
      }
    }
    // возвращаем string builder to string
    sb.toString
  }
}
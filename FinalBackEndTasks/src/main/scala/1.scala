object Solution {
  def isAnagram(s: String, t: String): Boolean = {
    // сортирует каждый String по алфавитному порядку и проверяет при помощи внутреннего метода equals
    // (если совпадают, то true else false)
    s.sorted.equals(t.sorted)
  }
}
object Solution {
  def intersection(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
    // передаем отсортированный массив в переменную a
    var a = Array[Int]()
    // запускаем 2 цикла по 2-м массивам
    for (i <- 0 until nums1.size) {
      for (j <- 0 until nums2.size) {
        // если элементы совпадают, то добавляем в отсортированный список
        if (nums1(i) == nums2(j)) {
          a = a :+ nums2(j)
        }
      }
    }
    // убираем повторяющиеся эл-ты
    a.distinct
  }
}
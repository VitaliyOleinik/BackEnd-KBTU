object Solution {
  def largestPerimeter(A: Array[Int]): Int = {
    // передаем отсортированный массив в переменную sortedArray
    val sortedArray = A.sorted
    // запускаем цикл и передаем эл-ты из sortedArray в i, от длины - 1 массива до 2
    for (i <- (2 to sortedArray.length - 1).reverse) {
      // если 2 предыдущих эл-та в сумме больше нынешнего sortedArray(i),
      // то передаем всю сумму элементов ((i-1)+(i-2)+i))
      if (sortedArray(i - 1) + sortedArray(i - 2) > sortedArray(i))
        return sortedArray(i - 2) + sortedArray(i - 1) + sortedArray(i)
    }
    // иначе 0
    0
  }
}
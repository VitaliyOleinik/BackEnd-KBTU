object Solution {
  def largestPerimeter(A: Array[Int]): Int = {
    val sortedArray = A.sorted
    for (i <- (2 to sortedArray.length - 1).reverse) {
      if (sortedArray(i - 1) + sortedArray(i - 2) > sortedArray(i))
        return sortedArray(i - 2) + sortedArray(i - 1) + sortedArray(i)
    }
    0
  }
}
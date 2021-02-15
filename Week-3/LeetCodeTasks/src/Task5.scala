object Solution {
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    var result = Array[Int]()

    for (i <- 0 until nums.length by 2) {
      result ++= Array.fill(nums(i))(nums(i+1))
    }
    result
  }
}

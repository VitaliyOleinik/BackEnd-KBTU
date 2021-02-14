object Solution3extends{
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    nums.map(
      num => nums.count(i => num > i)
    )
  }
  val nums = Array[Int](8,1,2,2,3)
  print(smallerNumbersThanCurrent(nums).mkString("Array(", ", ", ")"))
}

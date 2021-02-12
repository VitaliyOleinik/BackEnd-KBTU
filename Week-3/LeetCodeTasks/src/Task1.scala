
  object Solution extends App {
    def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
      val maxCandy = candies.max
      candies.map { candy => candy + extraCandies >= maxCandy }
    }


      val candies = Array[Int](4, 2, 1, 1, 2)
      print(Solution.kidsWithCandies(candies, 1).mkString("Array(", ", ", ")"))

  }

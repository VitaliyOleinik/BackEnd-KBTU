object Solution {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    var answer = true
    if(arr.length != 2){
      var a = arr.sortWith(_ < _)
      var diff = a(1) - a(0)
      for (i <- 1 to a.length-1){
        if((a(i) - a(i-1)) != diff){
          answer = false
        }
      }
      answer

    }
    else{
      answer
    }
  }
}
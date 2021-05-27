object Solution {
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    var array = arr.foldLeft("")((b,a) => b.concat(a.toString).concat(","))
    pieces.foldLeft(true)((containsOrNot ,p) => containsOrNot && array.contains(p.foldLeft("")
    ((b,a)=> b.concat(a.toString).concat(","))))
  }
}
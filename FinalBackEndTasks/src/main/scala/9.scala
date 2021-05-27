object Solution {
  def canFormArray(arr: Array[Int], pieces: Array[Array[Int]]): Boolean = {
    // проверка arr и array на совместимость и происходит конкатенация чисел массивов, если содержащие эл-ты массива
    // совпадают с эл-ми второго массива, то output = true, else false
    var array = arr.foldLeft("")((b,a) => b.concat(a.toString).concat(","))
    pieces.foldLeft(true)((containsOrNot ,p) => containsOrNot && array.contains(p.foldLeft("")
    ((b,a)=> b.concat(a.toString).concat(","))))
  }
}
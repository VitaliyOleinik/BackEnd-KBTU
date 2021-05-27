object Solution {
  def canMakeArithmeticProgression(arr: Array[Int]): Boolean = {
    // конечный ответ со значение true
    var answer = true
    // если длина не равна 2, то есть в массиве менее или более 3 эл-в
    if(arr.length != 2){
      // сортировка по убыванию
      var a = arr.sortWith(_ < _)
      // нахождение разницы между 1 и 2 эл-м
      var diff = a(1) - a(0)
      // цикл с 1 до длины - 1
      for (i <- 1 to a.length-1){
        // проверка последующих эл-тов массива на разницу между 1 и 2 эл-м
        if((a(i) - a(i-1)) != diff){
          // если не равна разнице => false
          answer = false
        }
      }
      // если равна, то true
      answer
    }
      // true
    else{
      answer
    }
  }
}
object Task2 extends App{
  def average(salary: Array[Int]): Double = {

    val salary1 = salary.sorted.slice(1, salary.length-1)
    salary1.sum / salary1.length
  }

  val test1 = Array(4000,3000,1000,2000)
  val test2 = Array(6000,5000,4000,3000,2000,1000)
  val test3 = Array(100, 200, 300, 400)
  println(average(test3))
}

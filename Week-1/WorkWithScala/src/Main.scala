
import scala.util.control.Breaks.break

object HelloWorld extends App {
  println("Hello, world")
}

object Hello extends App{
  def typesEx1()= {
//    val(scala) == final(java)
//    val x = 1   //immutable
//    var y = 0   //mutable
//    without declaring their type:
//    val x = 1   // type Int
//    val s = "a string"  // type String
//    val p = new Person("Regina") // type Person
//    explicitly declare:
//    val x: Int = 1
//    val s: String = "a string"
//    val p: Person = new Person("Regina")
    val x = 1
    //x: Int = 1
    val y = x + 1
    //y: Int = 2
    print(x, y)
  }
  def controlStructuresEx2(s:String, a:Int, b:Int)={
    if (s == "ex1") {
      typesEx1()
    } else if (s == "ex2") {
      val x = if (a < b) a else b
      print(x)
    } else if (s == "ex3") {
      print("Exercise 3")
    } else {
      print("Other exercise")
    }
  }
  //controlStructuresEx2("ex2", 5, 6)
  def matchExpressionsEx3(i:Int, bool:Boolean): Unit ={
    val result = i match {
      case 1 => "one"
      case 2 => "two"
      case _ => "not 1 or 2"
    }
    println(result)
    val booleanAsString = bool match {
      case true => "true"
      case false => "false"
    }
    print(booleanAsString)
  }
  //matchExpressionsEx3(15678, true)
  def getClassAsString(x: Any):String = x match {
    case s: String => s + " is a String"
    case i: Int => " Int"
    case f: Float => " Float"
    case l: List[_] => "List"
    //case p: Person => "Person"
    case _ => "Unknown"
  }
  //print(getClassAsString("das"))
  def tryCatchEx4(name:String):Unit={
    try {
      //writeToFile(text)
      val x = if(name.equals("Vit")) "you are not Vit" else name
      print(x)
    } catch {
//      case fnfe: FileNotFoundException => println(fnfe)
//      case ioe: IOException => println(ioe)
      case writeName: Exception => "write your name!"
    }
  }
  //tryCatchEx4("Vit")
  def loopsExpressionEx5(): Unit ={
    for (arg <- args) println(arg)

    // "x to y" syntax
    for (i <- 0 to 5) println(i)

    // "x to y by" syntax
    for (i <- 0 to 10 by 2) println(i)
    // yield for create an expressions (for)
    val x = for (i <- 1 to 5) yield i * 2
    print(x)
  }
  //loopsExpressionEx5()
  def ex6(): Unit ={
    val fruits = List("apple", "banana", "lime", "orange")
    // check for digits
    val fruitLengths = for {
      f <- fruits
      if f.length > 4
    } yield f.length
    print(fruitLengths)
  }
  //ex6()
  def ex7(n:Int): Unit ={
    // while loop
    var m = n // ask about it
    while(m != 0) {
      m -= 1
      print(m + "  ")
    }

    // do-while
    do {
      typesEx1()
    }
    while(m != 0){ // error ';' expected but '{' found. while(m != 0){
      m -= 1
      print(m)
    }
  }
  ex7(5)

}


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
    var y = 0
    do {
      y += 1
      print(y)
    }
    while(y < 10)
  }
  //ex7(5)
  def createClassEx8(): Unit ={
    val p = new Person("Julia", "Kern", 20)
    println(p.firstName)
    p.lastName = "Manes"
    p.printFullName()
  }
  //createClassEx8()

  // with return type of method
  def sum(a: Int, b: Int): Int = a + b
  def concatenate(s1: String, s2: String): String = s1 + s2
//  println(sum(56, 4))
//  print(concatenate("ab", "ba"))

// without return type of method
  def sum1(a: Int, b: Int) = a + b
  def concatenate1(s1: String, s2: String) = s1 + s2
//  println(sum1(4, 56))
//  print(concatenate1("ba", "ab"))

  def traitsEx9(): Unit ={
    var dog = new Dog("Mops")
    var cat = new Cat("KOT")
    println(cat.speak())
    cat.startRunning()
    cat.stopRunning()
  }
  //traitsEx9()
  def collectionsClasses(): Unit ={
    val nums = List.range(0, 10)
    val nums1 = (1 to 10 by 2).toList
    val letters = ('a' to 'z').toList
    val letters1 = ('a' to 'f' by 2).toList
    println(nums)
    println(nums1)
    println(letters)
    println(letters1)

    val nums2 = (1 to 10).toList
    val names = List("joel", "ed", "chris", "maurice")
    //println(nums2)
    nums2.filter(_ < 4).foreach(println)

    //println(names)
    names.foreach(println)

    val doubles = nums2.map(_ * 2)
    println(doubles)

    val capNames = names.map(_.capitalize) // all first character in Upper Case
    println(capNames)

    val lessThanFive = nums2.map(_ < 5) // check for digit is less than 5
    println(lessThanFive)

    println(nums2.foldLeft(0)(_ + _)) // return summarize of all digits in List
    println(nums.foldLeft(1)(_ * _)) // return multiple of all digits in List
  }
  //collectionsClasses()

  def tuples(): Unit ={
    class Person(var name: String)
    val t = (11, "Eleven", new Person("Vit"))
    println(t._1)
    println(t._2)
    println(t._3.name)
    val (num, string, person) = (11, "Eleven", new Person("Eleven"))
  }
  tuples()



}

class Person(var firstName: String, var lastName: String, var age: Int) {
  def printFullName() = println(s"Firstname: $firstName. Lastname: $lastName." + s" Age: $age")
}

//class Pizza (
//              var crustSize: CrustSize, // new object of CrustSize
//              var crustType: CrustType, // new object of CrustType
//              val toppings: ArrayBuffer[Topping] // ArrayBuffer like java(ArrayList)
//            ) {
//  def addTopping(t: Topping): Unit = toppings += t // add new topping
//  def removeTopping(t: Topping): Unit = toppings -= t // remove topping
//  def removeAllToppings(): Unit = toppings.clear() // clear ArrayBuffer with toppings
//}

trait Speaker {
  def speak(): String  // has no body, so it’s abstract
}

trait TailWagger {
  def startTail(): Unit = println("tail is wagging")
  def stopTail(): Unit = println("tail is stopped")
}

trait Runner {
  def startRunning(): Unit = println("I’m running")
  def stopRunning(): Unit = println("Stopped running")
}

class Cat(name: String) extends Speaker with TailWagger with Runner {
  def speak(): String = "Meow"
  override def startRunning(): Unit = println("Yeah ... I don’t run")
  override def stopRunning(): Unit = println("No need to stop")
}

class Dog(name: String) extends Speaker with TailWagger with Runner {
  def speak(): String = "Woof!"
  println(speak())
  startTail()
  startRunning()
  stopRunning()
  stopTail()
}

import scala.io.StdIn.{readInt, readLine}

object Main extends App{
  var prevExpression = 0
  var isFirstOperation = true
  var isRun = true
  var sum = 0
  var input1 = 0
  try {
    input1 = readInt()
  }catch {
    case _: NumberFormatException =>
      println("that's not a number, try again")
      isRun = false
  }
  var input2 = 0
  val cal = new Calculate()
  while(isRun){
    val sign = readLine()
    sign match {
      case "+" => try{
        input2 = readInt()
        if(isFirstOperation){
          sum = cal.plus(input1, input2)
          isFirstOperation = false
        }else{
          sum = cal.plus(sum, input2)
        }
      }catch {
        case _: NumberFormatException =>
          println("that's not a number, try again")
          isRun = false
      }
      case "-" => try{
        input2 = readInt()
        if(isFirstOperation){
          sum = cal.minus(input1, input2)
          isFirstOperation = false
        }else{
          sum = cal.minus(sum, input2)
        }
      }catch {
        case _: NumberFormatException =>
          println("that's not a number, try again")
          isRun = false
      }
      case "*" => try{
        input2 = readInt()
        if(isFirstOperation) {
          sum += cal.multiple(input1, input2)
          isFirstOperation = false
        }else{
          sum = cal.multiple(sum, input2)
        }
      }catch{
        case _: NumberFormatException =>
          println("that's not a number, try again")
          isRun = false
      }
      case "/" => try{
        input2 = readInt()
        if(isFirstOperation) {
          sum += cal.divisible(input1, input2)
          isFirstOperation = false
        }else{
          sum = cal.divisible(sum, input2)
        }
      }catch {
        case _: NumberFormatException =>
          println("that's not a number, try again")
          isRun = false
      }
      case "!" => try{
        sum = cal.factorial(sum)
      }catch {
        case _: NumberFormatException =>
          println("NumberFormatException, try again")
          isRun = false
      }
      case "=" => println(sum)
        isRun = false
    }
  }

}

class Calculate {
  def plus(input1: Int, input2: Int): Int = input1 + input2
  def minus(input1: Int, input2: Int): Int = input1 - input2
  def multiple(input1: Int, input2: Int): Int = input1 * input2
  def divisible(input1: Int, input2: Int): Int = input1 / input2
  def factorial(input2: Int): Int ={
    if(input2 == 0){
      1
    }else{
      input2 * factorial(input2 - 1)
    }
  }
}

object Solution {
  def getDecimalValue(head: ListNode): Int = {
    var x = 0
    var i = head
    while(i.next != null){
      x += 1
      i = i.next
    }
    if(head.next == null){
      head.x * scala.math.pow(2, 0).toInt
    }else{
      head.x * scala.math.pow(2, x).toInt + getDecimalValue(head.next)
    }
  }
}

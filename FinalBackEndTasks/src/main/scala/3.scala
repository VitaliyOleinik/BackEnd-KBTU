class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}


object Solution {
  def maxDepth(root: Node): Int = {
    // проверка на not null
    if (root != null){
      var maxi = 0 // максимум
      // пробегаюсь по значениям list
      for (n <- root.children) {
        // проверяя на максимум
        maxi = Math.max(maxi, maxDepth(n))
      }
      // каждый раз инкрементирую
      maxi + 1
    } else {
      return 0
    }
  }
}
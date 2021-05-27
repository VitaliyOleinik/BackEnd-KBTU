class Node(var _value: Int) {
  var value: Int = _value
  var children: List[Node] = List()
}


object Solution {
  def maxDepth(root: Node): Int = {
    if (root != null){
      var maxi = 0
      for (n <- root.children) {
        maxi = Math.max(maxi, maxDepth(n))
      }
      maxi + 1
    } else {
      return 0
    }
  }
}
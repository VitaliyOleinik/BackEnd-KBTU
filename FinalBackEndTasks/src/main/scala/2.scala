class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


object Solution {
  def increasingBST(root: TreeNode): TreeNode = {
    // создаю вектор целосисленного типа
    var nodes = Vector[Int]()
    //
    def dfs(node: TreeNode): Unit = {
      if (node != null) {
        dfs(node.left)
        nodes :+= node.value
        dfs(node.right)
      }
    }
    dfs(root)
    var newRoot = TreeNode(nodes(0))
    var tmp = newRoot
    for (node <- nodes.slice(1, nodes.length)) {
      tmp.right = TreeNode(node)
      tmp = tmp.right
    }
    newRoot
  }
}
class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}

object Solution {
  def maxDepth(root: TreeNode): Int = {
    // проверка на not null по node в глубину, сперва по левому ноду, затем по правому (находя максимум),
    // каждый раз инкрементируя глубину нодов (+1)
    if (root != null) maxDepth(root.left).max(maxDepth(root.right)) + 1 else 0
  }
}
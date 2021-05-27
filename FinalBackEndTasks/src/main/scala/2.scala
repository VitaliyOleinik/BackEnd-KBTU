class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
  var value: Int = _value
  var left: TreeNode = _left
  var right: TreeNode = _right
}


object Solution {
  def increasingBST(root: TreeNode): TreeNode = {
    // создаю вектор целосисленного типа
    var nodes = Vector[Int]()
    // метод dfs, с примаемым типом данных TreeNode
    def dfs(node: TreeNode): Unit = {
      // проверка на not null
      if (node != null) {
        // передаем значение с класса для поля left объекта node
        dfs(node.left)
        // передаем значение в вектор
        nodes :+= node.value
        // передаем значение с класса для поля right объекта node
        dfs(node.right)
      }
    }
    // запускаем от root dfs method
    dfs(root)
    // передаем в переменную newRoot значение новый объект класса TreeNode первого эл-та vector
    var newRoot = TreeNode(nodes(0))
    var tmp = newRoot
    // цикл для nodes элементов, разделенного от 1 до length of vector
    for (node <- nodes.slice(1, nodes.length)) {
      tmp.right = TreeNode(node)
      tmp = tmp.right
    }
    newRoot
  }
}
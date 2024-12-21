import java.util.*


data class Node(var dat: Int, var left: Node? = null, var right: Node? = null)


class Tree(var root: Node? = null) {

    // Insert Recursive

    fun insert(dat: Int) {
        if (root == null) {
            root = Node(dat)
            return
        }
        _insert(dat, root)
        return
    }

    private fun _insert(dat: Int, node: Node?): Node? {

        if (node == null) {
            return Node(dat)
        }

        if (dat < node.dat) {
            val newNode = _insert(dat, node.left)
            node.left = newNode
            return node
        }

        val newNode = _insert(dat, node.right)
        node.right = newNode
        return node
    }

    // Insert Iterative

    fun insertIterative(dat: Int) {
        if (root == null) {
            root = Node(dat)
            return
        }
        _insertIterative(dat, root)
        return
    }

    private fun _insertIterative(dat: Int, node: Node?) {
        var ptr = node
        while (ptr != null){
            if(dat < ptr.dat){
                if(ptr.left == null){
                    ptr.left = Node(dat)
                    ptr = null
                }else {
                    ptr = ptr.left
                }
            } else {
                if(ptr.right == null){
                    ptr.right = Node(dat)
                    ptr = null
                }else {
                    ptr = ptr.right
                }
            }

        }
    }

    // Search Recursive

    fun search(dat: Int): Boolean {
        return _search(dat, root)
    }

    private fun _search(dat: Int, node: Node?): Boolean {
        if (node == null) {
            return false
        }
        if (node.dat == dat) {
            return true // Node found, stop further traversal
        }
        // Search left if target is less than the current node's value
        if (dat < node.dat) {
            return _search(dat, node.left)
        }
        // Otherwise, search right
        return _search(dat, node.right)
    }

    // Search Iterative

    fun searchIterative(dat: Int): Boolean {
        return _searchIterative(dat, root)
    }

    private fun _searchIterative(dat: Int, node: Node?): Boolean {
        var ptr = node
        while(ptr != null) {
            if (ptr?.dat == dat) {
                return true
            }
            ptr = if(dat < ptr.dat) {
                ptr?.left
            } else {
                ptr?.right
            }
        }
        return false
    }

    // Recursive In Order

    fun inOrder() {
        if (root == null) {
            return
        }
        _inOrder(root)
    }

    private fun _inOrder(node: Node?) {
        if (node == null) {
            return
        }
        _inOrder(node.left)
        println(node.dat)
        _inOrder(node.right)
    }


    // Iterative In Order

    fun inOrderIterative() {
        if (root == null) {
            return
        }
        _inOrderIterative(root)
    }

    private fun _inOrderIterative(node: Node?) {
        var ptr = node
        var stack = Stack<Node>()
        while (stack.isNotEmpty() || ptr != null) {
            while(ptr != null){
                stack.push(ptr)
                ptr = ptr.left
            }
            val p = stack.pop()
            println(p?.dat)

            ptr = p.right
        }
    }
}

fun main() {

    println("insert recursive")
    val tree = Tree()
    tree.insert(13)
    tree.insert(11)
    tree.insert(9)

    tree.insert(12)
    tree.insert(20)
    tree.insert(7)
    tree.insert(8)
    tree.insert(4)

    println("print recursive")
    tree.inOrder()

    print("search recursive: ")
    println(tree.search(2))

    print("search iterative: ")
    println(tree.searchIterative(2))

    println("insert iterative")

    val treeI = Tree()
    treeI.insert(13)
    treeI.insert(11)
    treeI.insert(9)

    treeI.insert(12)
    treeI.insert(20)
    treeI.insert(7)
    treeI.insert(8)
    treeI.insert(4)

    println("print recursive")
    treeI.inOrder()

    print("search recursive: ")
    println(treeI.search(10))

    print("search iterative: ")
    println(treeI.searchIterative(10))

    println("print iterative")
    treeI.inOrderIterative()

}

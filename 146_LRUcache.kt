class LRUCache(val capacity: Int) {

    private var firstNode = LinkedNode(-1, -1)
    private var lastNode = firstNode
    private val nodeMap = mutableMapOf<Int, LinkedNode>()

    fun get(key: Int): Int {
        val node = nodeMap[key] ?: return -1
        delete(node)
        append(node)
        return node.value
    }

    fun put(key: Int, value: Int) {
        if (key in nodeMap) {
            delete(nodeMap[key]!!)
        } else if (nodeMap.size == capacity) {
            delete(firstNode.right!!)
        }

        append(LinkedNode(key, value))
    }

    private fun delete(node: LinkedNode) {
        node.left!!.right = node.right
        node.right?.let { it.left = node.left }
        nodeMap -= node.key

        if (node == lastNode) {
            lastNode = node.left!!
        }
        node.left = null
        node.right = null
    }

    private fun append(node: LinkedNode) {
        lastNode.right = node
        node.left = lastNode
        lastNode = node
        nodeMap[node.key] = node
    }

    private data class LinkedNode(
        val key: Int,
        val value: Int,
        var left: LinkedNode? = null,
        var right: LinkedNode? = null,
    )
}

/////////////////////////////////////////////////////
//////////////////////////////////////////////////

////////////////////////////////////////////////


class LRUCache(private val capacity: Int) {

    // Класс узла для двусвязного списка
    private data class Node(val key: Int, var value: Int, var prev: Node? = null, var next: Node? = null)

    // Фиктивные головной и хвостовой узлы для упрощения условий границ
    private val head = Node(-1, -1)
    private val tail = Node(-1, -1)

    // Карта для хранения соответствий ключ-узел
    private val map = mutableMapOf<Int, Node>()

    init {
        head.next = tail
        tail.prev = head
    }

    // Получение значения из кэша
    fun get(key: Int): Int {
        val node = map[key] ?: return -1
        remove(node)
        insertAtEnd(node)
        return node.value
    }

    // Вставка значения в кэш
    fun put(key: Int, value: Int) {
        if (key in map) {
            remove(map[key]!!)
        } else if (map.size == capacity) {
            remove(head.next!!)
        }

        val newNode = Node(key, value)
        insertAtEnd(newNode)
        map[key] = newNode
    }

    // Удаление узла из списка и карты
    private fun remove(node: Node) {. 
        node.prev!!.next = node.next
        node.next!!.prev = node.prev
        map.remove(node.key)
    }

    // Вставка узла в конец списка
    private fun insertAtEnd(node: Node) {
        node.prev = tail.prev
        node.next = tail
        tail.prev!!.next = node
        tail.prev = node
    }
}




fun main() {
    val lRUCache = LRUCache(2)
    lRUCache.put(1, 1)  // кэш {1=1}
    lRUCache.put(2, 2)  // кэш {1=1, 2=2}
    println(lRUCache.get(1))  // возвращает 1
    lRUCache.put(3, 3)  // наименее недавно использованный ключ был 2, удаляет ключ 2, кэш {1=1, 3=3}
    println(lRUCache.get(2))  // возвращает -1 (не найден)
    lRUCache.put(4, 4)  // наименее недавно использованный ключ был 1, удаляет ключ 1, кэш {4=4, 3=3}
    println(lRUCache.get(1))  // возвращает -1 (не найден)
    println(lRUCache.get(3))  // возвращает 3
    println(lRUCache.get(4))  // возвращает 4
}

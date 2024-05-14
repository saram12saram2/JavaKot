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

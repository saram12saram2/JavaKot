import java.util.PriorityQueue

// Определение класса ListNode
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// Основной класс с функцией mergeKLists
class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val k = lists.size + 1
        val minHeap = PriorityQueue<ListNode>(k, compareBy( { it.`val` } ))
        lists.forEach { headNode ->
            if (headNode != null) minHeap.offer(headNode)
        }
        
        var result: ListNode? = null
        var resultBuilder = result
        while (minHeap.size > 0) {
            val nextNode = minHeap.poll()
            if (result == null) {
                result = nextNode
                resultBuilder = nextNode
            } else {
                resultBuilder!!.next = nextNode
                resultBuilder = nextNode
            }
            if (nextNode.next != null) {
                minHeap.offer(nextNode.next)
            }
        }
        
        return result
    }
}

// Вспомогательная функция для создания связанного списка из массива
fun createList(arr: IntArray): ListNode? {
    if (arr.isEmpty()) return null
    val head = ListNode(arr[0])
    var current = head
    for (i in 1 until arr.size) {
        current.next = ListNode(arr[i])
        current = current.next!!
    }
    return head
}

// print связанного списка
fun printList(node: ListNode?) {
    var current = node
    while (current != null) {
        print("${current.`val`} -> ")
        current = current.next
    }
    println("null")
}

// main
fun main() {
    val lists = arrayOf(
        createList(intArrayOf(1, 4, 5)),
        createList(intArrayOf(1, 3, 4)),
        createList(intArrayOf(2, 6))
    )

    val solution = Solution()
    val mergedList = solution.mergeKLists(lists)

    print("Merged list: ")
    printList(mergedList)
}

// Output : Merged list: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null

/*
Пример

Давайте рассмотрим пример слияния трёх списков:

Вход: lists = [[1,4,5], [1,3,4], [2,6]]

Инициализация мин-кучи:
    Добавляем головные узлы из каждого списка в мин-кучу.
    Мин-куча: [1, 1, 2]

+ Первая итерация:
    Извлекаем наименьший узел (1) из мин-кучи.
    Добавляем следующий узел (4) из первого списка в мин-кучу.
    Результат: 1
    Мин-куча: [1, 2, 4]

+ Вторая итерация:
    Извлекаем наименьший узел (1) из мин-кучи.
    Добавляем следующий узел (3) из второго списка в мин-кучу.
    Результат: 1 -> 1
    Мин-куча: [2, 4, 3]

+ Третья итерация:
    Извлекаем наименьший узел (2) из мин-кучи.
    Добавляем следующий узел (6) из третьего списка в мин-кучу.
    Результат: 1 -> 1 -> 2
    Мин-куча: [3, 4, 6]

+ Последующие итерации:
    Продолжаем этот процесс, извлекая наименьший узел и добавляя его следующий узел в мин-кучу, пока куча не опустеет.
    Конечный результат: 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6

Таким образом, этот подход использует мин-кучу для эффективного слияния k отсортированных списков в один отсортированный список, 
обеспечивая минимальное количество сравнений и упорядоченное добавление узлов.
*/

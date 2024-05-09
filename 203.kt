class Solution {
    fun removeElements(head: ListNode?, `val`: Int): ListNode? {
        // Создаем фиктивный узел, который будет начальной точкой списка
        // Его значение неважно (0 здесь произвольно), главное, что он указывает на исходный список
        var dummy = ListNode(0, head)

        // Инициализируем указатель current для прохода по списку, начиная с его головы
        var current = head

        // Указатель prev указывает на фиктивный узел, чтобы корректно обрабатывать предыдущие элементы
        var prev = dummy

        // Проходим по каждому узлу до тех пор, пока current не станет null (конец списка)
        while (current != null) {
            // Если значение текущего узла совпадает с целевым значением для удаления
            if (current?.`val` == `val`) {
                // prev.next указывает на узел, следующий за current, пропуская тем самым текущий узел
                prev.next = current.next
            } else {
                // В противном случае перемещаем prev на текущий узел, так как не будем его удалять
                prev = current
            }

            // Переходим к следующему узлу
            current = current.next
        }

        // Возвращаем список, начинающийся с узла после фиктивного (dummy.next)
        return dummy.next
    }
}
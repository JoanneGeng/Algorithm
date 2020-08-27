package leetcode.No2

import leetcode.base.ListNode

/**
 *
 * @author JoanneGeng
 * @date 2020/8/27
 **/
fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {

    var l1 = l1
    var l2 = l2
    var sum = 0

    var carry = 0

    val newListNode = ListNode(0)

    var cur = newListNode

    while (l1 != null || l2 != null) {

        val x = l1?.`val` ?: 0
        val y = l2?.`val` ?: 0

        sum = x + y + carry

        carry = sum / 10

        val newNode = ListNode(sum % 10)

        cur.next = newNode
        cur = cur.next!!

        if (l1 != null) l1 = l1.next
        if (l2 != null) l2 = l2.next

    }

    if (carry > 0) {
        cur.next = ListNode(1)
    }

    return newListNode.next


}






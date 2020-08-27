package leetcode.base

/**
 *
 * @author JoanneGeng
 * @date 2020/8/27
 **/
data class ListNode(val `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun newListNode(values: List<Int>): ListNode? {

            var result: ListNode? = null

            for (value in values) {
                val newNode = ListNode(value)

                if (result == null) {
                    result = newNode
                } else {
                    newNode.next = result
                    result= newNode
                }


            }
            return result

        }

    }
}


package leetcode.No2;

import leetcode.base.ListNode;

/**
 * @author JoanneGeng
 * @date 2020/8/26
 **/
public class AddTwoNumbers {

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：8 ->0 -> 7
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode l3 = null;


        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;

            int y = l2 == null ? 0 : l2.val;


            int sum = x + y + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(sum);

            if (l3 != null) {
                newNode.next = l3;
            }
            l3 = newNode;


            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }


        return l3;
    }

    /**
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        int carry = 0;

        ListNode l3 = new ListNode(0);

        ListNode cur = l3;


        while (l1 != null || l2 != null) {

            int x = l1 == null ? 0 : l1.val;

            int y = l2 == null ? 0 : l2.val;


            int sum = x + y + carry;

            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }

            ListNode newNode = new ListNode(sum);

            cur.next = newNode;
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }

        }


        if (l3.val == 0) {
            l3 = l3.next;
        }

        return l3;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(3, new ListNode(4, new ListNode(2)));
        ListNode l2 = new ListNode(4, new ListNode(6, new ListNode(5)));


        ListNode sum = addTwoNumbers(l1, l2);

        ListNode sum1 = addTwoNumbers1(l1, l2);

        while (sum != null) {
            System.out.print(sum.val);
            sum = sum.next;

        }
        System.out.println();
        while (sum1 != null) {
            System.out.print(sum1.val);
            sum1 = sum1.next;
        }

    }


}




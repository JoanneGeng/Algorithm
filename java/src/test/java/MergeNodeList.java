/**
 * leetcode [21]合并两个有序链表
 * 1-2-4 1-3-4
 * 1-1-2-3-4-4
 *
 * @author JoanneGeng
 * @date 2020/6/18
 **/
public class MergeNodeList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode soldier = new ListNode(0);


        ListNode p = soldier;

        while (l1 != null && l2 != null) {

            if (l1.val < l2.val) {

                p.next = l1;

                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null) {

            p.next = l1;

        }
        if (l2 != null) {

            p.next = l2;
        }

        return soldier.next;


    }
}

package linked;

/**
 * 单链表
 *
 * @author JoanneGeng
 * @date 2020/6/18
 **/
public class SinglyLinkedList {


    private Node head = null;


    public Node findByValue(int value) {

        Node p = head;

        while (p != null && p.data != value) {
            p = p.next;
        }

        return p;
    }

    public Node findByIndex(int index) {

        Node p = head;

        int pose = 0;

        while (p != null && pose != index) {
            p = p.next;
            ++pose;
        }

        return p;

    }


    /**
     * 表头插入，无头节点
     * 这种操作将于输入的顺序相反，逆序
     *
     * @return
     */
    public Node insertToHead(int data) {

        Node newNode = new Node(data, null);
        return insertNewNode(newNode);

    }

    public Node insertNewNode(Node newNode) {
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        return head;
    }

    /**
     * 顺序插入
     * 链表尾部插入
     *
     * @param value
     */
    public void insertTail(int value) {
        Node newNode = new Node(value, null);

        if (head == null) {
            head = newNode;
        } else {
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }

            p.next = newNode;

        }

    }

    /**
     * 插入
     *
     * @param p
     * @param value
     */
    public Node insetAfter(Node p, int value) {

        Node newNode = new Node(value, null);


        return insetAfter(p, value);

    }

    public void insetAfter(Node p, Node newNode) {
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    public void insertBefore(Node p, int value) {
        Node newNode = new Node(value, null);
        insertBefore(p, newNode);

    }

    public void insertBefore(Node p, Node newNode) {
        if (p == null) return;
        if (head == null) {
            insertNewNode(newNode);
            return;
        }

        Node q = head;

        while (q.next != null) {
            q = q.next;
        }

        newNode.next = p;

        q.next = newNode;

    }


    public void deleteByNode(Node p) {
        if (p == null || head == null) return;

        if (p == head) {
            head = head.next;
            return;
        }

        Node q = head;

        while (q != null && q.next != p) {
            q = q.next;
        }

        if (q == null) {
            return;
        }

        q.next = q.next.next;

    }

    public void deleteByValue(int value) {
        if (head == null) return;

        Node p = head;

        Node q = null;

        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }

        if (p == null) {
            return;
        }

        if (q == null) {
            head = head.next;
        } else {
            q.next = q.next.next;
        }


    }

    public void printAll() {

        Node p = head;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();

    }
//
//    public boolean TFResult(Node left, Node right){
//
//    }
//

//    // 回文
//    public boolean palindrome(){
//
//
//    }
//
//    //带头结点的链表翻转
//    public Node inverseLinkList_head(Node p){
//
//    }
//
//    //无头结点的链表翻转
//    public Node inverseLinkList(Node p){
//
//    }
//
//    public static Node createNode(int value) {
//
//    }


}

class Node {

    int data;

    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

}

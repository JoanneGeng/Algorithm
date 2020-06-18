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
     * @param p
     * @param value
     */
//    public Node insetAfter(Node p, int value) {
//
//        Node newNode = new Node(value, null);
//
//        if (p == null) return newNode;
//
//
//
//
//
//
//    }

//    public void insetBefore(Node p, int value) {
//
//    }
//
//    public void deleteByNode(Node p) {
//
//    }
//
//    public void deleteByValue(int value) {
//
//    }
//
//    public void printAll() {
//
//    }
//
//    public boolean TFResult(Node left, Node right){
//
//    }
//
//    public boolean palindrome(){
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

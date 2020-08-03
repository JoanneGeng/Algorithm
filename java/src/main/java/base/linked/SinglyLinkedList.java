package base.linked;

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

    public boolean TFResult(Node left, Node right) {

        Node l = left;
        Node r = right;

        boolean flag = true;

        while (l != null && r != null) {
            if (l.data == r.data) {
                l = l.next;
                r = r.next;
                continue;
            } else {
                flag = false;
                break;
            }
        }

        return flag;

    }


    // 回文
    public boolean palindrome() {

        if (head == null) {
            return false;
        }

        Node p = head;

        Node q = head;

        if (p.next == null) {
            System.out.println("只有一个元素");
            return true;
        }

        while (q.next.next != null) {
            p = p.next;
            q = q.next.next;

        }

        System.out.println("中间节点" + p.data);
        System.out.println("开始执行奇数节点的回文判断");
        Node leftLink = null;
        Node rightLink = null;
        if (q.next == null) {
            //　p 一定为整个链表的中点，且节点数目为奇数
            rightLink = p.next;
            leftLink = inverseLinkList(p).next;
            System.out.println("左边第一个节点" + leftLink.data);
            System.out.println("右边第一个节点" + rightLink.data);

        } else {
            //p q　均为中点
            rightLink = p.next;
            leftLink = inverseLinkList(p);
        }

        return TFResult(leftLink, rightLink);
    }

    //带头结点的链表翻转
    public Node inverseLinkList_head(Node p) {

        //　Head　为新建的一个头结点
        Node Head = new Node(9999, null);
        // p　为原来整个链表的头结点,现在Head指向　整个链表
        Head.next = p;

        /*
        带头结点的链表翻转等价于
        从第二个元素开始重新头插法建立链表
        */
        Node Cur = p.next;
        p.next = null;
        Node next = null;

        while (Cur != null) {
            next = Cur.next;
            Cur.next = Head.next;
            Head.next = Cur;
            System.out.println("first " + Head.data);

            Cur = next;
        }

        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return Head;
    }

    //无头结点的链表翻转
    public Node inverseLinkList(Node p) {

        Node pre = null;

        Node r = head;

        System.out.println("z---" + r.data);

        Node next = null;

        while (r != p) {
            next = r.next;

            r.next = pre;
            pre = r;
            r = next;
        }

        r.next = pre;

        //　返回左半部分的中点之前的那个节点
        //　从此处开始同步像两边比较
        return r;

    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }


}

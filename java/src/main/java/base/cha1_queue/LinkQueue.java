package base.cha1_queue;

/**
 * 链式队列
 * @author JoanneGeng
 * @date 2020/6/16
 **/
public class LinkQueue {


    private Node head;

    private Node tail;

    // 入队
    public void enQueue(String data) {

        // 空队列
        if (tail == null) {
            Node newNode = new Node(data, null);
            head = newNode;
            tail = newNode;
        } else {
            tail.next = new Node(data, null);
            tail = tail.next;
        }

    }


    // 出队
    public String deQueue() {

        if (head == null) {
            return null;
        }

        String data = head.data;

        head = head.next;

        // 所有数据出栈，队列需要被清空
        if (head == null) {
            tail = null;
        }

        return data;

    }

    public void printAll() {
        Node p = head;

        while (p != null) {
            System.out.println(p.data);
            p = p.next;
        }
        System.out.println();
    }


    private static class Node {
        private String data;

        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }

        public String getData() {
            return data;
        }
    }


}

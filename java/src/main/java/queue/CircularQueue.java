package queue;

/**
 * @author JoanneGeng
 * @date 2020/6/16
 **/
public class CircularQueue {

    // 声明数组 数组大小n
    private String[] items;

    private int n = 0;

    // 队头
    private int head = 0;

    // 队尾
    private int tail = 0;

    public CircularQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    public Boolean enQueue(String data) {

        // 满栈
        if ((tail + 1) % n == head) {
            return false;
        }

        items[tail] = data;

        tail = (tail + 1) % n;

        return true;
    }

    public String deQueue() {

        if (head == tail) {
            return null;
        }

        String ret = items[head];

        head = (head + 1) % n;

        return ret;


    }


}

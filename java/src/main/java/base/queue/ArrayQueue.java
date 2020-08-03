package base.queue;

/**
 * 顺序队列
 * @author JoanneGeng
 * @date 2020/6/16
 **/

// 用数组实现的队列
public class ArrayQueue {


    // 声明数组 数组大小n
    private String[] items;

    private int n = 0;

    private int head = 0;

    private int tail = 0;

    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 这个需要不断的数据迁移
     * @param item
     * @return
     */
    public boolean enQueue1(String item) {
        // 队列已满
        if (tail == n) return false;

        items[tail] = item;

        ++tail;

        return true;


    }

    /**
     * 解决数据搬移问题，在每次入队时，当空间不够，触发一次数据搬移
     *
     * @param item
     * @return
     */
    public boolean enQueue2(String item) {

        // 队尾已没有空间，判断队列是否做过出栈操作，如果做过，进行「数据搬移」，再进行入栈操作
        if (tail == n) {
            // 队列已满
            if (head == 0) {
                return false;
            }

            for (int i = head; i < tail; ++i) {
                items[i-head] = items[i];
            }
            tail -= head;
            head = 0;

        }

        items[tail] = item;
        ++tail;
        return true;
    }

    public String deQueue() {
        if (head == tail) return null;

        String ret = items[head];

        ++head;
        return ret;
    }


}
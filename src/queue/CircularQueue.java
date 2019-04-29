package queue;

public class CircularQueue {

    private String[] queue;
    private int n = 0; //队列大小
    private int head = 0; //队头
    private int tail = 0; //队尾

    //构造函数，申请一个大小为capacity的数组队列
    public CircularQueue(int capacity){
        queue = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        if ((tail + 1) % n == head) return false; //队列满
        queue[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    //出队
    public String dequeue(){
        if (head == tail) return null; //队列空
        String res = queue[head];
        head = (head + 1) % n;
        return res;
    }

    public void printAll(){
        if (tail > head) {
            for (int i = head; i < tail; i++) {
                System.out.print(queue[i] + " ");
            }
        } else if (tail < head && tail == 0){
            for (int i = head; i < n; i++){
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = head; i < n; i++){
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i < tail; i++){
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        CircularQueue circularQueue = new CircularQueue(5);
        circularQueue.enqueue("a");
        circularQueue.enqueue("b");
        circularQueue.enqueue("c");
        circularQueue.enqueue("d");
        System.out.println("head:" + circularQueue.head + ",tail:" + circularQueue.tail);
        circularQueue.printAll();
        circularQueue.dequeue();
        System.out.println("head:" + circularQueue.head + ",tail:" + circularQueue.tail);
        circularQueue.printAll();
        circularQueue.enqueue("e");
        System.out.println("head:" + circularQueue.head + ",tail:" + circularQueue.tail);
        circularQueue.printAll();
        circularQueue.dequeue();
        System.out.println("head:" + circularQueue.head + ",tail:" + circularQueue.tail);
        circularQueue.printAll();
        circularQueue.enqueue("f");
        System.out.println("head:" + circularQueue.head + ",tail:" + circularQueue.tail);
        circularQueue.printAll();
    }
}

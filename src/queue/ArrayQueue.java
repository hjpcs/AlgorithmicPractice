package queue;

public class ArrayQueue {

    private String[] queue;
    private int n = 0; //队列大小
    private int head = 0; //队头
    private int tail = 0; //队尾

    //构造函数，申请一个大小为capacity的数组队列
    public ArrayQueue(int capacity){
        queue = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        if (tail == n) return false; //队列满
        queue[tail] = item;
        tail++;
        return true;
    }

    //出队
    public String dequeue(){
        if (head == tail) return null; //队列空
        String res = queue[head];
        head++;
        return res;
    }

    public void printAll(){
        for (int i = head; i < tail; i++){
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.enqueue("jack-jones");
        arrayQueue.printAll();
        arrayQueue.enqueue("nike");
        arrayQueue.printAll();
        arrayQueue.enqueue("adidas");
        arrayQueue.printAll();
        arrayQueue.enqueue("vans");
        arrayQueue.printAll();
        arrayQueue.dequeue();
        arrayQueue.printAll();
        arrayQueue.dequeue();
        arrayQueue.printAll();
        arrayQueue.enqueue("puma");
        arrayQueue.printAll();
        System.out.println(arrayQueue.enqueue("fila"));
    }
}

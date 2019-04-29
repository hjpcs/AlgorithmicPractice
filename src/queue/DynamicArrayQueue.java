package queue;

public class DynamicArrayQueue {

    private String[] queue;
    private int n = 0; //队列大小
    private int head = 0; //队头
    private int tail = 0; //队尾

    //构造函数，申请一个大小为capacity的数组队列
    public DynamicArrayQueue(int capacity){
        queue = new String[capacity];
        n = capacity;
    }

    //入队
    public boolean enqueue(String item){
        if (tail == n){ //表示队列末尾没有空间了
            if (head == 0) return false; //tail == n && head == 0表示整个队列都满了
            for (int i = head; i < tail; i++){
                queue[i - head] = queue[i];
            }
            tail -= head;
            head = 0;
        }
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
        DynamicArrayQueue dynamicArrayQueue = new DynamicArrayQueue(5);
        dynamicArrayQueue.enqueue("jack-jones");
        dynamicArrayQueue.printAll();
        dynamicArrayQueue.enqueue("nike");
        dynamicArrayQueue.printAll();
        dynamicArrayQueue.enqueue("adidas");
        dynamicArrayQueue.printAll();
        dynamicArrayQueue.enqueue("vans");
        dynamicArrayQueue.printAll();
        dynamicArrayQueue.dequeue();
        dynamicArrayQueue.printAll();
        dynamicArrayQueue.dequeue();
        dynamicArrayQueue.printAll();
        dynamicArrayQueue.enqueue("puma");
        dynamicArrayQueue.printAll();
        System.out.println(dynamicArrayQueue.enqueue("fila"));
        dynamicArrayQueue.enqueue("boy-london");
        dynamicArrayQueue.printAll();
    }
}

package queue;

public class LinkedListQueue {

    private static class Node{
        private String data;
        private Node next;

        public Node(String data, Node next){
            this.data = data;
            this.next = next;
        }

        public String getData(){
            return data;
        }
    }

    private Node head = null;
    private Node tail = null;

    //入队
    public void enqueue(String value){
        Node queue = new Node(value, null);
        if (tail == null) { //队列为空，head tail都指向第一个元素
            head = queue;
            tail = queue;
        } else { //否则末尾插入
            tail.next = queue;
            tail = tail.next;
        }
    }

    //出队
    public String dequeue(){
        if (head == null) return null; //队列为空
        String res = head.data;
        head = head.next;
        if (head == null){ //如果出队后队列为空，将tail置为null
            tail = null;
        }
        return res;
    }

    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        LinkedListQueue linkedListQueue = new LinkedListQueue();
        for (int i = 0; i < 2; i++){
            linkedListQueue.enqueue(String.valueOf(i));
        }
        linkedListQueue.printAll();
        linkedListQueue.dequeue();
        linkedListQueue.dequeue();
        for (int i = 0; i < 10; i++){
            linkedListQueue.enqueue(String.valueOf(i));
        }
        linkedListQueue.printAll();
    }

}

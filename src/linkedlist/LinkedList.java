package linkedlist;

public class LinkedList {

    //创建一个结点类
    public static class Node{
        private int data; //数据域
        private Node next; //指针域

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    //创建一个新结点，next指向null
    public static Node createNode(int value){
        return new Node(value, null);
    }

    //遍历链表
    public static void printAll(Node list){
        Node p = list;
        while (p != null){
            System.out.println(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }


    //单链表反转
    public static Node reverse(Node list){
        Node curr  = list;
        Node pre = null;
        while (curr != null){
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args){
        LinkedList linkedList = new LinkedList();
        Node list = linkedList.createNode(10);

        linkedList.printAll(list);
    }
}

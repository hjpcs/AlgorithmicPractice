package linkedlist;

import java.util.Scanner;

public class LRUBasedLinkedList {

    public static class Node{
        private int data;
        private Node next;

        public Node(int data, Node next){
            this.data = data;
            this.next = next;
        }

        public int getData(){
            return data;
        }
    }

    private Node head = null;
    private int max = 10; //定义链表长度

    //头插法
    public void insert(int value){
        Node newNode = new Node(value, null);
        if (head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //获得链表当前结点数量
    public int getNum(){
        Node p = head;
        int count = 0;
        while (p != null){
            count++;
            p = p.next;
        }
        return count;
    }

    //遍历打印链表元素
    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //根据值查找结点是否存在
    public boolean findByValue(int value){
        Node p = head;
        while (p != null){
            if (p.data != value){
                p = p.next;
            } else {
                return true;
            }
        }
        return false;
    }

    //删除结点值为指定值的结点
    public void  deleteByValue(int value) {
        if (head == null) return;
        Node p = head;
        Node q = null;
        //p前进一步，q跟着前进一步，直到p的值等于指定值停下，或者链表中没有指定值p指向null
        while (p != null && p.data != value) {
            q = p;
            p = p.next;
        }
        if (p == null) return;
        if (q == null) { //当头结点的值和value相等时q == null
            head = head.next;
        } else {
            q.next = q.next.next;
        }
    }

    //删除链表尾结点
    public void deleteLast(){
        Node p = head;
        Node q = head.next;
        while (q.next != null){
            q = q.next;
            p = p.next;
        }
        p.next = null;
    }

    public void add(int value){
        if (findByValue(value)){
            deleteByValue(value);
            insert(value);
        } else {
            if (getNum() < max){
                insert(value);
            }
            else {
                deleteLast();
                insert(value);
            }
        }
    }

    public static void main(String[] args){
        LRUBasedLinkedList lru = new LRUBasedLinkedList();
        Scanner sc = new Scanner(System.in);
        while (true){
            lru.add(sc.nextInt());
            lru.printAll();
        }
    }
}

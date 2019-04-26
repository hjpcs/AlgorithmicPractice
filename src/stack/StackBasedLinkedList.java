package stack;

import java.util.Scanner;

public class StackBasedLinkedList {

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

    //入栈操作
    public void push(int value){
        Node newNode = new Node(value, null);
        if (head == null){
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //出栈操作
    public int pop(){
        if (head == null) return -1;
        int value = head.data;
        head = head.next;
        return value;
    }

    //遍历栈
    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    /*public static void main(String[] args){
        StackBasedLinkedList stack = new StackBasedLinkedList();
        stack.push(10);
        stack.printAll();
        stack.push(15);
        stack.printAll();
        stack.push(30);
        stack.printAll();
        stack.pop();
        stack.printAll();
    }*/

    static class Test{

        static StackBasedLinkedList stack = new StackBasedLinkedList();

        public static void operator(int num){
            //num：1-入栈，2-出栈
            Scanner value = new Scanner(System.in);
            if (num == 1){
                System.out.print("请输出入栈数字：");
                stack.push(value.nextInt());
                System.out.print("入栈后，当前栈为：");
                stack.printAll();
            } else if (num == 2){
                int popnum = stack.pop();
                System.out.print("出栈数字为" + popnum + "，当前栈为：");
                stack.printAll();
            } else {
                System.out.println("数字无效，请重新输入！");
            }
        }
        public static void main(String[] args){
            Scanner num = new Scanner(System.in);

            while (true){
                System.out.println("请选择操作，1-入栈，2-出栈，输入数字后回车。");
                operator(num.nextInt());
            }
        }
    }
}

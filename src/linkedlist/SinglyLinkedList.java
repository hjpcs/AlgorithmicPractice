package linkedlist;

public class SinglyLinkedList {

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

    private Node head = null;

    //根据值查找结点，返回当前指针
    public Node findByValue(int value){
        Node p = head;
        while (p != null && p.data != value){
            p = p.next;
        }
        return p;
    }

    //根据下标查找结点，返回当前指针
    public Node findByIndex(int index){
        Node p = head;
        int pos = 0;
        while (p != null && pos != index){
            p = p.next;
            ++pos;
        }
        return p;
    }

    //无头结点，表头插入，这种操作将与输入的顺序相反，即逆序
    public void insertToHead(int value){
        Node newNode = new Node(value, null);
        insertToHead(newNode);
    }

    public void insertToHead(Node newNode){
        if (head == null){
            head = newNode;
        } else {
          newNode.next = head;
          head = newNode;
        }
    }

    //顺序插入，链表尾部插入
    public void insertTail(int value){
        Node newNode = new Node(value, null);
        if (head == null)
            head = newNode;
        else {
            Node q = head;
            while (q.next != null){ //将q指向尾结点
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    //在指定结点后插入
    public void insertAfter(Node p, Node newNode){
        if (p == null)
            return;
        newNode.next = p.next;
        p.next=newNode;
    }

    public void insertAfter(Node p, int value){
        Node newNode = new Node(value, null);
        insertAfter(p, newNode);
    }

    //在指定结点前插入
    public void insertBefore(Node p, Node newNode){
        if (p == null) return;
        if (head == p){ //如果p是头结点直接调用表头插入方法
            insertToHead(newNode);
            return;
        }
        Node q = head;
        while (q != null && q.next != p){ //将q指向p的前一个结点
            q = q.next;
        }
        if (q == null) return;
        newNode.next = p;
        q.next = newNode;
    }

    //删除指定结点
    public void deleteByNode(Node p){
        if (p == null || head == null) return;
        if (p == head){ //删除头结点直接将头结点的next指针重新变为头结点即可
            head = head.next;
            return;
        }
        Node q = head;
        while (q != null && q.next != p){ //将q指向p的前一个结点
            q = q.next;
        }
        if (q == null) return;
        q.next = q.next.next;
    }

    //删除结点值为指定值的结点
    public void  deleteByValue(int value){
        if (head == null) return;
        Node p = head;
        Node q = null;
        //p前进一步，q跟着前进一步，直到p的值等于指定值停下，或者链表中没有指定值p指向null
        while (p != null && p.data != value){
            q = p;
            p = p.next;
        }
        if (p == null) return;
        if (q == null){ //当头结点的值和value相等时q == null
            head = head.next;
        } else {
            q.next = q.next.next;
        }

        //可重复删除指定value
        //删除头结点后新的头结点的值仍等于value
        /*if (head != null && head.data == value){
            head = head.next;
        }
        Node pNode = head;
        while (pNode != null){ //遍历链表删除重复值
            if (pNode.next.data == value){
                pNode.next = pNode.next.next;
                continue;
            }
            pNode = pNode.next;
        }*/
    }

    //遍历链表输出值
    public void printAll(){
        Node p = head;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    //带头链表翻转
    public Node inverseLinkList_head(Node p){
        //新建一个头结点
        Node Head = new Node(9999, null);
        //p为原来整个链表的头结点，现在Head指向整个链表
        Head.next = p;

        //带头链表翻转等价于从第二个元素开始重新头插法建立链表
        Node cur = p.next; //从第二个元素开始头插
        p.next = null; //将p置为尾结点
        Node next = null; //保存下一个cur值
        while (cur != null){
            next = cur.next;
            //将cur插入到Head后面
            cur.next = Head.next;
            Head.next = cur;
            ///System.out.println("first " + Head.data);
            cur = next; //将next中保存的下一个cur值重新赋给cur
        }
        return Head; //返回从p结点之后(包括p)链表的逆序的头结点
    }

    //不带头链表翻转
    public Node inverseLinkList(Node p){
        Node pre = null; //保存已翻转部分的头结点
        Node next = null; //保存待翻转部分头结点的下一个值
        Node r = head; //保存待翻转部分的头结点，即正要翻转的结点
        while (r != p){
            next = r.next;
            //将正要翻转的结点插入到已翻转的头部
            r.next = pre;
            pre = r;
            r = next; //将下一个值变为要翻转的结点
        }
        r.next = pre;
        return  r; // 返回从p结点之前(包括p)链表的逆序的头结点
    }

    //判断true or false
    public boolean TFResult(Node left, Node right){
        Node l = left;
        Node r = right;
        System.out.println("left:" + l.data);
        System.out.println("right:" + r.data);
        while (l != null && r != null){
            if (l.data == r.data){
                l = l.next;
                r = r.next;
                continue; //相等继续
            } else {
                break; //不等跳出循环
            }
        }
        //是回文的话l r都将指向null
        //不是回文的话while循环跳出以后l r都不指向null
        if (l == null && r == null){
            System.out.println("结果为");
            return true;
        } else {
            System.out.println("结果为");
            return false;
        }
    }

    //判断是否为回文
    public boolean palindrome(){
        if (head == null){
            return false;
        } else {
            System.out.println("开始执行找到中间结点");
            Node q = head;
            Node p = head;
            if (p.next == null){
                System.out.println("只有一个元素");
                return true;
            }
            while (q.next != null && q.next.next != null){
                q = q.next.next; //快指针前进两步
                p = p.next; //慢指针前进一步
            }
            //while结束时，结点数目为奇数，q.next == null，为偶数，q.next.next == null
            System.out.println("中间结点" + p.data);
            Node leftLink = null;
            Node rightLink = null;
            if (q.next == null){
                //p一定为整个链表的中点，且结点数目为奇数
                //所以舍弃p结点，左右两边结点数目为(n-1)/2，n为结点总数
                System.out.println("开始执行奇数结点的回文判断");
                rightLink = p.next;
                leftLink = inverseLinkList(p).next;
                System.out.println("左边第一个结点" + leftLink.data);
                System.out.println("右边第一个结点" + rightLink.data);
            } else {
                //p，p.next均为中点，链表中间的两个位置，结点数目为偶数
                //左右两边结点数目为n/2，n为结点总数
                System.out.println("开始执行偶数结点的回文判断");
                rightLink = p.next;
                leftLink = inverseLinkList(p);
            }
            return TFResult(leftLink, rightLink);
        }
    }

    public static void main(String[] args){
        SinglyLinkedList link = new SinglyLinkedList();
        int data[] = {1,2,5,3,4};
        //int data[] = {1,5,3,3,5,1};
        for (int i = 0; i < data.length; i++){
            link.insertTail(data[i]);
            //link.insertToHead(data[i]);
        }
        System.out.println("打印原始链表:");
        link.printAll();
        if (link.palindrome()){
            System.out.println("是回文");
        } else {
            System.out.println("不是回文");
        }

        SinglyLinkedList linkedList = new SinglyLinkedList();
        for (int i = 0; i < data.length; i++){
            linkedList.insertTail(data[i]);
        }
        System.out.println("打印原始链表:");
        linkedList.printAll();
        System.out.println("打印翻转后链表:");
        Node p = linkedList.head;
        /*linkedList.head = linkedList.inverseLinkList_head(p).next;
        linkedList.printAll();*/
        while (p.next != null){
            p = p.next;
        }
        //System.out.println(p.data);
        linkedList.head = linkedList.inverseLinkList(p);
        linkedList.printAll();
    }
}
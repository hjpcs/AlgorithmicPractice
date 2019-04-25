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

    //遍历链表，从list结点开始
    public static void printAll(Node list){
        Node p = list;
        while (p != null){
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    private Node head = null;

    //尾插法
    public void insert(int value){
        Node newNode = createNode(value);
        if (head == null){
            head = newNode;
        } else {
            Node q = head;
            while (q.next != null){ //将q指向尾结点
                q = q.next;
            }
            newNode.next = q.next;
            q.next = newNode;
        }
    }

    //单链表反转
    public static Node reverse(Node list){
        Node curr  = list; //要移动的结点
        Node pre = null; //指向逆序链表的头结点
        while (curr != null){
            Node next = curr.next; //保存当前移动结点的下一个结点，防止链地址丢失
            curr.next = pre; //使curr成为逆序链表的头结点
            pre = curr; //使pre指向逆序链表的头结点
            curr = next; //再将next赋给curr，重复此步骤
        }
        return pre; //返回从list结点之后(包括自身)链表的逆序的头结点
    }

    //检测链表是否有环
    public static boolean checkCircle(Node list){
        if (list == null) return false;
        Node fast = list.next;
        Node slow = list;
        //假设有环链表结点数为n，在slow走到尾结点时会和fast相遇
        //slow走过n-1个结点，fast走过2(n-1)个结点
        //时间复杂度O(n)
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) return true;
        }
        return false;
    }

    //求链表中间结点
    public static Node findMiddleNode(Node list){
        if (list == null) return null;
        Node fast = list;
        Node slow = list;
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //返回list结点之后(包括自身)链表的中间结点
        //如果fast.next == null，slow是中间结点
        //如果fast.next.next == null，slow和slow.next都是中间结点
        if (fast.next == null){
            System.out.print("结点总数为奇数，中间结点为：");
            return slow;
        } else {
            System.out.print("结点总数为偶数，中间结点为：");
            return slow;
        }
    }

    //有序链表合并，链表为升序排序
    public static Node mergeSortedListsAsc(Node la, Node lb){
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head; //确定两条链表中最小的值当头结点
        if (p.data < q.data){
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head; //r为新链中待插入的结点
        //哪条链的值小插哪个到新链中
        while (p != null && q != null){
            if (p.data < q.data){
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        //将结点数多的那一条链表后续数据插入新链中
        if (p != null){
            r.next = p;
        } else {
            r.next = q;
        }
        return head; //返回新链的头结点
    }

    //有序链表合并，链表为降序排序
    public static Node mergeSortedListsDesc(Node la, Node lb){
        if (la == null) return lb;
        if (lb == null) return la;

        Node p = la;
        Node q = lb;
        Node head; //确定两条链表中最大的值当头结点
        if (p.data > q.data){
            head = p;
            p = p.next;
        } else {
            head = q;
            q = q.next;
        }
        Node r = head; //r为新链中待插入的结点
        //哪条链的值大插哪个到新链中
        while (p != null && q != null){
            if (p.data > q.data){
                r.next = p;
                p = p.next;
            } else {
                r.next = q;
                q = q.next;
            }
            r = r.next;
        }
        //将结点数多的那一条链表后续数据插入新链中
        if (p != null){
            r.next = p;
        } else {
            r.next = q;
        }
        return head; //返回新链的头结点
    }

    //删除倒数第k个结点
    public static Node deleteLastKth(Node list, int k){
        Node fast = list;
        int i = 1;
        while (fast != null && i < k){ //将fast指向顺数第k个结点
            fast = fast.next;
            ++i;
        }
        //while结束时，如果k大于链表结点总数，fast将指向null，直接返回list
        //如果k等于结点总数，fast将指向尾结点，fast.next == null
        if (fast == null) return list;

        Node slow = list;
        Node prev = null;
        //while结束时，fast指向尾结点，slow指向倒数第k个结点，prev为slow的前一个结点
        //fast从顺数第k个结点走到尾结点，走了n-k步，n为结点总数
        //slow刚好从头结点走到倒数第k个结点，即顺数(n-k+1)个结点
        while (fast.next != null){
            fast = fast.next;
            prev = slow;
            slow = slow.next;
        }
        //如果k等于链表结点总数，则倒数第k个结点即头结点，删除之
        if (prev == null){
            list = list.next;
        } else {
            prev.next = prev.next.next; //删除倒数第k个结点
        }
        return list;
    }

    public static void main(String[] args){
        int data[] = {1,3,5,2,4,6};

        LinkedList reverse = new LinkedList();
        for (int i = 0; i < data.length; i++){
            reverse.insert(data[i]);
        }
        System.out.print("原链表为：");
        reverse.printAll(reverse.head);
        System.out.println(reverse.findMiddleNode(reverse.head).data);

        reverse.head = reverse.reverse(reverse.head);

        System.out.print("翻转后链表为：");
        reverse.printAll(reverse.head);
        System.out.println(reverse.findMiddleNode(reverse.head).data);

        LinkedList circle = new LinkedList();
        for (int i = 0; i < data.length; i++){
            circle.insert(data[i]);
        }
        System.out.print("原链表是否有环：");
        System.out.println(circle.checkCircle(circle.head));
        Node p = circle.head;
        while (p.next != null){ //p指向尾结点
            p = p.next;
        }
        //System.out.println(p.data);
        p.next = circle.head; //将尾结点的next指向头结点形成环
        System.out.print("加环后链表是否有环：");
        System.out.println(circle.checkCircle(circle.head));

        LinkedList asc1 = new LinkedList();
        LinkedList asc2 = new LinkedList();
        LinkedList ascmerge = new LinkedList();
        int dataasc1[] = {1,3,4,7,8};
        int dataasc2[] = {2,4,5,6,8,9,10};
        for (int i = 0; i < dataasc1.length; i++){
            asc1.insert(dataasc1[i]);
        }
        for (int i = 0; i < dataasc2.length; i++){
            asc2.insert(dataasc2[i]);
        }
        System.out.print("原链表asc1为：");
        asc1.printAll(asc1.head);
        System.out.print("原链表asc2为：");
        asc1.printAll(asc2.head);
        ascmerge.head = mergeSortedListsAsc(asc1.head, asc2.head);
        System.out.print("合并后链表ascmerge为：");
        ascmerge.printAll(ascmerge.head);
        int k1 = 12;
        System.out.print("删除倒数第" + k1 + "个结点后：");
        ascmerge.head = ascmerge.deleteLastKth(ascmerge.head, k1);
        ascmerge.printAll(ascmerge.head);

        LinkedList desc1 = new LinkedList();
        LinkedList desc2 = new LinkedList();
        LinkedList descmerge = new LinkedList();
        int datadesc1[] = {6,5,3,1};
        int datadesc2[] = {9,8,6,4,3,1};
        for (int i = 0; i < datadesc1.length; i++){
            desc1.insert(datadesc1[i]);
        }
        for (int i = 0; i < datadesc2.length; i++){
            desc2.insert(datadesc2[i]);
        }
        System.out.print("原链表desc1为：");
        desc1.printAll(desc1.head);
        System.out.print("原链表desc2为：");
        desc2.printAll(desc2.head);
        descmerge.head = mergeSortedListsDesc(desc1.head, desc2.head);
        System.out.print("合并后链表descmerge为：");
        descmerge.printAll(descmerge.head);
        int k2 = 10;
        System.out.print("删除倒数第" + k2 + "个结点后：");
        descmerge.head = descmerge.deleteLastKth(descmerge.head, k2);
        descmerge.printAll(descmerge.head);
    }
}

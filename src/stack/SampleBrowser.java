package stack;

public class SampleBrowser {

    public static class StackByLinkedList{

        public static class Node{

            private String data;
            private Node next;

            public Node(String data, Node next){
                this.data = data;
                this.next = next;
            }
        }

        private int size;
        private Node top;

        public void push(String str){
            Node newNode = new Node(str, null);
            if (top == null){
                top = newNode;
            } else {
                newNode.next = top;
                top = newNode;
            }
            size++;
        }

        public String pop(){
            if (top == null) {
                System.out.println("stack is empty.");
                return null;
            }
            String data = top.data;
            top = top.next;
            return data;
        }

        public void clear(){
            top = null;
            size = 0;
        }

        public String getTopData(){
            if (top == null) return null;
            return top.data;
        }

        public int getSize(){
            return size;
        }

        public void printAll(){
            while (top != null){
                System.out.println(top.data + "\t");
                top = top.next;
            }
            System.out.println();
        }
    }

    private String currentPage;
    private StackByLinkedList backStack;
    private StackByLinkedList forwardStack;

    public SampleBrowser(){
        this.backStack = new StackByLinkedList();
        this.forwardStack = new StackByLinkedList();
    }

    public void checkCurrentPage(){
        System.out.println("current page is " + currentPage);
    }

    public void showUrl(String url, String prefix){
        currentPage = url;
        System.out.println(prefix + "page = " + url);
    }

    public void open(String url){
        if (currentPage != null){
            backStack.push(currentPage);
            forwardStack.clear();
        }
        showUrl(url, "open");
    }

    public boolean canGoBack(){
        return backStack.size > 0;
    }

    public boolean canGoForward(){
        return forwardStack.size > 0;
    }

    public void goBack(){
        if (canGoBack()){
            forwardStack.push(currentPage);
            String backUrl = backStack.pop();
            showUrl(backUrl, "back");
        }
        System.out.println("can't go back, no pages behind.");
    }

    public void goForward(){
        if (canGoForward()){
            backStack.push(currentPage);
            String forwardUrl = forwardStack.pop();
            showUrl(forwardUrl, "forward");
        }
        System.out.println("can't go forward, no pages ahead.");
    }

    public static void main(String[] args) {
        SampleBrowser browser = new SampleBrowser();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }
}

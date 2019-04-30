package sort;

public class BubbleSort {

    public void bubbleSort(int[] a, int n){
        if (n <= 1) return;
        for (int i = 0; i < n; i++){ //有多少个元素执行多少次循环冒泡，i表示已冒泡的元素的个数
            boolean flag = false; //提前退出冒泡排序的标志位
            for (int j = 0; j < n - i - 1; j++){ //每次冒泡需要数据比较的次数，总数-已冒泡的元素个数-1
                if (a[j] > a[j+1]){ //交换
                    int tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    flag = true; //表示有数据交换
                }
            }
            if (!flag) break; //没有数据交换，提前退出
        }
    }

    public static void main(String[] args){
        int[] list = {6,4,5,2,7,8,1,9,3};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubbleSort(list, list.length);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}

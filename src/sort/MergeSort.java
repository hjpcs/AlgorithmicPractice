package sort;

public class MergeSort {

    //归并排序，a是数组，n表示数组大小
    public static void mergeSort(int[] a, int n) {
        mergeSortCalc(a, 0, n-1);
    }

    //递归调用函数
    public static void mergeSortCalc(int[] a, int p, int r) {
        //递归终止条件
        if (p >= r) {
            return;
        }
        //取p到r之间的中间位置q，防止(p+r)的和超过int类型最大值
        int q = p + (r - p) / 2;
        //分治递归
        mergeSortCalc(a, p, q);
        mergeSortCalc(a, q+1, r);
        //将a[p...q]和a[q+1...r]合并为a[p...r]
        merge(a, p, q, r);
    }

    //数组合并
    public static void merge(int[] a, int p, int q, int r) {
        //初始化变量i，j，k
        int i = p;
        int j = q + 1;
        int k = 0;
        //申请一个大小和a[p...r]一样的临时数组
        int[] tmp = new int[r-p+1];
        while (i <= q && j <= r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }

        //判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }

        //将剩余的数据复制到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        //将tmp数据复制回a[p...r]
        for (i = 0; i <= r-p; i++) {
            a[p+i] = tmp[i];
        }
    }

    //数组合并，哨兵模式
    public static void mergeBySentry(int[] arr, int p, int q, int r) {
        int[] leftArr = new int[q - p + 2];
        int[] rightArr = new int[r - q + 1];

        for (int i = 0; i <= q - p; i++) {
            leftArr[i] = arr[p + i];
        }
        //第一个数组添加哨兵
        leftArr[q - p + 1] = Integer.MAX_VALUE;

        for (int i = 0; i < r - q; i++) {
            rightArr[i] = arr[q + 1 + i];
        }
        //第二个数组添加哨兵
        rightArr[r - q] = Integer.MAX_VALUE;

        int i = 0;
        int j = 0;
        int k = p;
        while (k <= r) {
            //当左边数组达到哨兵值时，i不再增加，直到右边数组读取完剩余值，同理右边数组也一样
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {6,4,5,2,7,8,1,9,3};
        mergeSort(list, list.length);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
        System.out.println();
        int[] listSentry = {1,3,6,8,9,10,2,4,5,7,8};
        mergeBySentry(listSentry, 0, 5, 10);
        for (int i : listSentry) {
            System.out.print(i + " ");
        }
    }
}

package sort;

public class KthSmallest {

    private static void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static int partition(int[] arr, int p, int r) {
        int pivot = arr[r];

        int i = p;
        for (int j = p; j < r; j++) {
            //这里是<=，不然会出现死循环，比如查找数组[1,1,2]的第二小的元素
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, r);
        return i;
    }

    public static int kthSmallest(int[] arr, int k) {
        if (arr == null || arr.length < k) {
            return -1;
        }
        int partition = partition(arr, 0, arr.length-1);
        while (partition + 1 != k) {
            if (partition + 1 < k) {
                partition = partition(arr, partition+1, arr.length-1);
            } else {
                partition = partition(arr, 0, partition-1);
            }
        }
        return arr[partition];
    }

    public static void main(String[] args) {
        int[] list = {61,42,53,24,71,86,13,13,13};
        System.out.println(kthSmallest(list, 4));
    }
}

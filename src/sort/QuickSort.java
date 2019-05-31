package sort;

public class QuickSort {

    //快速排序，a是数组，n表示数组大小
    public static void quickSort(int[] a, int n) {
        quickSortCalc(a, 0, n-1);
    }

    //快速排序递归函数，p，r为下标
    public static void quickSortCalc(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = partition(a, p, r); //获取分区点
        quickSortCalc(a, p, q-1);
        quickSortCalc(a, q+1, r);
    }

    public static int partition(int[] a, int p, int r) {
        int pivot = a[r];
        int i = p;
        for (int j = p; j < r; j++) {
            if (a[j] < pivot) {
                if (i == j) {
                    i++;
                } else {
                    int tmp = a[i];
                    a[i++] = a[j];
                    a[j] = tmp;
                }
            }
        }
        int tmp = a[i];
        a[i] = a[r];
        a[r] =tmp;
        System.out.println("i=" + i);
        return i;
    }

    public static void main(String[] args) {
        int[] list = {6,4,5,2,7,8,1,9,3};
        quickSort(list, list.length);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}

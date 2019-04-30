package sort;

public class SelectSort {

    public void selectSort(int[] a, int n){
        if (n <= 1) return;
        for (int i = 0; i < n; i++){
            //查找最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++){
                if (a[j] < a[minIndex]){
                    minIndex = j;
                }
            }
            int tmp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = tmp;
        }
    }

    public static void main(String[] args){
        int[] list = {6,4,5,2,7,8,1,9,3};
        SelectSort selectSort = new SelectSort();
        selectSort.selectSort(list, list.length);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}

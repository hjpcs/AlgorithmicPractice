package sort;

public class InsertSort {

    public void insertSort(int[] a, int n){
        if (n <= 1) return;
        for (int i = 1; i < n; i++){ //执行插入的次数为n-1
            int value = a[i]; //保存当前要执行插入操作的位置的值
            int j = i - 1;
            //查找要插入的位置并移动数据
            for (; j >= 0; j--){
                if (a[j] > value){
                    a[j+1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value; //将保存的值插入到找到的位置上
        }
    }

    public static void main(String[] args){
        int[] list = {6,4,5,2,7,8,1,9,3};
        InsertSort insertSort = new InsertSort();
        insertSort.insertSort(list, list.length);
        for (int i = 0; i < list.length; i++){
            System.out.print(list[i] + " ");
        }
    }
}

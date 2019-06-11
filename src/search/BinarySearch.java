package search;

public class BinarySearch {

    /**
     * 循环实现
     * @param a 数组
     * @param n 数组大小
     * @param value 待查找元素
     * @return 待查找元素的下标
     */
    public int binarySearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现
     * @param a 数组
     * @param low 左边界
     * @param high 右边界
     * @param value 待查找元素
     * @return 待查找元素的下标
     */
    public int binarySearch(int[] a, int low, int high, int value) {
        if (low > high) return -1;
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return binarySearch(a, mid + 1, high, value);
        } else {
            return binarySearch(a, low, mid - 1, value);
        }
    }
}

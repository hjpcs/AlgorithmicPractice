package search;

public class leetcode33 {

    /**
     * 获得数组最大值下标
     * @param a 数组
     * @return 最大值下标
     */
    public static int findMax(int[] a) {
        //数组为空直接返回-1
        if (a.length == 0) {
            return -1;
        }
        int low = 0;
        int high = a.length - 1;
        //当a.length == 1，最大值下标即为0
        if (high == 0) {
            return 0;
        }
        //当a.length == 2，最大值下标为low或high
        if (high == 1) {
            if (a[low] < a[high]) return high;
            else return low;
        }
        //因为数组是循环有序数组，只有当数组升序时，如{1,2,3}，a[high]才会大于a[low]，最大值即为最后一个元素
        if (a[high] > a[low]) {
            return high;
        }
        //当a.length >= 3时，使用二分查找数组最大值下标
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            //此情况出现于当区间缩小至low == 0，high == 1还没找到最大值时，则最大值即为第一个元素，如{5,1,2,3,4}
            if (mid == 0) return mid;
            if (a[mid] > a[mid - 1] && a[mid] > a[mid + 1]) {
                //如果此元素既大于它左边的元素，又大于它右边的元素，则它为最大值，如{4,5,6,7,0,1,2}
                return mid;
            } else if (a[mid] < a[mid - 1] && a[mid] < a[mid + 1]) {
                //如果此元素既小于它左边的元素，又小于它右边的元素，则它为最小值，如{5,6,7,0,1,2,4}
                //根据循环有序数组的特性，最大值即在它左边
                return mid - 1;
            } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1] && a[mid] > a[low]) {
                //如果此元素大于它左边的元素，小于它右边的元素，且大于区间第一个元素，则最大值在它右边，如{1,2,4,5,6,7,0}
                low = mid + 1;
            } else if (a[mid] > a[mid - 1] && a[mid] < a[mid + 1] && a[mid] < a[low]) {
                //如果此元素大于它左边的元素，小于它右边的元素，且小于区间第一个元素，则最大值在它左边，如{6,7,0,1,2,4,5}
                high = mid - 1;
            } else if (a[mid] < a[mid - 1] && a[mid] > a[mid + 1]) {
                //如果此元素小于它左边的元素，大于它右边的元素，只有数组是降序的才会出现这个情况，最大值即为第一个元素，如{3,2,1}
                return 0;
            }
        }
        return -1;
    }

    /**
     * 在循环有序数组中查找元素
     * @param a 数组
     * @param value 待查找元素
     * @return 待查找元素的下标
     */
    public static int search(int[] a, int value) {
        //获得数组最大值下标将数组拆分成两个有序数组
        int index = findMax(a);
        //数组为空，直接返回-1
        if (index == -1) {
            return -1;
        }
        //判断待查找元素在哪个有序数组中，并进行二分查找
        if (value >= a[0] && value <= a[index]) {
            return binarySearch(a, 0, index, value);
        } else {
            return binarySearch(a, index + 1, a.length - 1, value);
        }
    }

    /**
     * 递归实现二分查找
     * @param a 数组
     * @param low 左边界
     * @param high 右边界
     * @param value 待查找元素
     * @return 待查找元素的下标
     */
    public static int binarySearch(int[] a, int low, int high, int value) {
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

    public static void main(String[] args) {
        int[] a = {5,1,2,3,4};
        System.out.println(findMax(a));
        System.out.println(search(a, 4));
    }
}

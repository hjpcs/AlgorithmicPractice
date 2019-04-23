package array;

public class Array {

    public int data[]; //定义整型数组data保存数据
    private int n; //定义数组长度
    private int count; //定义数组中实际数据个数

    //构造方法，定义数组大小
    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0; //一开始数组无数据所以实际个数为0
    }

    //根据下标，查找元素
    public int find(int index){
        //下标越界，正常值0到count-1
        if (index < 0 || index >= count)
            return -1;
        return data[index];
    }

    //在指定下标处插入指定元素值
    public boolean insert(int index, int value){
        //下标越界，正常值0到count，count即为在数组末尾插入数据
        if (index < 0 || index > count){
            System.out.println("位置不合法");
            return false;
        }
        //count == n表示数组已经满了
        if (count == n){
            System.out.println("没有可插入的位置");
            return false;
        }
        //从后往前把data[count-1]到data[index]向后移一位
        for (int i = count - 1; i >= index; --i){
            data[i+1] = data[i];
        }
        data[index] = value;
        ++count;
        return true;
    }

    //根据索引，删除数组中元素
    public boolean delete(int index){
        //下标越界，正常值0到count-1
        if (index < 0 || index >= count)
            return false;
        //从前往后把data[index+1]到data[count-1]向前移一位
        for (int i = index + 1; i < count; ++i){
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll(){
        for (int i = 0; i < count; ++i){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(2, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        array.delete(2);
        array.insert(3, 11);
        array.printAll();
        System.out.println(array.find(3));
    }
}

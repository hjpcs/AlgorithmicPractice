package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUBasedArray<T> {

    private static final int DEFAULT_CAPACITY = (1 << 3); //默认容量为8
    private int capacity; //实际入参容量
    private int count; //当前数组有几个值
    private T[] value;
    private Map<T, Integer> holder;

    public LRUBasedArray(){
        this(DEFAULT_CAPACITY);
    }

    public LRUBasedArray(int capacity) {
        this.capacity = capacity;
        value = (T[]) new Object[capacity];
        count = 0;
        holder = new HashMap<T, Integer>(capacity);
    }

    //模拟访问某个值
    public void offer(T object){
        if (object == null){
            throw new IllegalArgumentException("该缓存容器不支持null");
        }
        Integer index = holder.get(object); //根据值获得下标
        if (index == null){ //缓存中没有此值
            if (isFull()){
                removeAndCache(object);
            } else {
                cache(object, count);
            }
        } else { //缓存中有此值
            update(index);
        }
    }

    //若缓存中有指定的值，则更新位置
    public void update(int end){
        T target = value[end];
        rightShift(end);
        value[0] = target;
        holder.put(target, 0);
    }

    //缓存数据到头部，但要先右移
    public void cache(T object, int end){
        rightShift(end);
        value[0] = object;
        holder.put(object, 0);
        count++;
    }

    //缓存满的情况，踢出后，再缓存到数组头部
    public void removeAndCache(T object){
        T key = value[--count];
        holder.remove(key);
        cache(object, count);
    }

    //end左边的数据统一右移一位，end表示下标
    private void rightShift(int end){
        for (int i = end - 1; i >= 0; i--){
            value[i+1] = value[i];
            holder.put(value[i], i+1);
        }
    }

    public boolean isFull(){
        return count == capacity;
    }

    static class TestLRUBasedArray {

        public static void main(String[] args) {
            testDefaultConstructor();
            testSpecifiedConstructor(4);
            //            testWithException();
        }

        private static void testWithException() {
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(null);
        }

        public static void testDefaultConstructor() {
            System.out.println("======无参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>();
            lru.offer(1);
            lru.offer(2);
            lru.offer(3);
            lru.offer(4);
            lru.offer(5);
            System.out.println(lru);
            lru.offer(6);
            lru.offer(7);
            lru.offer(8);
            lru.offer(9);
            System.out.println(lru);
        }

        public static void testSpecifiedConstructor(int capacity) {
            System.out.println("======有参测试========");
            LRUBasedArray<Integer> lru = new LRUBasedArray<Integer>(capacity);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(3);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
            lru.offer(4);
            System.out.println(lru);
            lru.offer(7);
            System.out.println(lru);
            lru.offer(1);
            System.out.println(lru);
            lru.offer(2);
            System.out.println(lru);
        }
    }
}

package lab;

public class MyArrayData<T> {
    T[] arr;
    int capacity;
    int count=0;

    public MyArrayData(int capacity) {
        this.capacity = capacity;
        arr = (T[])new Object[this.capacity];
    }
    public void add(T t) {
        if(this.capacity> count) {
            arr[count++] = t;
        }
    }
    public T get(int i) {
        if(i<count) {
            return this.arr[i];
        }
        else
            return null;
    }
}

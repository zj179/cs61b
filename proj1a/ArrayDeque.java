public class ArrayDeque<T> {
    private T[] items;
    private int first;
    private int size;
    private int capacity = 8;
    private int last;
    public ArrayDeque(){
        items = (T[])new Object[capacity];
        first = 4;
        last = 5;
        size = 0;
    }
    private void resize(int newsize){
        T[]newArray = (T[])new Object[newsize];
        int start = (first + 1) % capacity;

        for (int i = 0; i < size; i++) {
            newArray[i] = items[(start + i) % capacity];
        }
        first = newsize-1;
        last = size;
        items = newArray;
        capacity = newsize;

    }
    public boolean isFull(){
        return size == capacity;
    }
    public boolean isLowUsageRate(){
        return  (double) size / capacity < 0.25;
    }
    public void addFirst(T item){
        if(isFull()){
            resize(capacity * 2);
        }
        size += 1;
        items[first] = item;
        first = (first - 1) % capacity;
    }
    public void addLast(T item){
        if(isFull()){
            resize(capacity * 2);
        }
        size += 1;
        items[last] = item;
        last = (last + 1) % capacity;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        if(isFull()){
            System.out.print(items[(first+1)%capacity]+ " ");
            first = (first +1) % capacity;
        }
        while((first+1)%capacity != last){
            System.out.print(items[(first+1)%capacity]+ " ");
            first = (first +1) % capacity;
        }
    }
    public T removeFirst(){
        if(isLowUsageRate()){
            resize((int) (capacity * 0.25));
        }
        if(isEmpty()){
            return null;
        }
        size -= 1;
        T item = items[(first + 1) % capacity];
        first = (first +1) % capacity;
        return item;
    }
    public T removeLast(){
        if(isLowUsageRate()) {
            resize((int) (capacity * 0.25));
        }
        if(isEmpty()){
            return null;
        }
        size -= 1;
        T item = items[(last-1) % capacity];
        last = (last - 1) % capacity;
        return item;
    }
    public T get(int index){
        if(index > size -1){
            return null;
        }
        return items[(first+1+index)%capacity];
    }


}

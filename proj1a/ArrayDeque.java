public class ArrayDeque<T> {
    private T[] items;
    private int first;
    private int size;
    private int capacity = 8;
    private int last;
    public ArrayDeque(){
        items = (T[])new Object[capacity];
        first = 0;
        last = 0;
        size = 0;
    }
    private void resize(int newsize){
        T[] newArray = (T[]) new Object[newsize];

        for (int i = 0; i < size; i++) {
            newArray[i] = items[(first + i) % capacity];
        }

        first = newsize;
        last = size;
        items = newArray;
        capacity = newsize;
    }


    private boolean isFull(){
        return size == capacity;
    }
    private boolean isLowUsageRate(){
        return  (double) size / capacity < 0.25;
    }
    public void addFirst(T item){
        if(isFull()){
            resize(capacity * 2);
        }
        size += 1;
        first = (first - 1 + capacity) % capacity;
        items[first] = item;

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
            System.out.print(items[first]+ " ");
            first = (first +1) % capacity;
        }
        while(first != last){
            System.out.print(items[first]+ " ");
            first = (first +1) % capacity;
        }
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        size -= 1;
        T item = items[first];
        first = (first +1) % capacity;
        if(isLowUsageRate()){
            resize((int) (capacity * 0.25));
        }
        return item;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        size -= 1;
        T item = items[(last-1) % capacity];
        last = (last - 1) % capacity;
        if(isLowUsageRate()) {
            resize((int) (capacity * 0.25));
        }
        return item;
    }
    public T get(int index){
        if(index > size -1){
            return null;
        }
        return items[(first+index)%capacity];
    }
    



}

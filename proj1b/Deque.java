public interface Deque<T> {
    public void printDeque();
    public  T getRecursive(int i);
    public  T removeFirst();
    public T removeLast();
    public void addFirst(T item);
    public void addLast(T item);
    public T get(int index);
    public boolean isEmpty();
    public int size();

}

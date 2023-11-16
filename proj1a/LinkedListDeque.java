public class LinkedListDeque<T> {
    private IntNode sentinel;
    private int size;
    private class IntNode {
        private T item;
        private IntNode next;
        private IntNode prev;

        public IntNode( IntNode m, T i,IntNode n) {
            item = i;
            next = n;
            prev = m;

        }
    }

    public LinkedListDeque(){
        sentinel = new IntNode(null,(T) new Object(),null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public void addFirst(T item){
        size += 1;
        IntNode n = new IntNode(sentinel, item,sentinel.next);
        sentinel.next.prev = n;
        sentinel.next = n;

    }
    public void addLast(T item){
        size += 1;
        IntNode n = new IntNode(sentinel.prev,item,sentinel);
        sentinel.prev.next = n;
        sentinel.prev = n;
    }
    public boolean isEmpty(){
        return sentinel.next == sentinel && sentinel.prev == sentinel;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        IntNode p = sentinel.next;
        while(p != sentinel) {
            System.out.print(p.item + "  ");
            p = p.next;
        }
    }
    public T removeFirst(){
        if(isEmpty()){
            return null;
        }
        T p;
        p = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return p;
    }
    public T removeLast(){
        if(isEmpty()){
            return null;
        }
        size -= 1;
        T p = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        return p;
    }
    public T get(int index){
        if(size < index){
            return null;
        }
        int count = 0;
        IntNode p =sentinel.next;
        while(count != index){
            p = p.next;
            count += 1;
        }
        return p.item;
    }
    public T getRecursive(int index){
        if(size < index){
            return null;
        }
        return getRecursive(sentinel.next,index);
    }
    private T getRecursive(IntNode p,int index){
        if(index == 0){
            return p.item;
        }
        return getRecursive(p.next,index-1);
    }
}

import java.util.LinkedList;

public class Cache<T> {
    private final LinkedList<T> items;
    private final int maxSize;
    
    public Cache(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Max size must be positive");
        }
        this.maxSize = maxSize;
        this.items = new LinkedList<>();
    }
    public void add(T item) {
        if (item == null) {
            throw new IllegalArgumentException("Item cannot be null");
        }
        
        items.addLast(item);
        
        if (items.size() > maxSize) {
            items.removeFirst();
        }
    }
}
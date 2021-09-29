import java.util.*;

public class LeastRecentUseCacheInstitution {
    private Deque<Integer> deque;
    private int capacity;
    private Map<Integer, Integer> map = new HashMap<>();
    private Map<Integer,Integer> location=new HashMap<>();

    public static void main(String[] args) {
        LeastRecentUseCacheInstitution lru = new LeastRecentUseCacheInstitution(2);
        System.out.println(lru.get(2));
        lru.put(2,6);
        System.out.println(lru.get(1));
        lru.put(1,5);
        lru.put(1,2);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));

    }
    public LeastRecentUseCacheInstitution(int capacity) {
        deque = new ArrayDeque<>();
        this.capacity = capacity;
    }


    public int get(int key) {
        if (map.containsKey(key)) {
            Integer loc = location.get(key);

            deque.addLast(key);
            return map.get(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        if (deque.size() == this.capacity&&!map.containsKey(key)) {
            Integer poll = deque.poll();
            map.remove(poll);
        }
        Iterator<Integer> iterator = deque.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next.equals(key) || next == key) {
                iterator.remove();
            }
        }
        deque.addLast(key);
        map.put(key, value);


    }

}

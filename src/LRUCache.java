import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int size;
    private int capacity;

    private DLinkedNode head;
    private DLinkedNode tail;
    private Map<Integer,DLinkedNode> cached=new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head=new DLinkedNode();
        this.tail=new DLinkedNode();

    }


    private class DLinkedNode {
        int val;
        int key;
        DLinkedNode prev;
        DLinkedNode next;

        public DLinkedNode(int key,int val) {
            this.val = val;
            this.key=key;
        }

        public DLinkedNode() {
        }
    }




    public int get(int key){
        DLinkedNode node = cached.get(key);
        if(node==null)return -1;
        return 1;

    }

    public void put(int key,int value){



    }


}

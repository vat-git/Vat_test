package twentyfive.oct.twentysix;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache extends LinkedHashMap<Integer,Integer> {

    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        Integer i = super.get(key);
        return i == null ? -1 : i;
    }

    public void put(int key, int value) {
        super.put(key, value);

    }

    @Override
    public boolean removeEldestEntry(Map.Entry<Integer, Integer> entry) {
        return this.size() > capacity;

    }

}

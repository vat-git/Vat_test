package twentyfive.oct.tenth;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<String,Integer> extends LinkedHashMap<String,Integer> {

    private int capcacity;

    public LRUCache(int capcacity) {
        super(capcacity,0.75f,true);
        this.capcacity = capcacity;
    }


    @Override
    public boolean removeEldestEntry(Map.Entry<String, Integer> entry) {
        return size() > capcacity;
    }
}

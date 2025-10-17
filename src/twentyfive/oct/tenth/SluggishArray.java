package twentyfive.oct.tenth;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SluggishArray {
    List<Integer> elements = new ArrayList<>();
    List<Function<Integer,Integer>> maps = new ArrayList<>();

    public void map(Function<Integer, Integer> map) {
        maps.add(map);
    }

    public int getIndexOf(int value) {

        Function<Integer, Integer> compositeMap = Function.identity();
        for (Function map : maps) {
            compositeMap = compositeMap.compose(map);
        }

        for (int i = 0; i < elements.size(); i++) {

            Integer applied = compositeMap.apply(elements.get(i));
            if (applied.equals(value)) {
                return i;
            }
        }

        return -1;
    }

}


/**
 *
 * 1. elements are empty
 * 2. map is empty
 * 3. one of the function is identity function
 *
 *
 */

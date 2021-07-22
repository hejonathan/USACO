import java.util.Map;
import java.util.TreeMap;

public class MultiSet {
    TreeMap<Integer, Integer> tm;
    private int size;

    MultiSet(MovieFestivalII.MultiSet s) {
        tm = new TreeMap<>(s.tm);
        size = s.size();
    }

    MultiSet() {
        tm = new TreeMap<>();
    }

    void add(Integer a) {
        if (!tm.containsKey(a)) tm.put(a, 0);
        tm.put(a, tm.get(a) + 1);
        size++;
    }

    Integer pollFirst() {
        size--;
        if (tm.firstEntry().getValue() > 1) {
            tm.put(tm.firstKey(), tm.firstEntry().getValue() - 1);
            return tm.firstKey();
        } else return tm.pollFirstEntry().getKey();
    }

    Integer first() {
        return tm.firstKey();
    }

    Integer last() {
        return tm.lastKey();
    }

    Integer pollLast() {
        size--;
        if (tm.lastEntry().getValue() > 1) {
            tm.put(tm.lastKey(), tm.lastEntry().getValue() - 1);
            return tm.lastKey();
        } else return tm.pollLastEntry().getKey();
    }

    Integer ceiling(int greaterEqual) {// find the first key greater than or equal to given
        return tm.ceilingKey(greaterEqual);
    }

    Integer floor(int lessEqual) { // first key less than or equal to given
        return tm.floorKey(lessEqual);
    }

    Integer lower(int lessThan) {// first key less than given
        return tm.lowerKey(lessThan);
    }

    Integer higher(int greaterThan) {// first key greater than given
        return tm.higherKey(greaterThan);
    }

    int removeOne(int key) {
        if (!tm.containsKey(key)) return -1;
        size--;
        if (tm.get(key) > 1) tm.put(key, tm.get(key) - 1);
        else tm.remove(key);
        return 0;
    }

    int removeAll(int key) {
        if (!tm.containsKey(key)) return -1;
        int t = tm.remove(key);
        size -= t;
        return t;
    }

    int count(int key) {
        if (!tm.containsKey(key)) return -1;
        return tm.get(key);
    }

    boolean isEmpty() {
        return tm.isEmpty();
    }

    int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Map.Entry<Integer, Integer> e : tm.entrySet()) {
            for (int i = 0; i < e.getValue(); i++) {
                sb.append(e.getKey());
                sb.append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(']');
        return sb.toString();
    }
}

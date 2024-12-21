package kattis;
import java.util.*;

class Pair<K, V> {
    private K key;
    private V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
public class Atlantis {
    static class SortByTime implements Comparator<Pair<Integer, Integer>> {
        public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
            if (a.getValue() != b.getValue()) {
                return a.getValue() - b.getValue();
            } else {
                return a.getKey() - b.getKey();
            }
        }
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        int a, b;
        int seaLevel = 0;
        ArrayList<Pair<Integer, Integer>> store = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a = scnr.nextInt();
            b = scnr.nextInt();
            store.add(new Pair<Integer, Integer>(a, b));
        }

        Collections.sort(store, new SortByTime());
        int k = 0;
        int count = 0;
        while (k < n) {
            if (store.get(k).getValue() > seaLevel) {
                count++;
                seaLevel += store.get(k).getKey();
                k++;
            } else {
                k++;
            }
            seaLevel++;
        }

        System.out.println(count);

    }
    
}

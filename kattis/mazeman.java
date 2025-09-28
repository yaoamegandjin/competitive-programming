// Problem link: https://open.kattis.com/problems/mazeman
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
public class mazeman {

    static char[][] maze;
    static int n, m;
    static boolean[][] collected;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayDeque<Pair<Integer, Integer>> q = new ArrayDeque<>();
    static int count = 0;
    static boolean inbounds(int i, int j) {
        return i >= 0 && i < n && j >= 0 && j < m;

    }
    public static void bfs(Pair<Integer, Integer> e) {
        q.add(e);
        while(!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int x = p.getKey();
            int y = p.getValue();
            for (int k = 0; k < 4; k++) {
                int s = x + dx[k];
                int t = y + dy[k];
                if (inbounds(s, t) && !collected[s][t] && maze[s][t] != 'X') {
                    if (maze[s][t] >= 'A' && maze[s][t] <= 'W') {
                        continue;
                    }
                    if (maze[s][t] == '.') {
                        maze[s][t] = ' ';
                        count++;
                    }
                    q.add(new Pair<>(s, t));
                    collected[s][t] = true;
                }

            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] dimension = sc.nextLine().split(" ");
        n = Integer.parseInt(dimension[0]);
        m = Integer.parseInt(dimension[1]);
        maze = new char[n][m]; 
        collected = new boolean[n][m];
        ArrayList<Pair<Integer, Integer>> entrances = new ArrayList<>();
        String row = "";
        int total_count = 0;
        int entrance_count = 0;
        int dots = 0;
        for (int i = 0; i < n; i++) {
            row = sc.nextLine();
            for (int j = 0; j < m; j++) {
                if (row.charAt(j) == '.') {
                    dots++;
                }
                if (row.charAt(j) >= 'A' && row.charAt(j) <= 'W'){
                    entrances.add(new Pair<>(i,j));
                }
                maze[i][j] = row.charAt(j);
            }
        }
        for (Pair<Integer, Integer> p: entrances) {
            bfs(p);
            if (count > 0) {
                entrance_count++;
            }
            total_count += count;
            count = 0;
        }
        System.out.println(entrance_count + " " + (dots - total_count));
        sc.close(); 
    }
}

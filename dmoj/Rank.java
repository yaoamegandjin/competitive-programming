// Problem link: https://dmoj.ca/problem/acsl1p4
package dmoj;
import java.io.*;
import java.util.*;

public class Rank {
    static Map<Integer, HashSet<Integer>> graph = new HashMap<>();
    static int ans = 0;
    static Set<Integer> visited = new HashSet<>();
    static boolean cyclic = false;

    static boolean dfs(int current, int start) {
        if (visited.contains(current) && current == start) {
            cyclic = true;
            return true;
        }
        if (visited.contains(current)) {
            return true;
        }
        visited.add(current);
        if (!graph.containsKey(current)) {
            graph.put(current, new HashSet<>());
        }
        for (int x : graph.get(current)) {
            dfs(x, start);
        }
        return cyclic;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int people = Integer.parseInt(st.nextToken());
        int games = Integer.parseInt(st.nextToken());

        for (int x = 0; x < games; x++) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int p1s = Integer.parseInt(st.nextToken());
            int p2s = Integer.parseInt(st.nextToken());

            int winner;
            int loser;

            if (p1s > p2s) {
                winner = p1;
                loser = p2;
            } else {
                winner = p2;
                loser = p1;
            }

            if (!graph.containsKey(winner)) {
                graph.put(winner, new HashSet<>());
            }

            graph.get(winner).add(loser);
        }

        for (int x = 1; x <= people; x++) {
            cyclic = false;
            visited = new HashSet<>();
            if (dfs(x, x)) {
                ans++;
            }
        }
        System.out.println(ans);

    }
}

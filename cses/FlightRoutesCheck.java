// Problem link: https://cses.fi/problemset/task/1682
import java.io.*;
import java.util.*;

public class FlightRoutesCheck {
    static int n, m;
    static boolean[] visited;
    static void dfs(int v, ArrayList<ArrayList<Integer>> adj) {
        visited[v] = true;
        for (int to : adj.get(v)) {
            if (!visited[to]) {
                dfs(to, adj);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj1.add(new ArrayList<>());
            adj2.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int city1 = Integer.parseInt(st.nextToken()) - 1;
            int city2 = Integer.parseInt(st.nextToken()) - 1;
            adj1.get(city1).add(city2);
            adj2.get(city2).add(city1);
        }

        visited = new boolean[n];
        dfs(0, adj1);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("NO");
                System.out.println(1 + " " + (i + 1));
                return;
            }
        }

        visited = new boolean[n];
        dfs(0, adj2);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                System.out.println("NO");
                System.out.println((i + 1) + " " + 1);
                return;
            }
        }
        System.out.println("YES");
    }

}

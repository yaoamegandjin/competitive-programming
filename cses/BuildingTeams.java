// Problem link: https://cses.fi/problemset/task/1668
import java.io.*;
import java.util.*;

public class BuildingTeams {
    static ArrayList<Integer>[] adj;
    static int[] assigned;
    static boolean dfs(int node) {
        int curr = assigned[node];
        int nColor = curr == 1 ? 2 : 1;
        for (int n : adj[node]) {
            if (assigned[n] != 0) {
                if (assigned[n] != nColor) {
                    return false;
                }
            } else {
                assigned[n] = nColor;
                if (!dfs(n)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        assigned = new int[n];
        boolean valid = true;
        for (int i = 0; i < n; i++) {
            if (assigned[i] == 0) {
                assigned[i] = 1;
                if (!dfs(i)) {
                    valid = false;
                    break;
                }
            }
        }

        if (valid) {
            for (int i = 0; i < n - 1; i++) {
                System.out.print(assigned[i] + " ");
            }
            System.out.println(assigned[n - 1]);
        } else {
            System.out.println("IMPOSSIBLE");
        }

    }
}

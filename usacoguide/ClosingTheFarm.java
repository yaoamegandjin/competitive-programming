// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=644
package usacoguide;
import java.io.*;
import java.util.*;

public class ClosingTheFarm {
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] visited, closed;
    static int nodes;
    static void dfs(int node) {
        if (visited[node] || closed[node]) {
            return;
        }
        nodes++;
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            dfs(neighbor);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("closing.in"));
        PrintWriter pw = new PrintWriter("closing.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        closed = new boolean[n];
        adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int barn1 = Integer.parseInt(st.nextToken()) - 1;
            int barn2 = Integer.parseInt(st.nextToken()) - 1;
            adj.get(barn1).add(barn2);
            adj.get(barn2).add(barn1);
        }

        int[] order = new int[n];
        
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(br.readLine()) - 1;
        }

        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            nodes = 0;
            dfs(order[n - 1]);
            if (nodes == n - i) {
                pw.println("YES");
            } else {
                pw.println("NO");
            }
            closed[order[i]] = true;
        }
        pw.flush();
        pw.close();
        br.close();

    }
    
}

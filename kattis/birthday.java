// Problem link: https://open.kattis.com/problems/birthday
import java.io.*;
import java.util.*;


public class birthday {
    static int p, c;
    static boolean[][] adj;
    static boolean[] visited;

    static void dfs(int pos) {
        visited[pos] = true;
        for (int to = 0; to < p; to++) {
            if (adj[pos][to] && !visited[to]) {
                dfs(to);
            }
        }
    }

    static class Edge {
        int a, b;
        Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            boolean allConnected = true;
            p = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (p == 0 && c == 0) {
                break;
            }

            adj = new boolean[p][p];
            Edge[] edges = new Edge[c];
            for (int i = 0; i < c; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                adj[a][b] = true;
                adj[b][a] = true;
                edges[i] = new Edge(a, b);
            }
            
            for (Edge edge : edges) {
                adj[edge.a][edge.b] = false;
                adj[edge.b][edge.a] = false;
                visited = new boolean[p];
                dfs(0);

                for (int i = 0; i < p; i++) {
                    if (!visited[i]) {
                        allConnected = false;
                    }
                }
                adj[edge.a][edge.b] = true;
                adj[edge.b][edge.a] = true;
            }

            if (allConnected) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }

        }
    }
    
}

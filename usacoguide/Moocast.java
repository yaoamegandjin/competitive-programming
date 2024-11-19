// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=668
package usacoguide;
import java.io.*;
import java.util.*;


public class Moocast {
    static boolean[][] connected;
    static boolean[] visited;

    static int reachableCows(int c) {
        visited[c] = true;
        int reached = 1;
        for (int nc = 0; nc < connected.length; nc++) {
            if (!visited[nc] &&  connected[c][nc]) {
                visited[nc] = true;
                reached += reachableCows(nc);
            }
        }
        return reached;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("moocast.in"));
        PrintWriter pw = new PrintWriter("moocast.out");
        int cowNum = Integer.parseInt(br.readLine());
        int[] x = new int[cowNum];
        int[] y = new int[cowNum];
        int[] power = new int[cowNum];
        
        for (int c = 0; c < cowNum; c++) {
            StringTokenizer cow = new StringTokenizer(br.readLine());
            x[c] = Integer.parseInt(cow.nextToken());
            y[c] = Integer.parseInt(cow.nextToken());
            power[c] = Integer.parseInt(cow.nextToken());
        }

        connected = new boolean[cowNum][cowNum];
        for (int i = 0; i < cowNum; i++) {
            for (int j = 0; j < cowNum; j++) {
                int distSquared = ((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
                connected[i][j] = distSquared <= power[i] * power[i];
            }
        }

        int maxCows = 0;
        for (int c = 0; c < cowNum; c++) {
            visited = new boolean[cowNum];
            maxCows = Math.max(maxCows, reachableCows(c));
        }
        pw.println(maxCows);
        pw.flush();
        pw.close();
        br.close();
    }
}

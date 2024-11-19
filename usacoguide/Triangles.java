// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=1011
package usacoguide;
import java.io.*;
import java.util.StringTokenizer;

public class Triangles {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("triangles.in"));
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        int[] y = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer post = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(post.nextToken());
            y[i] = Integer.parseInt(post.nextToken());
        }
        br.close();

        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (y[i] == y[j] && x[i] == x[k]) {
                        int area = Math.abs((x[j] - x[i]) * (y[k] - y[i]));
                        maxArea = Math.max(maxArea, area);
                    }
                }
            }
        }
        PrintWriter pw = new PrintWriter("triangles.out");
        pw.println(maxArea);
        pw.close();
        pw.flush();

    }
    
}

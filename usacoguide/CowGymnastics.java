// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=963
package usacoguide;
import java.io.*;
import java.util.*;


public class CowGymnastics {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter("gymnastics.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] rankings = new int[K][N];
        int[][] better = new int[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                rankings[i][j] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    better[rankings[i][j]][rankings[i][k]]++;
                }
            }
        }

        int numOfConsistentPairs = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (better[i][j] == K) {
                    numOfConsistentPairs++;
                }
            
            }
        }
        pw.println(numOfConsistentPairs);
        pw.close();
        pw.flush();
        br.close();

    }

}

// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=736
package usacoguide;
import java.io.*;
import java.util.*;

public class BovineGenomics {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("cownomics.in"));
        PrintWriter pw = new PrintWriter("cownomics.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[][] spottyCows = new String[N][M];
        String[][] plainCows = new String[N][M];

        for (int i = 0; i < N; i++) {
            spottyCows[i] = br.readLine().split("");
        }

        for (int i = 0; i < N; i++) {
            plainCows[i] = br.readLine().split("");
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            HashSet<String> seen = new HashSet<>();
            for (int j = 0; j < N; j++) {
                seen.add(spottyCows[j][i]);

            }
            boolean dupe = false;
            for (int k = 0; k < N; k++) {
                if (seen.contains(plainCows[k][i])) {
                    dupe = true;
                    break;
                }
            }

            if (!dupe) {
                count++;
            }

        }
        pw.println(count);
        pw.flush();
        pw.close();
        br.close();
        
        
    }
}

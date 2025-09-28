// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=784
package usacoguide;
import java.io.*;
import java.util.*;

public class Lifeguards {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter  pw = new PrintWriter("lifeguards.out");

        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int startTimes[] = new int[N];
        int endTimes[] = new int[N];

        int[] times = new int[1000];
        int shiftTotal = -1;

        for (int c = 0; c < N; c++) {
            st = new StringTokenizer(br.readLine());
            startTimes[c] = Integer.parseInt(st.nextToken());
            endTimes[c] = Integer.parseInt(st.nextToken());
            for (int k = startTimes[c]; k < endTimes[c]; k++) {
                times[k]++;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int t = startTimes[i]; t < endTimes[i]; t++) {
                times[t]--;
            }
            int covered = 0;

            for (int t = 0; t < 1000; t++) {
                if (times[t] > 0) {
                    covered++;
                }
            }
            shiftTotal = Math.max(shiftTotal, covered);
            for (int t = startTimes[i]; t < endTimes[i]; t++) {
                times[t]++;
            }
        }
        pw.println(shiftTotal);
        pw.close();
        br.close();

    }
}

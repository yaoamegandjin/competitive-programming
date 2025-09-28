// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=615
package usacoguide;
import java.io.*;
import java.util.*;

public class MilkPails {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter("pails.out");
        StringTokenizer st = new StringTokenizer(br.readLine());

        int pail1 = Integer.parseInt(st.nextToken());
        int pail2 = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());
        int maximum = 0;

        for (int first = 0; first <= order; first++) {
            if (pail1 * first > order) {
                break;
            }
            for (int second = 0; second <= order; second++) {
                int n = (pail1 * first) + (pail2 * second);
                if (n > order) {
                    break;
                }
                maximum = Math.max(n, maximum);
            }
        }

        pw.println(maximum);
        pw.flush();
        pw.close();
        br.close();


    }
}

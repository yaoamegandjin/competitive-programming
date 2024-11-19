// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=639
package usacoguide;
import java.io.*;
import java.util.StringTokenizer;

public class DiamondCollector {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter("diamond.out");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numOfDiamonds = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] diamonds = new int[numOfDiamonds];

        for (int d = 0; d < diamonds.length; d++) {
            diamonds[d] = Integer.parseInt(br.readLine());
        }
        int most = 0;
        for (int x : diamonds) {
            int fittable = 0;
            for (int y : diamonds) {
                if ( x <= y && y <= x + k) {
                    fittable++;
                }
                most = Math.max(fittable, most);
            }
        }
        pw.println(most);
        pw.flush();
        pw.close();
        br.close();


        
    }
}

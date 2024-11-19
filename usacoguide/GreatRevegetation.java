// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=916
package usacoguide;
import java.io.*;
import java.util.StringTokenizer;

public class GreatRevegetation {
    static final int MAXIMUM = 151;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("revegetate.in"));
        PrintWriter pw = new PrintWriter("revegetate.out");
        StringTokenizer s = new StringTokenizer(br.readLine());
        int numOfPasture = Integer.parseInt(s.nextToken());
        int numOfCows = Integer.parseInt(s.nextToken());
        int[] grassA = new int[MAXIMUM];
        int[] grassB = new int[MAXIMUM];
        int[] G = new int[MAXIMUM];
        for(int i = 0; i < numOfCows; i++) {
            s = new StringTokenizer(br.readLine());
            grassA[i] = Integer.parseInt(s.nextToken());
            grassB[i] = Integer.parseInt(s.nextToken());
            if (grassA[i] > grassB[i]) {
                int temp = grassA[i];
                grassA[i] = grassB[i];
                grassB[i] = temp;
            }
        }

        for(int i = 1; i <= numOfPasture; i++) {
            int g;
            for(g = 1; g <= 4; g++) {
                boolean ok = true;
                for (int j = 0; j < numOfCows; j++) {
                    if (grassB[j] == i && G[grassA[j]] == g) {
                        ok = false;
                    }
                }
                if (ok) {
                    break;
                }
            }
            G[i] = g;
            pw.print(g);
        }
        pw.println();
        pw.close();
        br.close();
        pw.flush();
    }
}

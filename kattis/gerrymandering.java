//Problem link: https://open.kattis.com/problems/gerrymandering
import java.io.*;
import java.util.*;
public class gerrymandering {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[][] districts = new int[D][2];
        double V = 0;
        for (int i = 0; i < P; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            districts[d - 1][0] += a;
            districts[d - 1][1] += b;
            V += (a + b);
        }
        int WA = 0;
        int WB = 0;
        for (int i = 0; i < D; i++) {
            if (districts[i][0] > districts[i][1]) {
                int wa = districts[i][0] - ((districts[i][1] + districts[i][0]) / 2) - 1;
                int wb = districts[i][1];
                WA += wa;
                WB += wb;
                pw.println("A " + wa + ' ' + wb);
            } else {
                int wa = districts[i][0];
                int wb = districts[i][1] - ((districts[i][0] + districts[i][1]) / 2) - 1;;
                WA += wa;
                WB += wb;
                pw.println("B " + wa + ' ' + wb);
            }
        }
        pw.println(String.format("%.10f", Math.abs((WA - WB)) / V));
        pw.close();
    }
}

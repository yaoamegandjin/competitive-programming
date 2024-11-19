// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=712
package usacoguide;
import java.io.*;
import java.util.*;

public class CircleCross {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("circlecross.in"));
        PrintWriter pw = new PrintWriter("circlecross.out");
        int[] start = new int[26];
        int[] end = new int[26];
        String crossings = br.readLine();

        Arrays.fill(start, -1);
        Arrays.fill(end, -1);

        for (int i = 0; i < crossings.length(); i++) {
            int cID = crossings.charAt(i) - 'A';
            if (start[cID] == -1) {
                start[cID] = i;
            }
            else {
                end[cID] =  i;
            }
        }

        int crossingsPairs = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                crossingsPairs += (start[i] < start[j] && start[j] < end[i] && end[i] < end[j]) ? 1 : 0;
            }
        }

        pw.println(crossingsPairs);
        pw.flush();
        pw.close();
        br.close();

    }

}

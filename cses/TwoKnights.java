//Link to problem: https://cses.fi/problemset/task/1072
import java.util.*;

public class TwoKnights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        sc.close();
        for (long k = 1; k <= n; k++) {
            // Subract the number of possibility that that the nights attack each other from all the possible ways we can place two knights on the board 
            System.out.println(((k * k) * (k * k - 1)) / 2 - (4 * (k - 2) * (k - 1)));
        }

    }
}

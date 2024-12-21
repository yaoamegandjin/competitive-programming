// Problem link: https://cses.fi/problemset/task/1618
import java.util.*;
import java.io.*;

public class CoinPiles {
    public static void swap(long i, long j) {
        long temp = i;
        i = j;
        j = temp;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        long t = scnr.nextLong();

        for(long i = 0; i < t; i++) {
            long a = scnr.nextLong();
            long b = scnr.nextLong();
            if (a > b) {
                long temp = a;
                a = b;
                b = temp;
            }
            if ((b > 2 * a) || ((a + b) % 3 != 0)) {
                pw.println("NO");
            } else {
                pw.println("YES");
            }
        }
        pw.flush();
        pw.close();
        scnr.close();
    }
    
}

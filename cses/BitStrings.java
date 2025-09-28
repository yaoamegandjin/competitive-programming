// Link to problem: https://cses.fi/problemset/task/1617
import java.util.*;
public class BitStrings {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        long MOD = 1000000007;
        long n = scnr.nextInt();
        long answer = 1; 
        for (long i = 0; i < n; i++) {
            answer *= 2;
            answer %= MOD;

        }
        System.out.println(answer);
        scnr.close();
    }
}

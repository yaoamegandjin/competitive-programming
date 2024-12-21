//Problem link: https://cses.fi/problemset/task/1618
import java.util.*;
public class TrailingZeros {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        long n = scnr.nextLong();
        long result = 0;
        int i = 1;
        while(true) {
            if (n /Math.pow(5, i) == 0) {
                break;
            }
            result += n / Math.pow(5, i);
            i++;
        }
    
        System.out.println(result);
        scnr.close();
    }
}

// Problem link: https://open.kattis.com/problems/callforproblems
import java.util.*;
public class callforproblems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = 0;
        while (n-->0) {
            ans += (sc.nextInt() % 2 == 1 ? 1 : 0);
        }
        System.out.println(ans);
        sc.close();
    }
}

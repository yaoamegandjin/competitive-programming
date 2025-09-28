// Problem link: https://open.kattis.com/problems/dasblinkenlights
import java.util.Scanner;
public class dasblinkenlights {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = sc.nextInt();
        int q = sc.nextInt();
        int s = sc.nextInt();
        sc.close();
        for (int t = 1; t <= s; t++) {
            if ((t % p) == 0 && (t % q) == 0) {
                System.out.println("yes");
                return;
            } 
        }
        System.out.println("no");
    }
}

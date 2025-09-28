// Problem link: https://open.kattis.com/problems/bikesandbarricades
import java.util.*;

public class bikesandbarricades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double closest = -1.0;
        while (n-->0) {
            double x1 = sc.nextDouble();
            double y1 = sc.nextDouble();
            double x2 = sc.nextDouble();
            double y2 = sc.nextDouble();
            if (x1 * x2 < 0.0) {
                double m = (y2 - y1) / (x2 - x1);
                double b = y1 - m * x1;
                if (b > 0.0 && (closest < 0.0 || b < closest)) {
                    closest = b;
                }
            }
        }
        System.out.println(closest);
        sc.close();
    }
}

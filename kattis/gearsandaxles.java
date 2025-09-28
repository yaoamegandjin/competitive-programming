// Problem link: https://open.kattis.com/problems/gearsandaxles
import java.util.*;

public class gearsandaxles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        @SuppressWarnings("unchecked")
        ArrayList<Double> gears[] = new ArrayList[100000];
        Arrays.fill(gears, null);
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt() - 1;
            int c = sc.nextInt();
            if (gears[s] == null) {
                gears[s] = new ArrayList<Double>();
            }
            gears[s].add(Math.log(c));
        }
        double angularSpeed = 0;
        for (ArrayList<Double> gear: gears) {
            if (gear !=null) {
                Collections.sort(gear);
                int size = gear.size();
                for (int i = 0; i < size / 2; i++) {
                    angularSpeed += gear.get(size - i - 1) - gear.get(i);
                }
            }
        }
        System.out.println(angularSpeed);
        sc.close();

    }
}

import java.util.*;

public class dishonestlottery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums = 10 * 5 * n;
        int[] counts = new int[51];
        ArrayList<String> m = new ArrayList<>();
        while (nums-->0) {
            counts[sc.nextInt()]++;
        }
        for (int i = 0; i < 51; i++) {
            if (counts[i] > 2 * n) {
                m.add(i + " ");
            }
        }
        if (m.size() > 0) {
            System.out.println(String.join(" ", m));
        } else {
            System.out.println(-1);
        }
        sc.close();
    }
}

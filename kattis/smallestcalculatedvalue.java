// Problem link: https://open.kattis.com/problems/smallestcalculatedvalue
import java.util.*;

public class smallestcalculatedvalue {
    public static ArrayList<Integer> ops(int x, int y) {
        ArrayList<Integer> result = new ArrayList<>(4);
        result.add(x + y);
        result.add(x - y);
        result.add(x * y);
        if (x % y == 0) {
            result.add(x / y);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        ArrayList<Integer> values = new ArrayList<>(16);
        for (int x: ops(a, b)) {
            values.addAll(ops(x, c));
        }
        int smallest = Integer.MAX_VALUE;
        for (int x: values) {
            if (x >= 0 && x < smallest) {
                smallest = x;
            }
        }
        System.out.println(smallest);
        sc.close();
        
    }
}

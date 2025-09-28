// Problem link: https://cses.fi/problemset/task/1621/
import java.util.*;
public class DistinctNumbers {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashSet<String> nums = new HashSet<String>();
        int N = Integer.parseInt(scnr.next());
        for (int i = 0; i < N; i++) {
            nums.add(scnr.next());
        }
        System.out.println(nums.size());
        scnr.close();
    }
}

// Problem link: https://open.kattis.com/problems/classfieldtrip?tab=metadata
import java.util.*;

public class classfieldtrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String list1 = sc.next();
        String list2 = sc.next();
        String fieldTripList = list1 + list2;
        char[] a = fieldTripList.toCharArray();
        Arrays.sort(a);
        System.out.println(new String(a));
        sc.close();
    }
}

// Link to problem: https://open.kattis.com/problems/missingnumbers?editresubmit=14811221
import java.util.*;

public class missingnumbers {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        HashSet<Integer> recited = new HashSet<>();
        HashSet<Integer> numbers = new HashSet<>();
        int n = scnr.nextInt();
        int max = 0;
        for(int i = 0; i < n; i++) {
            int num = scnr.nextInt();
            max = Math.max(max, num);
            recited.add(num);
        }

        for(int i = 1; i <= max; i++) {
            numbers.add(i);
            if (!recited.contains(i)) {
                System.out.println(i);
            }
        }
        if(recited.containsAll(numbers)) {
            System.out.println("good job");
        }
        scnr.close();

    }
}

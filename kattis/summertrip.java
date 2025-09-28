// Problem link: https://open.kattis.com/problems/summertrip
import java.util.*;
public class summertrip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int isGoodItinerary = 0;
        
        for (char i = 'a'; i <= 'z'; i++) {
            for (char j = 'a'; j <= 'z'; j++) {
                if (i == j) {
                    continue;
                }
                boolean inside = false;
                for (int k = 0; k < s.length(); k++) {
                    if (inside && s.charAt(k) == j) {
                        isGoodItinerary++;
                        inside = false;
                    } else if (!inside &&  s.charAt(k) == i) {
                        inside = true;
                    }
                }
            }
        }
        System.out.println(isGoodItinerary);
        sc.close();
    }
}

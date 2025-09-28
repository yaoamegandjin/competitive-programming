// Problem link: https://open.kattis.com/problems/hissingmicrophone
import java.util.*;

public class hissingmicrophone {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        scnr.close();
        Stack<Character> chars = new Stack<>();
        String word = scnr.next();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!chars.isEmpty() && c == 's' && chars.peek() == 's') {
                System.out.println("hiss");
                return;
            }
            chars.push(c);
        }
        System.out.println("no hiss");
    }
}

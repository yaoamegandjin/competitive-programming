// Problem link: https://cses.fi/problemset/task/1622/
import java.util.*;
public class CreatingStrings {
    public static void swap(StringBuilder s, int i, int j) {
        char temp = s.charAt(i);
        s.setCharAt(i, s.charAt(j));
        s.setCharAt(j, temp);


    }
    public static void permutation(TreeSet<String> uniqueStrings, StringBuilder s, int index) {
        if (index == s.length() - 1) {
            uniqueStrings.add(new String(s));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            swap(s, index, i);
            permutation(uniqueStrings, s, index + 1);
            swap(s, index, i);

        }
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        TreeSet<String> uniqueStrings = new TreeSet<String>();
        StringBuilder s = new StringBuilder(scnr.next());
        permutation(uniqueStrings, s, 0);
        System.out.println(uniqueStrings.size());
        for(String p : uniqueStrings) {
            System.out.println(p);
        }
        scnr.close();
    }
}

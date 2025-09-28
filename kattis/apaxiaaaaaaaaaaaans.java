// Problem link: https://open.kattis.com/problems/apaxiaaans

import java.util.*;

public class apaxiaaaaaaaaaaaans {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String name = scnr.next();
        String compactName = "";

        for (int i = 0; i + 1 < name.length(); i++) {
            if (name.charAt(i) == name.charAt(i + 1)) {
                continue;
            }
            compactName += name.charAt(i);
        }

        compactName += name.charAt(name.length() - 1);
        System.out.println(compactName);
        scnr.close();
    }
    
}

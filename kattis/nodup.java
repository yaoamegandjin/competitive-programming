// Problem link: https://open.kattis.com/problems/nodup
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class nodup {
   public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    HashSet<String> aSetOftheWords = new HashSet<String>();
    ArrayList<String>  words = new ArrayList<>();
    String phrase = scnr.nextLine();
    Scanner  scnr2 = new Scanner(phrase);
    while (scnr2.hasNext()) {
        words.add(scnr2.next());
    }
    for (String n : words)
    {
        aSetOftheWords.add(n);
    }

    if (words.size() == aSetOftheWords.size()) {
        System.out.println("yes");
    }
    else {
        System.out.println("no");
    }
    scnr.close();
    scnr2.close();
   } 

}

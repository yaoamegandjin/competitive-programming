// https://usaco.org/index.php?page=viewproblem2&cpid=941
package usacoguide;
import java.io.*;
import java.util.*;
public class CowEvolution{
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("evolution.in"));
        PrintWriter pw = new PrintWriter("evolution.out");
        int numOfSubPopulations = sc.nextInt();
        ArrayList<HashSet<String>> cows = new ArrayList<>();
        HashSet<String> allCharSet = new HashSet<>();
        for (int c = 0; c < numOfSubPopulations; c++){
            int numOfChar = sc.nextInt();
            HashSet<String> currCow = new HashSet<>();
            for (int i = 0; i < numOfChar; i++) {
                currCow.add(sc.next());
            }
            allCharSet.addAll(currCow);
            cows.add(currCow);
        }
        sc.close();

        ArrayList<String> allChars = new ArrayList<>(allCharSet);
        for (int a = 0; a < allChars.size(); a++) {
            for(int b = a + 1; b < allChars.size(); b++) {
                boolean both = false, onlyA = false, onlyB = false;
                for (HashSet<String> c : cows) {
                    boolean hasA = c.contains(allChars.get(a));
                    boolean hasB = c.contains(allChars.get(b));
                    if (hasA && hasB) {
                        both = true;
                    } else if (hasA && !hasB) {
                        onlyA = true;
                    } else if (!hasA && hasB){
                        onlyB = true;
                    }

                    if (onlyA && onlyB && both) {
                        pw.println("no");
                        pw.close();
                        break;
                    }
                }
            }
        }
        pw.println("yes");
        pw.close();
    }
}

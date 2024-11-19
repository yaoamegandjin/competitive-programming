// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=893
package usacoguide;
import java.io.*;
import java.util.*;

public class GuessTheAnimal {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        int numOfAnimals = Integer.parseInt(br.readLine());
        @SuppressWarnings("unchecked")
        HashSet<String>[] animals = new HashSet[numOfAnimals];
        for (int a = 0; a < numOfAnimals; a++) {
            StringTokenizer line = new StringTokenizer(br.readLine());
            line.nextToken();
            int attrNum = Integer.parseInt(line.nextToken());
            animals[a] = new HashSet<>();
            for (int attr = 0; attr < attrNum; attr++) {
                animals[a].add(line.nextToken());
            }
        }

        int maxYes = 0;
        for (int a1 = 0; a1 < numOfAnimals; a1++) {
            for (int a2 = a1 + 1; a2 < numOfAnimals; a2++) {
                HashSet<String> a1Copy = new HashSet<>(animals[a1]);
                a1Copy.retainAll(animals[a2]);
                maxYes = Math.max(maxYes, a1Copy.size() + 1);
            }
        }

        PrintWriter pw = new PrintWriter("guess.out");
        pw.println(maxYes);
        pw.close();
        br.close();
    }
    
}

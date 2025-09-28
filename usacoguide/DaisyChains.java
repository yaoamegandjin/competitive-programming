// Problem link: https://usaco.org/index.php?page=viewproblem2&cpid=1060
package usacoguide;
import java.io.*;
import java.util.*;
public class DaisyChains {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfFlowers = Integer.parseInt(br.readLine());
        int[] flowers = new int[numOfFlowers];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < flowers.length; i++) {
            flowers[i] = Integer.parseInt(st.nextToken());
        }

        int averageFlowerCount = 0;

        for (int i = 0; i < numOfFlowers; i++) {
            for (int j = i; j < numOfFlowers; j++) {
                double averagePetals = 0;
                for (int f = i; f <= j; f++) {
                    averagePetals += flowers[f];
                }
                averagePetals /= j - i + 1;

                for (int index = i; index <= j; index++) {
                    if (flowers[index] == averagePetals){

                        averageFlowerCount++;
                        break;
                    }
                }
            }
        }
        System.out.println(averageFlowerCount);
        br.close();
    }
}

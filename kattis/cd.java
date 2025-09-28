// Problem link: https://open.kattis.com/problems/cd?tab=metadata
import java.util.*;
import java.io.*;
public class cd {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int titlesOwnedByBoth = 0;

        while (true) {
            HashSet<Integer> jackCompactDiscs = new HashSet<Integer>();
            titlesOwnedByBoth = 0;
            String[] nums = br.readLine().split(" ");
            int titlesOwnedByJack = Integer.parseInt(nums[0]);
            int titlesOwnedByJill = Integer.parseInt(nums[1]);
            if (titlesOwnedByJack == 0 && titlesOwnedByJill == 0)
                break;

            for (int i = 0; i < titlesOwnedByJack; ++i) {
                jackCompactDiscs.add(Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < titlesOwnedByJill; ++i) {
                if (jackCompactDiscs.contains(Integer.parseInt(br.readLine()))) {
                    titlesOwnedByBoth += 1;
                }
            }
            System.out.println(titlesOwnedByBoth);
        }

    }
}

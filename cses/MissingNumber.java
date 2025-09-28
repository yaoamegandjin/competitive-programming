// Link to problem: https://cses.fi/problemset/task/1083S
import java.io.*;
import java.util.*;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<String> numbers = new HashSet<String>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<String> isMissingNumber = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            numbers.add(i + 1 + "");
        }
        for (int j = 0; j < n - 1; j++) {
            isMissingNumber.add(st.nextToken());
        }
        // if numbers and isMissingNumber share a common num removes those numbers
        numbers.removeAll(isMissingNumber);
        Object [] answer = numbers.toArray();
        System.out.println(answer[0]);


    }
    
}

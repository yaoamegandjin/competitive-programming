// Link to problem: https://cses.fi/problemset/task/1094S
import java.io.*;
import java.util.*;

public class IncreasingArray {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in),  30000);
        int numOfIntegers = Integer.parseInt(br.readLine());
        long[] arr = new long[numOfIntegers];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long ans = 0;
        for (int i = 0; i < numOfIntegers; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int j = 1; j < numOfIntegers; j++) {
            // make sure adjacent elements are the same high, if not add their difference to answer. Which represents the number of moves
            if (arr[j] < arr[j - 1]) {
                ans += arr[j - 1] - arr[j];
                arr[j] = arr[j - 1] ;
            }
        }
        System.out.println(ans);
        
    }
}

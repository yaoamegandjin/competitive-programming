// Link to problem: https://cses.fi/problemset/task/1069/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Repetitions {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sequence = br.readLine();
        int ans = 1;
        int count = 1;
        for (int i = 1; i < sequence.length(); i++) {
            // If the current character the same as previous, increment count 
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                count++;
            } else {
                // If the current character is different from the previous, reset count to 1
                count = 1;
            }
            ans = Math.max(ans, count);
        }
        System.out.println(ans);    
    }
    
}

// Link to problem - https://cses.fi/problemset/task/1068S
import java.io.*;

public class WeirdAlgorithm {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(br.readLine());
        while (n != 1) {
            // If n is even, divide it by 2
            System.out.println(n + " ");
            if (n % 2 == 0) {
                n /= 2;
            }
            // If n is odd, then multiply it by 3 and add 1
            else {
                n = n * 3 + 1;
            }
        }
        System.out.print(1);

    }
}

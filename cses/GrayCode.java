import java.util.*;
public class GrayCode {
    public static void decimalToBinary(int num) {
        Stack<Integer> bits = new Stack<>();
        while (num > 0) {
            bits.push(num % 2);
            num = num / 2;
        }
        while (!bits.isEmpty()) {
            System.out.print(bits.pop());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        for (int i = 0; i < 2*n; i++) {
            decimalToBinary(i);
        }
    }
    
}

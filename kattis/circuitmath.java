// Problem link: https://open.kattis.com/problems/circuitmath
// Status: unsolved
import java.util.*;
import java.io.*;

public class circuitmath {
    public static void main(String[] args) throws IOException{
        Scanner scnr = new Scanner(System.in);
        Stack<Boolean> l = new Stack<>();
        int n = scnr.nextInt();
        boolean[] truthValues = new boolean[n];
        char inputValue = '/';
        boolean result = true;
        for (int i = 0; i < n; i++) {
            inputValue = scnr.next().charAt(0);
            truthValues[i] = (inputValue == 'T');
        }
        String circuit = scnr.nextLine();
        circuit = scnr.nextLine().replaceAll("\\s", "");
        for (int i = 0; i < circuit.length(); i++) {
            inputValue = circuit.charAt(i); 
            if (inputValue == '*') {
                result = l.pop() && l.pop();
                l.push(result);
            } else if (inputValue == '+') {
                result = l.pop() || l.pop();
                l.push(result);
            } else if (inputValue == '-') {
                result = !(l.pop());
                l.push(result);
            } else {
                l.push(truthValues[inputValue - 'A']);
            }
        }
        scnr.close();
        System.out.println(l.peek() ? "T" : "F");
    }
}

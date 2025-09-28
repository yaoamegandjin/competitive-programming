// Problem link: https://cses.fi/problemset/task/2205/
import java.util.*;
public class GrayCode {
    public static List<String> generateGrayCode(int n) {
        if (n == 1) {
            List<String> grayCode = new ArrayList<>();
            grayCode.add("0");
            grayCode.add("1");
            return grayCode;
        }
        List<String> prevGrayCode = generateGrayCode(n - 1);
        List<String> reversedPrevGrayCode = new ArrayList<>(prevGrayCode);
        Collections.reverse(reversedPrevGrayCode);
        for(int i = 0; i < prevGrayCode.size(); i++) {
            prevGrayCode.set(i, "0" + prevGrayCode.get(i));
            reversedPrevGrayCode.set(i, "1" + reversedPrevGrayCode.get(i));
        }
        prevGrayCode.addAll(reversedPrevGrayCode);
        return prevGrayCode;
    }
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int n = scnr.nextInt();
        List<String> grayCode = generateGrayCode(n);
        for (String code : grayCode) {
            System.out.println(code);
        }
        scnr.close();
    }
    
}

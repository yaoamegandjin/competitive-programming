import java.io.*;
public class AppleDivision {
    public static long minimumDifference(int index, String[] arr, long sum1, long sum2, int N) {
        if (index == N) {
            return Math.abs(sum1 - sum2);
        }
        long group1 = minimumDifference(index + 1, arr, sum1 + Long.parseLong(arr[index]), sum2, N);
        long group2 = minimumDifference(index + 1, arr, sum1, sum2 + Long.parseLong(arr[index]), N);
        return Math.min(group1, group2);
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numOfapples = Integer.parseInt(br.readLine());
        String[] appleWeights = (br.readLine()).split(" ");
        System.out.println(minimumDifference(0, appleWeights, 0, 0, numOfapples));

    }
}

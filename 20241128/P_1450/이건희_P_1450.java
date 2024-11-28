import java.util.*;
import java.io.*;

public class Main {
    static int maxWeight;
    static int[] items;
    static ArrayList<Integer> leftSums, rightSums;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer input = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(input.nextToken());
        maxWeight = Integer.parseInt(input.nextToken());

        items = new int[n];
        input = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(input.nextToken());
        }

        leftSums = new ArrayList<>();
        rightSums = new ArrayList<>();

        cal(leftSums, 0, n / 2, 0);
        cal(rightSums, n / 2, n, 0);

        Collections.sort(rightSums);

        int count = 0;
        for (int leftSum : leftSums) {
            count += upperBound(rightSums, maxWeight - leftSum);
        }

        System.out.println(count);
    }

    static void cal(ArrayList<Integer> sums, int start, int end, int sum) {
        if (sum > maxWeight) return;
        if (start == end) {
            sums.add(sum);
            return;
        }
        cal(sums, start + 1, end, sum);
        cal(sums, start + 1, end, sum + items[start]);
    }

    static int upperBound(ArrayList<Integer> list, int value) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
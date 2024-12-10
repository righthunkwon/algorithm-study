import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        int n = s.length;

        ArrayList<Integer> leftK = new ArrayList<>();
        ArrayList<Integer> rightK = new ArrayList<>();
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s[i] == 'K') cnt++;
            else leftK.add(cnt);
        }

        cnt = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s[i] == 'K') cnt++;
            else rightK.add(cnt);
        }
        Collections.reverse(rightK);

        int start = 0;
        int end = leftK.size() - 1;
        int answer = 0;

        while (start <= end) {
            int leftv = leftK.get(start);
            int rightv = rightK.get(end);
            int length = (end - start + 1) + Math.min(leftv, rightv) * 2;
            answer = Math.max(answer, length);

            if (leftv < rightv) start++;
            else end--;
        }

        System.out.println(answer);
    }
}
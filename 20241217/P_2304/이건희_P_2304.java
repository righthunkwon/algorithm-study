import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] polls = new int[n][2];
        for (int i = 0; i < n; i++) {
            polls[i][0] = sc.nextInt();
            polls[i][1] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(polls, (a, b) -> a[0] - b[0]);

        int maxHeight = 0;
        int maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (polls[i][1] > maxHeight) {
                maxHeight = polls[i][1];
                maxIdx = i;
            }
        }

        int area = 0;

        int curH = 0;
        int prevPos = polls[0][0];
        for (int i = 0; i < maxIdx; i++) {
            if (polls[i][1] > curH) {
                curH = polls[i][1];
            }
            area += curH * (polls[i + 1][0] - polls[i][0]);
        }

        curH = 0;
        prevPos = polls[n - 1][0];
        for (int i = n - 1; i > maxIdx; i--) {
            if (polls[i][1] > curH) {
                curH = polls[i][1];
            }
            area += curH * (polls[i][0] - polls[i - 1][0]);
        }

        area += maxHeight;

        System.out.println(area);
    }
}

// 4개 이하로 주어졌으니까 4중 for문
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new ArrayList<>();
        while (true) {
            int n = sc.nextInt();
            if (n == 0) break;
            results.add(count(n));
        }

        for (int result : results) {
            System.out.println(result);
        }
    }

    private static int count(int n) {
        int count = 0;

        for (int a = 0; a * a <= n; a++) {
            for (int b = a; a*a + b * b <= n; b++) {
                for (int c = b; a*a + b*b + c * c <= n; c++) {
                    for (int d = c; a*a + b*b + c*c + d * d <= n; d++) {
                        if (a*a + b*b + c*c + d * d == n) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int max = 2_000_000;
        boolean[] prime = new boolean[max+1];
        Arrays.fill(prime, true);  prime[0] = prime[1] = false;

        for (int i = 2; i * i <= max; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    prime[j] = false;
                }
            }
        }

        for (int i = n; i <= max; i++) {
            if (prime[i] && check(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    public static boolean check(int num) {
        String str = Integer.toString(num);
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
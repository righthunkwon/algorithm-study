package _20240110;

import java.io.*;
import java.util.*;

public class _21870_시철이가사랑한GCD {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(arr));
    }


    private static int solve(int[] array) {
        int mid = array.length / 2;
        if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return array[0] + array[1];
        } else {
            return Math.max(solve(Arrays.copyOfRange(array, 0, mid)) + gcd(Arrays.copyOfRange(array, mid, array.length)),
            		solve(Arrays.copyOfRange(array, mid, array.length)) + gcd(Arrays.copyOfRange(array, 0, mid)));
        }
    }

    private static int gcd(int[] lst) {
        int a = lst[0];
        for (int i = 1; i < lst.length; i++) {
            a = gcd(a, lst[i]);
        }
        return a;
    }

    private static int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}

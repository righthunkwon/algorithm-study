package _20231115;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2108_통계학2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int arr[] = new int[N];

        for (int i = 0; i < N; i++) {
            int a = Integer.parseInt(br.readLine());
            arr[i] = a;
            if (a < min) min = a;
            if (a > max) max = a;
            sum += a;
        } // 입력끝
        Arrays.sort(arr);

        int[] check = new int[8001]; // -4000 ~ 4000 까지의 값을 저장하기 위해 크기를 8001로 한다
        int maxFreq = 0;
        int maxFreqValue = 0;
        boolean isSecond = false;

        for (int i=0; i<N; i++) {
            check[arr[i] + 4000]++; // 값이 -4000 ~ 4000 이므로, 4000을 더한다
            if (check[arr[i] + 4000] > maxFreq) {
                maxFreq = check[arr[i] + 4000];
                maxFreqValue = arr[i];
                isSecond = false;
            } else if (check[arr[i] + 4000] == maxFreq && !isSecond) {
                // maxFreqValue와 같고, isSecond가 false일 때만 값이 기록되도록 하여서
            	// 여기엔 항상 두번째로 작은 값이 기록되도록 한다.
            	maxFreqValue = arr[i];
                isSecond = true;
            }
        }

        System.out.println(Math.round((double) sum / N));
        System.out.println(arr[N / 2]);
        System.out.println(maxFreqValue);
        System.out.println(max - min);
    }
}

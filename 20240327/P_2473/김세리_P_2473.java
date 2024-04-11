package _20240411;

import java.util.*;

public class _2473_세용액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] solutions = new long[N];

        for (int i=0;i<N;i++) {
            solutions[i] = sc.nextLong();
        }
        // 용액을 정렬
        Arrays.sort(solutions);

        long resultValue = Long.MAX_VALUE;
        int[] result = new int[3];
        
        // 첫번째 용액은 고정
        for (int i=0;i<N-2;i++) {
        	
        	// 나머지 두 용액을 투 포인터를 사용하여 합의 절댓값이 가장 작은 조합을 찾는다
            int left=i+1,right=N-1;
            while (left < right) {
                long sum = solutions[i] + solutions[left] + solutions[right];

                if (Math.abs(sum) < resultValue) {
                    resultValue = Math.abs(sum);
                    result[0] = i;
                    result[1] = left;
                    result[2] = right;
                }

                if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        System.out.println(solutions[result[0]] + " " + solutions[result[1]] + " " + solutions[result[2]]);
    }
}

package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_Q21870_시철이가_사랑한_GCD {
	static int N;
	static int[]arr;
	public static void main(String[] args) throws IOException {
		//⌊5/2⌋ = 2 (내림) ,  ⌈5/2⌉ = 3 (올림)
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());//원소 수
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}//입력끝
		
		System.out.println(dfs(arr));
	
	}//main
	
	public static int dfs(int[] arr) {
		if(arr.length==1) {
			return arr[0];
		}
		else if(arr.length==2) {
			return arr[0]+arr[1];
		}else {
			int mid = arr.length/2;
			int[] left = Arrays.copyOfRange(arr, 0, mid);
			int[] right = Arrays.copyOfRange(arr, mid, arr.length);
			return Math.max(findGCD(left)+dfs(right), dfs(left)+findGCD(right));
		}
	}
	
	// 최대공약수 계산을 위한 유클리드 호제법을 이용한 메서드
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 정수 배열의 최대공약수를 구하는 메서드
    public static int findGCD(int[] arr) {
        if (arr.length == 0) {
            return 0; // 배열이 비어있을 경우 최대공약수는 0
        }
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
            if (result == 1) {
                return 1; // 최대공약수가 1이 되면 더 이상 진행할 필요 없음
            }
        }
        return result;
    }
	
	
}

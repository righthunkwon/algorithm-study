import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static String[] arr;
	static String[] arr2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		// char로 맨앞에 글자를 먼저 알아내야
		
		arr = new String[N];
		arr2 = new String[M];
		
		for(int i = 0;i<N;i++) {
			arr[i] = sc.next();
		}
		for(int i = 0;i<M;i++) {
			arr2[i] = sc.next();
		}
		// 입력끝
		int ans = 0;
		Arrays.sort(arr);
		Arrays.sort(arr2);
		int index = 0;
		int index2 = 0;
		// 맨앞의 글자를 확인해서
		// 맨앞의 글자가 같을때는 
		// 확인하고 만약 tmp2가 더크면 index를 계속 증가시킴
		while(true) {
			if(index==N || index2 ==M) {
				break;
			}
			int tmp = arr[index].charAt(0);
			int tmp2 = arr2[index2].charAt(0);
			// 비교대상이 더 알파벳 큰경우
			if(tmp<tmp2) {
				index++;
			}
			// 비교대상이 더 알파벳 작은경우
			else if(tmp>tmp2) {
				index2++;
			}
			// 두개 맨앞이 같은경우
			else {
				if(arr2[index2].equals(arr[index].substring(0,arr2[index2].length()))) {
					ans++;
					index2++;
					continue;
				}
				// 두개 다르면 뒷자리 비교해서 
				// 상황에 따라 index를 더한다.
				for(int i = 1;i<Math.min(arr[index].length(), arr2[index2].length());i++) {
					if(arr[index].charAt(i) > arr2[index2].charAt(i)) {
						index2++;
						break;
					}
					else if(arr[index].charAt(i) < arr2[index2].charAt(i)) {
						index++;
						break;
					}
				}
			}
			
		}
		System.out.println(ans);
		
	}
}

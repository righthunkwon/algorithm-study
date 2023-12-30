import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	static int N ;
	static int K;
	static int[] arr;
	static ArrayList<Integer> dis;
	static int sum;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	K = sc.nextInt();
    	arr = new int[N];
    	dis = new ArrayList<>();
    	// 차이는 총 N-1개가 나는데
    	// 그 사이에서 N-K개만큼 골라야 한다. // 여기선 5-3 = 2개
    	// 차가 가장큰것은 혼자				
    	for(int i =0;i<N;i++) {
    		arr[i] = sc.nextInt();
    	}
    	// 입력 끝
    	for(int i =1;i<N;i++) {
    		dis.add(arr[i] - arr[i-1]);
    	}
    	// 두수의 차만큼 dis 배열에 저장
    	// 그다음 오름차순 정렬 후 
    	// n-k개 만큼 sum에 더함
    	sum = 0;
    	Collections.sort(dis);
    	
    	
    	for(int i =0;i<N-K;i++) {
    		sum += dis.get(i);
    	}
    	
    	System.out.println(sum);
    }
}

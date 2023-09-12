package _20230913;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class _19699_소난다 {
	public static int n,m;
	public static int[] weight;
	public static boolean[] visited;
	public static HashSet<Integer> set = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		weight = new int[n];
		visited = new boolean[n];
		// 소무게를 입력받는다
		for(int i=0;i<n;i++) {
			weight[i] = sc.nextInt();
		}
		dfs(0,0,0);
		// HashSet의 데이터를 연결리스트에 입력해 정렬한다
		ArrayList<Integer> result = new ArrayList<>(set);
		Collections.sort(result);
		
		//result 리스트가 0이라면 조건 만족하는 경우가 없다는 소리이므로 -1출력한다
		if(result.size()==0) System.out.println(-1);
		
		//result 리스트가 0이 아닐 경우엔 result 값을 차례대로 출력한다
		if(result.size()!=0) {
			for(int i=0;i<result.size();i++) {
				System.out.print(result.get(i)+" ");
			}
		}
	}//main
	
	//백트래킹
	public static void dfs(int depth, int sum, int start) {
		//m마리의 소를 선택하여 몸무게의 합이 소수인지 판별한다
		if(depth==m) {
			//소수일 경우에 set에 값을 추가한다
			if(isPrime(sum)) set.add(sum);
			return;
		}
		// start부터 탐색하여 중복된 경우의 수를 제거한다
		for(int i=start;i<n;i++) {
			if(!visited[i]) {
				visited[i]=true;
				dfs(depth+1,sum+weight[i],i+1);
				visited[i]=false;
			}
		}
	}//dfs
	
	//에라토스테네스의 체로 소수인지 판별
	//sum을 num에다 넣어서 소수인지 판별하고, 소수이면 true 출력한다
	//sqrt는 제곱근 구하는 함수
	public static boolean isPrime(int num) {
		for(int i=2;i<Math.sqrt(num);i++) {
			if(num%i==0) {
				return false;
			}
		}
		return true;
	}

}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N;
	static int K;
	static int ans;
	static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        // 열려있는 2개를 open1,2 라는 변수로 선언
        int open1 = sc.nextInt();
        int open2 = sc.nextInt();

        ans = 987654321;
        
        K = sc.nextInt(); // 사용할 개수
        arr = new int[K]; 
        for(int i=0;i<K;i++) {
        	arr[i] = sc.nextInt();
        }
        // dfs를 통해서 몇개를 전진할지 생각해보자
                
        
        // 열려있는 문을 기준으로 
        // 현재 들어오는 수가 
        // 왼쪽으로 밀지 오른쪽으로 밀지
        // 모두 탐색해야 한다.(반례때매)
        solve(0,open1,open2,0);
        System.out.println(ans);
        
        
        
    }
    // idx가 K가 될때까지 계속 반복함
    // a와 b의 차이만큼 cnt를 ++하고 각자 dfs 돌리기
    public static void solve(int idx, int a, int b, int cnt) {
    	if(idx == K) {
    		// 만약 ans보다 cnt가 작다면 교체
    		ans = Math.min(ans, cnt);
    		return;
    	}
    	// 중간에 cnt가 어차피 ans보다 크면 그냥 return한다
    	if(cnt>ans) {
    		return;
    	}
    	
    	int tmp1 = Math.abs(a-arr[idx]); // 열려있는 문과 현재의 차이 
    	int tmp2 = Math.abs(b-arr[idx]);
    	// 2가지 모두 각각 dfs 돌려봄
    	solve(idx+1,arr[idx],b,cnt+tmp1);
    	solve(idx+1, a, arr[idx], cnt+tmp2);
    	
    }

}

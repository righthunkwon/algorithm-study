import java.io.*;
import java.util.*;
public class q1697 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		System.out.println(dfs(n,k));
	}
	static int dfs(int n,int k) {
		if(n>=k) return n-k; //n이 k보다 크면 n-k번만큼 1을 빼줘야하니 리턴
		if(k==1) return 1; //k가 1이면 1을 리턴
		if(k%2==1) return Math.min(dfs(n,k+1),dfs(n,k-1))+1; //*2로는 홀수가 불가능하니 k+1와 k-1의 최소값에 1을 더한값이 된다.
		return Math.min(k-n,dfs(n,k/2)+1); 
	}
}

import java.io.*;
import java.util.*;

public class BOJ_G4_2015_수들의_합4 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long ans = 0;//합 k되는 경우의 수
		
		int [] nu = new int[n+1]; //누적합 저장용 배열
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			nu[i]=Integer.parseInt(st.nextToken())+nu[i-1];
			if(nu[i]==k)ans++;//누적합이 k인 경우 카운트
		}
		
		HashMap<Integer,Integer> hm = new HashMap<>();
		
		
		//nu[a] - nu[b] = k 가 된다면 합이 a~b는 k인 부분집합이 됨 (b<a)
		//누적합을 돌면서 nu[i]-k 가 지금까지 몇개 나왔는지를 카운트해서 더해주면 됨! 
		for(int i=1;i<=n;i++) {
			if(hm.containsKey(nu[i]-k))ans+=hm.get(nu[i]-k);
			hm.put(nu[i],hm.getOrDefault(nu[i], 0)+1);
		}
		
		System.out.println(ans);
		
		
	}
}

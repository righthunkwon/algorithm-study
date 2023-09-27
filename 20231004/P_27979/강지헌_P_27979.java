import java.io.*;
import java.util.*;
public class q27979 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		List<Integer> S = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			S.add(arr[i]);
		}
		int ans=N;
		Collections.sort(S,Collections.reverseOrder()); //정렬
		for(int i=N-1;i>=0;i--) {
			if(S.get(0)==arr[i]) { //같은거찾기
				S.remove(0);
				ans--;
			}
		}
		System.out.println(ans);
	}
}

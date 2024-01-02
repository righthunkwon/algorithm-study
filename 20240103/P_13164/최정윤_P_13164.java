import java.io.*;
import java.util.*;

public class Pro_13164_행복유치원 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		int[] h=new int[N];
		for(int i=0;i<N;i++) {
			h[i]=Integer.parseInt(st.nextToken());
		}
		int[] diff=new int[N-1];//두 사람 키차이를 넣는 배열
		for(int i=0;i<N-1;i++) {
			diff[i]=h[i+1]-h[i];
		}
		Arrays.sort(diff);
		//이 중 가장 차이나는 K-1개를 선택해서 끊으면 됨
		int sum=0;
		for(int i=0;i<diff.length-(K-1);i++) {
			sum+=diff[i];
		}
		System.out.println(sum);
	}
}

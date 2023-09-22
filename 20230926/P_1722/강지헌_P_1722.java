import java.util.*;
import java.io.*;
public class q1722 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long[] P = new long[20];
		P[0]=1;
		for(int i=1;i<20;i++) P[i]=P[i-1]*i; //팩토리얼 저장
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		List<Integer> chk = new ArrayList<>();
		for(int i=1;i<=20;i++) chk.add(i); //1~20까지 리스트에 저장
		if(M==1) {
			long b = Long.parseLong(st.nextToken());
			b--;
			for(int i=N-1;i>=0;i--) {
				System.out.print(chk.get((int)(b/P[i]))+" "); //해당하는 숫자를 리스트에서 가져와서 출력하고 빼낸다
				chk.remove((int)(b/P[i]));
				b%=P[i];
			}
		}
		else {
			long ans=0;
			for(int i=N-1;i>=0;i--) {
				int t=Integer.parseInt(st.nextToken());
				for(int j=0;j<chk.size();j++) {
					if(chk.get(j)==t) {
						ans+=P[i]*j; //해당하는 숫자를 찾아서 그만큼의 수를 더하고 리스트에서 빼낸다
						chk.remove(j);
						break;
					}
				}
			}
			System.out.println(ans+1);
		}
	}
}

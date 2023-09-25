import java.io.*;
import java.util.*;
public class q9375 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int te=1;te<=T;te++) {
			int N=Integer.parseInt(br.readLine());
			HashMap<String, Integer> arr = new HashMap<>();
			for(int i=0;i<N;i++) {
				String[] in = br.readLine().split(" ");
				if(arr.containsKey(in[1])) arr.put(in[1], arr.get(in[1])+1); //hashmap에 추가
				else arr.put(in[1],1);
			}
			int ans=1;
			
			for(String i:arr.keySet()) ans*=(arr.get(i)+1); //의상 종류당 개수+1만큼 곱한다.
			System.out.println(ans-1); //아무것도 안입은 걸 하나 뺴면 정답
		}
	}
}

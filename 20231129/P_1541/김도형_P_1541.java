package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 마이너스 나오기 전까지는 더하고 마이너스 기호가 나온 뒤 숫자는 다 빼면 된다.. 
public class BOJ_Q1541_잃어버린_괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String str = st.nextToken();
		int N = str.length();
		char [] arr = new char[N];
		arr = str.toCharArray();
		
		int ans = 0;
		boolean flag = false;
		Queue<Character>plusq=new LinkedList<>();
		Queue<Character>minusq=new LinkedList<>();
		
		for(int i = 0;i<N;i++) {
			if(flag==false) {
				if(arr[i]!='-' && arr[i]!='+') {
					plusq.add(arr[i]);
				}else if(arr[i]=='+') {
					StringBuilder sb = new StringBuilder();
					while(!plusq.isEmpty()) {
						sb.append(plusq.poll());
					}
					int x = Integer.parseInt(sb.toString());
					ans+=x;
				}else if(arr[i]=='-') {
					StringBuilder sb = new StringBuilder();
					while(!plusq.isEmpty()) {
						sb.append(plusq.poll());
					}
					int x = Integer.parseInt(sb.toString());
					ans+=x;
					flag=true;
				}
			}else if(flag ==true) {
				if(arr[i]!='-' && arr[i]!='+') {
					minusq.add(arr[i]);
				}else if(arr[i]=='-' || arr[i]=='+') {
					StringBuilder sb = new StringBuilder();
					while(!minusq.isEmpty()) {
						sb.append(minusq.poll());
					}
					int x = Integer.parseInt(sb.toString());
					ans-=x;
				}
			}
		}
		
		if(flag) {
			StringBuilder sb = new StringBuilder();
			while(!minusq.isEmpty()) {
				sb.append(minusq.poll());
			}
			int x = Integer.parseInt(sb.toString());
			ans-=x;
		}else {
			StringBuilder sb = new StringBuilder();
			while(!plusq.isEmpty()) {
				sb.append(plusq.poll());
			}
			int x = Integer.parseInt(sb.toString());
			ans+=x;
		}
		
		
		System.out.println(ans);
		
	}//main
}

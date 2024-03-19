package _20240320;

import java.util.*;
import java.io.*;

public class _6198_옥상정원꾸미기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s = new Stack<>();
		long ans = 0;
		for(int i=0;i<N;i++) {
			int a = Integer.parseInt(br.readLine());
			
			// 그 전에 있는 건물 중에 새로 추가되는 건물보다 작거나 같은게 있으면 stack에서 제거
			// stack 가장 위에 있는 애보다 작은 건물은 이미 그 전에 stack에서 빠졌으므로 맨 위만 비교하면 된다
			while(!s.isEmpty() && s.peek()<=a) {
				s.pop();
			}
			// 조건 통과된 애들만 ans에 추가한다
			ans +=s.size();
			// a도 stack에 추가해준다
			s.add(a);
		}
		System.out.println(ans);
	}//main

}

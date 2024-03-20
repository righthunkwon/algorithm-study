package study_240320;

import java.io.*;
import java.util.*;

public class Pro_6198_옥상정원꾸미기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> s=new Stack<>();
		long ans = 0;
		int h;
		for (int i = 0; i < N; i++) {
			h = Integer.parseInt(br.readLine());
			while(!s.isEmpty()&&s.peek()<=h) {//나를 못보는 애들 다 빼!
				s.pop();
			}
			ans+=s.size(); //나를 볼 수 있는 건물 수 더하기
			s.push(h);
		}
		System.out.println(ans);
	}
}

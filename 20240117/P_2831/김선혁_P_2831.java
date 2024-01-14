import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class Main {
	static int N;
	static ArrayList<Integer>[] m = new ArrayList[2];
	static ArrayList<Integer>[] w = new ArrayList[2];
	static int ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		// 어차피 키만 저장하면 되니깐
		// 리스트를 2종류씩 만들어
		// 양수는 첫번쨰 
		// 음수는 두번쨰에 저장 (첫번째는 자신보다 키큰사람)
		for(int i = 0;i<2;i++) {
			m[i] = new ArrayList<Integer>();
			w[i] = new ArrayList<>();
		}
		// 일단 2개 배엶모두 초기화 완료
		// 남자먼저
		for(int i =0;i<N;i++) {
			int tmp = sc.nextInt();
			if(tmp>0) {
				m[1].add(tmp);
			}
			else {
				m[0].add(tmp*-1);
			}
			// 음수는 -1 곱해서 입력
		}
		// 같은 방법으로 여자키 입력
		for(int i =0;i<N;i++) {
			int tmp = sc.nextInt();
			if(tmp>0) {
				w[0].add(tmp);
			}
			else {
				w[1].add(tmp*-1);
			}
			// 음수는 -1 곱해서 입력
		}
		// 이제 각 배열에서 정렬을 하고 
		// 하나씩 찝어서 이루어지면 ans++하자
		for(int i = 0;i<2;i++) {
			Collections.sort(m[i]);
			Collections.sort(w[i]);
		}
		 ans = 0;
		// 일단 같은키는 안되니깐 2가지 경우 나눠야함
		// 1. 남자가 크고 여자가 작은경우
		// 2. 여자가 크고 남자가 작은경우
		
		// 1번부터 메서드 만들어보자
		for(int  i =0;i<2;i++) {
			solve(i);
		}
		System.out.println(ans);
	}
	public static void solve(int cnt) {
		// 0이들어오면 남자가 큰경우
		// 여자는 작은경우 (위에서 바꿔서 입력받음)
		int i =0;
		int j =0;
		while(true) {
			// 일단 i랑 j로 해서 
			// 각각 cnt번쨰의 리스트보다 작아야함
			if(i==m[cnt].size() || j == w[cnt].size()) {
				// 둘중 하나라도 끝까지 가면 break
				break;
			}
			int a=0;
			int b= 0;
			// 이제 키가 큰사람과 작은사람을 연결해보자
			// a가 큰사람
			if(cnt==0) {
				// 남자가 큰경우
				a = m[cnt].get(i);
				b = w[cnt].get(j);
			}
			else {
				// 여자가 큰경우
				b = m[cnt].get(i);
				a= w[cnt].get(j);
			}
			// 큰사람과 작은사람을 비교해서
			// 만약 작은사람이 크다면 
			// 큰쪽의 index를 증가 시키고
			// 아니면 ans를 +1해주고 둘다 +1
			if(a<=b) {
				if(cnt==0) {
					i++;
				}
				else {
					j++;
				}
				// 0이면 남자가 +1, 아니면 j+1
				continue;
			}
			// 여기는 ans+1 
			ans++;
			i++;
			j++;
			// 다시 while문 돌기
		}
		
		
	}

}

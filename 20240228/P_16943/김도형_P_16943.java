package algo_study;

import java.util.Scanner;

public class BOJ_Q16943_숫자_재배치 {

	static int A, B,L;
	static int arr[];
	static boolean used[];
	static int max = -1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		A = sc.nextInt();
		B = sc.nextInt();
		String stA = String.valueOf(A); // 문자열로 바꾼 A
		L = stA.length();
		arr = new int[L];
		used = new boolean[L]; // 쓴거 check
		for (int i = 0; i < L; i++) {
			arr[i] = stA.charAt(i) - '0';
		}
		perm(0,0);
		System.out.println(max);
	}// main
  
	public static void perm(int value,int depth) {
		//기저
		if(depth==L) {
			max = Math.max(max, value);
			return;
		}
		
		//재귀
		for(int i=0;i<L;i++) {
			//썼거나 맨앞자리 0되는거 버려
			if(used[i]||(depth==0 && arr[i]==0))continue;
			if(value*10+arr[i]>=B)continue;
			used[i]=true;
			perm(value*10+arr[i],depth+1);
			used[i]=false;
		}
	}
}// class


=================================================================================================


  
이거 맞 왜 틀 ?????

package algo_study;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q16943_숫자_재배치_반례찾기실패 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int D = sc.nextInt();
		String A = String.valueOf(C);
		String B = String.valueOf(D); //입력으로 앞에 0 들어오는 경우 
		
		int L = A.length();
		int [] arr = new int[L]; 
		boolean[]used = new boolean[L]; //쓴거 check
		for(int i = 0 ; i<L;i++) {
			arr[i]=A.charAt(i)-'0';
		}
		Arrays.sort(arr); //오름차순 정렬

		
		if(L>B.length()) {
			System.out.println(-1);
			return;
		}
		if(L<B.length()) {
			for(int i=L-1;i>=0;i--) {
				System.out.print(arr[i]);
			}
			return;
		}

		StringBuilder answer = new StringBuilder();
		boolean ispossible = false;
		StringBuilder tmp = new StringBuilder();
		boolean []tmpUsed = new boolean [L];
		int idxx = 0;
		for(int i=0;i<L;i++) {
			if(arr[i]!=0) {
				idxx=i;
				tmp.append(arr[idxx]);
				tmpUsed[idxx]=true;
				break;
			}
		}
		
		for(int i=0;i<L;i++) {
			if(!tmpUsed[i])tmp.append(arr[i]);
		}
		if(Integer.parseInt(tmp.toString())<Integer.parseInt(B)) {
			ispossible=true;
		}else {
			System.out.println(-1);
			return;
		}
		
		//길이가 동일한 경우
		if(L==B.length()) {
			if(arr[0]>B.charAt(0)-'0') { //A가 B보다 작을 수 없는 경우
				System.out.println(-1);
				return;
			}
			boolean []tmpbool = new boolean[L];//@@@@@@@@@@@@@@@@@여기 확인중
			for(int i=0;i<L;i++) { //b인덱스
				z:for(int j=L-1;j>=0;j--) { //a 배열 인덱스
					if(used[j])continue; //이미 쓴거 패쓰
					if(B.charAt(i)-'0'>arr[j]) { //A보다 B가 무조건 큰 경우
						used[j]=true;
						answer.append(arr[j]);
						for(int k=L-1;k>=0;k--) {
							if(!used[k])answer.append(arr[k]); //사용안했던것들 다 합쳐
						}
						System.out.println(answer.toString());
						return;
					}else if(B.charAt(i)-'0'==arr[j]) { //뒷자리 더 봐야..(뒷자리 나머지 최소 vs B뒷자리)=> B가 클 수 없으면 -1출력
						StringBuilder sbA = new StringBuilder();//임시용
						
						sbA.append(answer.toString());
						sbA.append(arr[j]);
						tmpbool[j]=true;
						for(int k=0;k<L;k++) {
							if(!tmpbool[k] && k!=j )sbA.append(arr[k]); //사용안했던것들 작은거부터 다 합쳐
						}
						if(Integer.parseInt(sbA.toString())>=Integer.parseInt(B)) { 
							if(!ispossible) { //불가능한 상태 판단 완료
								System.out.println(-1);
								return;
							}else { //현재 arr[j]보다 작은 수를 이자리에 넣고, 나머지 큰 순서대로 넣어서 출력하기
								int idx = j;
								while(arr[idx]==arr[j] || used[idx]) {
									idx--;
								}
								used[idx]=true;
								answer.append(arr[idx]);
								for(int k=L-1;k>=0;k--) {
									if(!used[k])answer.append(arr[k]); //사용안했던것들 다 합쳐
								}
								System.out.println(answer.toString());
								return;
							}
						}
						
						//B보다 작은수 만들 수 있으면 => 
						else { //
							used[j]=true;
							answer.append(arr[j]);
							ispossible = true; //-1은 출력하지 않도록
							break z;
						}
					}else if(B.charAt(i)-'0'<arr[j]) { 
						continue;
					}
				}//for j
			}//for i
			System.out.println(answer.toString());
		}
	}//main
}//class

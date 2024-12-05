import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_Q20442_ㅋㅋ루ㅋㅋ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int totalR = 0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='R')totalR++; //R의 개수 카운트
		}
		//R이 하나도 없는 경우 예외처리
		if(totalR==0) {
			System.out.println(0);
			return;
		}
		
		int ans = totalR; //일단 R개수로 최소 ㅋㅋ루ㅋㅋ 문자열 길이 초기화
		int l = 0, r = s.length()-1;
		int lCnt = 0, rCnt = 0; //왼쪽 오른쪽 포인터 각각 다음 R이 나올때까지 K개수 카운트
		
		//투포인터 
    //K가 한쌍을 이뤄야 ㅋㅋ루ㅋㅋ 문자열에 포함될 수있으니까  
    //두 포인터가 한칸씩 이동하면서 각각의 K의 개수 카운트해서 적은쪽 포인터를 당겨줌
		while(l<=r) {
			if(lCnt<=rCnt) {
				if(s.charAt(l)=='R') {
					ans=Math.max(ans, Math.min(lCnt,rCnt)*2 + totalR);
					l++;
					totalR--;
				}else {
					l++;
					lCnt++;
				}
			}else {
				if(s.charAt(r)=='R') {
					ans=Math.max(ans, Math.min(lCnt, rCnt)*2 + totalR);
					r--;
					totalR--;
				}else {
					r--;
					rCnt++;
				}
			}
		}
		System.out.println(ans);
	}
}

package AlgoStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_S1_3107_IPv6 {

	public static void main(String[] args) throws IOException {
		/*
		 * 1. "::"가 문자열에 포함되어 있는지 확인
		 * 2. 있을경우 :: 앞뒤에 ':' 개수를 카운트하고 5개에서 부족한 개수 만큼 ':'추가
		 * 3.  ':'로 쪼개서 각 문자열의 길이가 4보다 작을 경우 부족한만큼 앞에 0으로 채움
		 * */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		//맨 뒤에 :가 붙는 경우 예외처리
		if(str.charAt(str.length()-1)==':') {
			int cnt = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==':')cnt++;
			}
			if(cnt>7) {
				str = str.replace("::", ":0000");
			}else {
				str = str.replace("::", "::0000");
			}
		}
		
		//맨 앞에 :가 붙는 경우 예외처리
		if(str.charAt(0)==':') {
			int cnt = 0;
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)==':')cnt++;
			}
			if(cnt>7) {
				str = str.replace("::", "0000:");
			}else {
				str = str.replace("::", "0000::");
			}
		}		
		
		
		
		// "::" 가 문자열에 포함되어 있을 경우 처리
		if(str.contains("::")) {
			int cnt = 7; // 부족한 ':'의 갯수
			for(int i = 0;i<str.length();i++) {
				if(str.charAt(i)==':')cnt--;
			}
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<cnt;i++)sb.append(":");
			String mid = sb.toString();
			int idx = str.indexOf("::");
			String l = str.substring(0, idx);
			String r = str.substring(idx,str.length());
			sb = new StringBuilder();
			sb.append(l).append(mid).append(r);
			str = sb.toString();
		}
		
		String [] arr = str.split(":");
		for(int i=0;i<arr.length;i++) {
			if(arr[i].length()==4)continue;
			int cnt = 4 - arr[i].length(); //부족한 0의 개수
			StringBuilder sb = new StringBuilder();
			for(int j=0;j<cnt;j++)sb.append("0");
			sb.append(arr[i]);
			arr[i]=sb.toString();
		}
		
		//양식에 맞게 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<7;i++)sb.append(arr[i]).append(":");
		sb.append(arr[7]);
		System.out.println(sb.toString());
		
		
	}

}

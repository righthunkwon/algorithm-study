import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String [] arr = new String[n];
		for(int i=0;i<n;i++)arr[i]=br.readLine();
		
		HashSet<Character>set = new HashSet<>();
		for(int i=0;i<n;i++) {
			boolean flag = true; //단어 첫글자여부
			boolean complete = false; //단축키 추가 성공 여부
			l:for(int j=0;j<arr[i].length();j++) {
				if(flag) { //첫글자면
					if(!set.contains(arr[i].charAt(j))) { //단축키에 추가된적 없는 글자면 단축키 지정
						set.add(Character.toLowerCase(arr[i].charAt(j)));
						set.add(Character.toUpperCase(arr[i].charAt(j))); //대소문자 다 추가
						arr[i] = arr[i].substring(0,j)+"["+arr[i].charAt(j)+"]"+arr[i].substring(j+1,arr[i].length());
						System.out.println(arr[i]);
						complete = true;
						break l;
					}else {
						flag = false;
					}
				}else if(arr[i].charAt(j)==' ') {//공백이면 다음글자는 단어의 첫글자
					flag=true;
				}
			}
			
			if(!complete) { //단어 첫글자로 단축키 추가 못했을 경우 전체탐색
				for(int j=0;j<arr[i].length();j++) {
					if(arr[i].charAt(j)==' ')continue; //공백이나 이미 단축키 추가된 글자 건너뛰기
					if(set.contains(arr[i].charAt(j)))continue;
					set.add(Character.toLowerCase(arr[i].charAt(j)));
					set.add(Character.toUpperCase(arr[i].charAt(j))); //대소문자 다 추가
					arr[i] = arr[i].substring(0,j)+"["+arr[i].charAt(j)+"]"+arr[i].substring(j+1,arr[i].length());
					break;
				}
				System.out.println(arr[i]); //단축키 추개했든 안했든 최종출력
			}
		}
	}
}

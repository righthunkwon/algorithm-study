import java.util.Scanner;

public class BOJ_G4_2661_좋은수열 {
	static int n ;
	static boolean flag;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		perm("");
	}
	
	//숫자 조합하는 메서드
	static void perm(String str) {
		if(flag == true)return; //이미 정답 찾았으면 끝내기
		
		if(str.length()==n) { //길이 n이 된 최초의 문자열이 가장 작은 좋은 문자열
			System.out.println(str);
			flag = true; 
			return;
		}
		
		for(int i=1;i<=3;i++) {
			if(isGood(str+i)) { //i를 뒤에 붙인 문자열이 좋은 문자열일 경우
				perm(str+i);
			}
		}
		
	}
	
	//str이 좋은 문자열인지 확인하는 메서드
	//기존 좋은수열에 숫자 하나가 붙은게 좋은문자열인지 확인하는거니까 
	//새로 추가된 숫자를 포함하는 길이가 '1 ~ 문자열의 절반길이'인 부분 수열을 대칭되는 부분과 비교하면 됨
	static boolean isGood(String str) {
		for(int i=1;i<=str.length()/2;i++) {
			String a = str.substring(str.length()-i , str.length()); //새로추가된 숫자 포함한 부분
			String b = str.substring(str.length()-i*2,str.length()-i); //대칭인 부분
			if(a.equals(b))return false;
		}
		return true;
	}

}

package AlgoStudy;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_Q1759_암호_만들기{
	
	static int L;
	static String[] arr;
	
	public static void main(String[] args){
		
		Scanner sc=new Scanner(System.in);
		
		L=sc.nextInt(); // 암호 길이 L (서로 다른 알파벳 소문자들로 구성)
		int C=sc.nextInt(); // 주어질 문자의 수
		
		arr = new String[C];
		
		for(int i=0; i<C; i++){
			arr[i]=sc.next();  //알파벳 입력받기
		}
		
		Arrays.sort(arr);  //알파벳 오름차순 정렬
		
		recur("", 0);
	}
	
	
    static boolean check(String password){
    	//자음 모음 수 조건 만족하는지 체크하는 메소드
        int jaem=0;
        int moem=0;
        for(char x: password.toCharArray()){
            if (x=='a'||x=='e'||x=='i'||x=='o'||x=='u'){ //모음 수 카운트
                moem+=1;
            }else{
                jaem+=1;  //자음 수 카운트
            }
        }
        
        //자음이 2개이상, 모음이 1개 이상이면 true
        if(jaem>=2&&moem>=1)
        	return true;
        else
        	return false;
    }
    
    /*
     * password : 지금까지 만들어진 암호
     * i : 현재 알파벳의 인덱스
     * 
     */
    static void recur(String password, int i){
    	
    	//기저파트
    	//정답 찾은 경우
        if (password.length()==L){ //n번 인덱스까지 까지 무사히 왔으면
        	
            if (check(password)){ //자모음 조건 체크해보고 가능하면 출력
                System.out.println(password);
            }
            return;
        }
        
        //불가능한 겨우
        if (i >= arr.length) return;
        
        
        //재귀파트
        recur(password+arr[i], i+1); //i번째 알파벳 쓴 경우
        recur(password, i+1); //i번쨰 알파벳 안쓴 경우
       
    }
   
}

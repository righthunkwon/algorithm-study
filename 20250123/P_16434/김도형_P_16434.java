import java.io.*;
import java.util.*;

public class BOJ_G4_16434_드래곤_앤_던전 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //방의 개수
		long power = Long.parseLong(st.nextToken()); //초기 공격력
		
		//받는 최대의 데미지를 계산하고, 그거보다 1만 높으면 드래곤 처치 가능
		
		long nowDam = 0; //현재 피해량
		long maxDam = 0; //최대로 받은 피해량
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); //1:몬스터 / 2:포션
			int a = Integer.parseInt(st.nextToken()); //몬스터 공격력 or 용사 공격력 증가량
			int h = Integer.parseInt(st.nextToken()); //몬스터 체력 or 용사 체력 회복량
			
			if(t==1) { //몬스터면
				nowDam += a*((h/power)-(h%power==0?1:0)); //(전사공격횟수-1)번 데미지를 입음
				maxDam = Math.max(nowDam, maxDam); //최대피해량 갱신
			}else { //포션이면
				power+=a; //용사 공격력 증가
				nowDam = Math.max(nowDam-h, 0); //힐해도 최대체력 이상 안차니까 최소 0
			}
		}
		
		System.out.println(maxDam+1);

	}//main

}

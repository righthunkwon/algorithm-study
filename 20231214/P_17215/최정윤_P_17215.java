package baek;

import java.io.*;
// 구한 방법 : 
//1)세트별 계산 (10세트까지) while한번에 공 2개 점수 계산을 넣어놓음
//  -첫번째 공 점수 계산 후 두번째 공 점수 계산 (S라면 바로 다음 세트로 가게 )
//  -전에 P나 S가 있는지 확인 후 있다면 2배해주는 식으로 함 
//2)보너스판 있다면 계산
public class Pro_17215_볼링점수계산 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] score = br.readLine().toCharArray();
		int cnt = 0; 
		int setCnt = 0; //세트
		int total = 0; //점수
		boolean P = false; //전판에 스페어였나
		boolean S = false; //전판에 스트라이크였나
		int SCnt = 0; //연속스트라이크 개수(더블스트라이크 이상인지 체크)
		a: while (setCnt < 10) {
			setCnt++;
			int set = 0;//숫자라면 세트점수 구해야함 바로 total에 더하면 안됨 뒤에 P일 수 있으므로 
			
			// 첫번째 공 점수 계산
			
			switch (score[cnt]) {
			case 'S':
				if (SCnt >= 2) { //전까지 더블스트라이크이상이라면 이 점수도 가져가게 된다.SSS라면 30점,  
					total += 10;
				}
				if (P || S) {
					total += 20;
					P = false;
				} else {
					total += 10;
				}
				S = true;
				cnt++;
				SCnt++; //연속스트라이크 수 증가
				continue a; //두번쨰 공 볼 필요 없다. 
			case '-':
				if (P)
					P = false;
				SCnt = 0;
				break;
			default://숫자라면
				if (P) {
					total += score[cnt] - '0'; //P처리의 보너스점수는 바로 total에 더해주고
					set += score[cnt] - '0';   //set점수는 모르니까 일단 저장해놓기
					P = false;
				} else {
					set += score[cnt] - '0';
				}

				if (SCnt >= 2) {//(S S 72)라면 첫번째 S가 7점도 가져가는 것 의미
					total += set;
				}
				SCnt = 0;
				break;
			}

			cnt++;
			
			// 두번쨰 공 점수계산
			
			switch (score[cnt]) {
			case 'P':
				set = 10; //전에 세트점수가 몇이던 10으로 설정
				P = true;
				break;
			case '-':
				break;
			default:
				set += score[cnt] - '0';
				break;
			}
			cnt++;
			if (S) //전판에 S라면 세트 점수 2배
				total += 2 * set;
			else { //아니라면 그냥 더해주기
				total += set;
			}
			S = false;
		}
		

		
		//보너스판있다면 점수계산
		int lastSet = 0;
		int bonusCnt=0;
		
		while (cnt < score.length) {
			bonusCnt++;
			switch (score[cnt]) {
			case 'S':
				if (bonusCnt==1&&SCnt >= 2) {
					total += 10;
				}
					total += 10;
				break;
			case 'P':
					lastSet = 10;
				break;
			case '-' :
				break;
			default:
				if (bonusCnt==1&&SCnt >= 2) {
					total += score[cnt] - '0';
				}
				lastSet += score[cnt] - '0';
				break;
			}
			cnt++;
		}
		total += lastSet;

		System.out.println(total);
	}
}

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int frame = 0; // 프레임
		int[] flag = new int[10]; // 0이면 아직 x, 1이면 그냥 , 2이면 스페어, 3이면 스트라이크
		int score = 0; // 점수
		boolean tmp = false; // 첫번쨰인지 두번째 시도인지 알기위한 tmp
		int first = 0;
		ArrayList<String> ar = new ArrayList<String>();
		String input = sc.next();
		for(int i =0;i<input.length();i++) {
			ar.add(input.substring(i,i+1));
		}
		int index = 0;
//		for(int i =0;i<ar.size();i++) {
//			System.out.print(ar.get(i));
//		}
		while(true) {
			if(frame ==10) {
				break;
			}
			String a = ar.get(index++);
			if(a.equals("-")) {
				// 처음칠 때
				if(!tmp) {
					tmp = true;
				}
				// 두번째시도일때 
				else {
					flag[frame] = 1;
					score += first;
					first = 0;
					frame ++;
					tmp = false;
				}
			}
			else if(a.equals("S")) {
				// 스트라이크면 10점 플러스하고 
				// 전과 이전이 스트라이크인지 판단
				// 전이 스트라이크 일경우  이전이 스트라이크인지 판단
				score+=10;
				if(frame>=1){
					// 스페어일 경우
					if(flag[frame-1] == 2) {
						score +=10;
					}
					// 전에게 스트라이크면
					else if(flag[frame-1] ==3) {
						if(frame>=2 && flag[frame-2] ==3) {
							score +=10;
						}
						score +=10;
					}
				}
				// 3을 기록하고 frame+1
				flag[frame] = 3;
				frame ++;
			}
			else if(a.equals("P")) {
				// 전에게 스트라이크 일경우 
				if(frame>=1 && flag[frame-1] ==3) {
					score +=10-first;
				}
				score += 10;
				first = 0;
				tmp = false; // false로 바꾸고 2 기록, 10 +
				flag[frame] = 2;
				frame ++;
			}
			// 숫자일때 
			else {
				if(!tmp) {
					first = Integer.parseInt(a);
					// 만약 스페어나 스트라이크면 first만큼 플러스
					if(frame>=1) {
						if(flag[frame-1]== 2) {
							score+= first;
						}
						else if(flag[frame-1] ==3) {
							if(frame >=2 && flag[frame-2] ==3) {
								score+= first;
							}
							score += first;
						}
					}
					tmp = true;
				}
				else {
					score += Integer.parseInt(a) + first; // 전거와 이번거 점수를 플러스
					flag[frame] = 1;
					tmp = false;
					first = 0;
					frame++;
				}
			}
//			System.out.println(score+" "+a +" ");
					
			
		} 
		// 이과정이 끝나면 10프레임 2번째까지 끝 
		// 만약 10프레임 3번째에 칠 기회가 있는경우도 생각해야함
		// 1. -  2. S  3. 점수
		if(flag[9] == 2) {
			String a = ar.get(index);
			if(a.equals("S")) {
				score +=10;
			}
			else if(a.equals("-")) {
				
			}
			else {
				score += Integer.parseInt(a);
			}
		}
		else if(flag[9] ==3) {
			String a = ar.get(index++);
			if(a.equals("S")) {
				if(flag[8] ==3) {
					score += 10;
				}
				score +=10;
			}
			else if(a.equals("-")) {
				
			}
			else {
				first = Integer.parseInt(a);
				score += first;
				if(flag[7] == 3) {
					score+= first;
				}
			}	
			///////////////////////////////////////
			// 2번째 기회
			a = ar.get(index);
			if(a.equals("-")) {
				
			}
			else if(a.equals("P")) {
				score += 10-first;
			}
			else {
				score+= Integer.parseInt(a);
			}
			
		}
		System.out.println(score);
		
		
		
	}

}

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
	// 국회의원 선거         실버 5
	// 다솜이가 1번후보로 당선되기 위해 
	// 몇명의 투표 조작을 가담해야 하나 
	// 최소값 구하기 --> 일단 가장 큰 숫자를 구해서
	// 그수를 -1해주고 다솜이 투표수 +1 
	// 이것을 반복해서 다솜이 투표수가 가장 클때까지 돌리고 그 회수를 출력	
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt(); // 국회의원 수
	int[] arr = new int[N]; // N명만큼의 배열생성
	for(int i = 0;i<N;i++) {
		arr[i] = sc.nextInt(); // 입력완료
	}
	
	// 0번째 배열= 다솜이가 가장 큰 값이 될때까지 
	int cnt =0;
	while(true) {
		int max = 0;// 배열 내에서의 최대 값 
		int maxi = 0;// 배열 내에서의 최대 index 
		for(int i =0;i<N;i++) {
			if(max<=arr[i]) {
				// 투표수가 같은 경우에도 조정해줘야 하기 때문에
				// 같을 경우 조정하기 위해 부등호 넣음
				max = arr[i];
				maxi = i; // 최대값과 최대 i를 교체한다.
			}						
		}
		if(maxi ==0) {
			break;
		}
		// 최대 index가 0이면 break해주고
		// 그게 아니라면 값 조정 
		arr[0] +=1;
		arr[maxi] -=1;
		cnt++;
		// 값 조정하고 cnt는 +1
	}
	System.out.println(cnt);
	
	
	
	
}	

}

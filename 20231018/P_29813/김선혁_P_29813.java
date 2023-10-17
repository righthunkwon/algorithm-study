import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 29813 	최애의팀원 	 실버3
		// 팀원 고르는문제 -> 나머지 한명의 정답
		// N을 입력받고 N개 만큼의 알파벳과 숫자를 입력받는다.
		
		// 첫번째부터 시작하는데 줄 선 상태로 
		// 그 사람뒤로 해당 숫자만큼 번째 있는 사람이
		// 첫번째 사람과 파트너 
		// 이러한 과정을 쭉 거친 후에 혼자 남는 사람이 누구인지 확인
		Scanner sc = new Scanner(System.in);
		int N  =sc.nextInt();
		String[] arr = new String[N+1]; // 알파벳저장
		int[] num = new int[N+1]; // 향하고있는 숫자 따로 저장
		
		for(int i =1;i<=N;i++) {
			// 각각 arr과 num에 입력을 받음
			arr[i] = sc.next();
			num[i] = sc.nextInt();
		}
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i =1;i<=N;i++) {
			q.add(i);
			//1부터 N까지 쭉 큐에다가 넣는다.
		}
		// 입력 끝
		
		int ans = -1; // 정답
		int index = 1; // 시작 index는 1부터
		while(true) {
			// 현재 존재하는 사람은 고르는 사람으로 
			// 그 사람 뒤부터 count해야하기 때문에 
			// 고르는사람 한명을 빼고 시작한다.
			index = q.poll(); // 지금 뺴는 사람은 현재 이제 파트너를 고를 사람 
			if(q.size()==0) {
				// 만약 혼자남은상태에서 위에서 빠지게 되어
				// q가 사이즈가 0이되게 되면 
				// 고르는사람이 한양이와 파트너이므로 
				// ans를 갱신
				ans = index;
				break;
			}
			
			for(int i =0;i<num[index]-1;i++) {
				q.add(q.poll()); // index가 가리키는
				// 숫자만큼 큐에서 뺴고 큐에 넣는 과정을 진행
				// -1한 이유는 해당번쨰에 있는 사람은
				// 현재 고르는 사람의 파트너로 
				// add되면 안되기때문에 밑에서 따로 poll진행해줌
			}
			q.poll(); // 현재 index번째에 있는 사람의 파트너를 뺴줌
		} // while문
		System.out.println(arr[ans]);

	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _1417_국회의원선거 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());//후보의 수 N
		
		// 배열에 각 후보를 찍으려는 사람의 수를 저장한다.
		// 다솜이는 기호 1번이기에 다솜이를 찍으려는 사람은 0번째에 저장된다.
		int arr[] = new int [N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		// ans를 기본 0으로 두어 이미 당선이 확실할 때엔 별도의 조정이 필요하지 않으므로 0이 출력되도록 한다
		
		int max = -1, idx = -1, ans = 0;
		
		for(int i=1;i<N;i++) {
			if(arr[i] > max) {
				max = arr[i];
				idx = i;
			}
		}
		
		// arr[0]이 전체 배열에서 최대가 아닐때 while문을 돌린다
		// while문을 돌릴 때마다 다솜이 보다 득표수가 많은 사람의 표를 다솜이가 하나씩 가져온다
		// 그리고 이 때 ans값을 하나씩 늘려 다솜이가 몇 명의 사람을 매수하는지 카운트한다
		// 다솜이가 배열에서 가장 큰 값이 되면 while문이 종료된다
		
		while(arr[0] <= max) {
			arr[0] = arr[0] + 1;
			arr[idx] = arr[idx] - 1;
			ans++;
			max = -1;
			
			for(int i=1;i<N;i++) {
				if(arr[i] > max) {
					max = arr[i];
					idx = i;
				}
			}
			
		}//while
		
		System.out.println(ans);
		
		
		
	}//main
}

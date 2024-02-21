package _20240221;

import java.util.*;
import java.io.*;

public class _14426_접두사찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// words 배열에 N개의 문자열을 하나씩 통째로 넣어둔다
        String[] words = new String[N];
        for (int i=0;i<N;i++) {
            words[i] = br.readLine();
        }
        
        // 사전순으로 정렬한다
        Arrays.sort(words);

        int cnt = 0;
        for (int i=0;i<M;i++) {
        	
        	// 입력받은 값을 가지고 그때 그때 접두사가 맞는지 확인해준다
            String prefix = br.readLine();
            
            // 이분탐색을 이용해서 접두사인지 확인한다
            
            // 적어도 하나의 접두사인지 여부를 파악하는 거니까
            // 하나라도 true이면 개수 세어주면 된다
            if (binarySearchPrefix(words,prefix)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

	// 원래 풀었던 방식이 시간초과라 검색해서 풀었음 ㅎㅅㅎ
	
    private static boolean binarySearchPrefix(String[] words, String prefix) {
        int low = 0;
        int high = words.length -1;
        
        // 접두사는 다음과 같은 조건을 무조건 만족해야 한다.
        
        // 1. 비교하려는 단어의 맨 앞글자가 접두사의 맨 앞글자로 시작해야 한다
        // 2. 단어 앞부분이 접두사이어야 한다
        
        // 앞서 words배열을 사전순으로 정렬해놨기 때문에
        // 이분탐색으로 배열의 중간부터 비교를 해줄 경우 앞글자만 가지고 1번 조건을 만족하는 위치로
        // 빠르게 이동이 가능하다
        
        // prefix와 비교한 값이 0보다 작은지 아닌지를 토대로 앞, 뒤 단어로 이동한다
        // 이러한 방식으로 최소한으로 배열을 돌면서 접두사를 포함하는 단어 개수를 센다
        
        while (low <= high) {
        	
            int mid = low + (high-low)/2;
            
            // 접두사로 시작할 경우 true를 반환해주는 함수를 이용한다
            if (words[mid].startsWith(prefix)) {
                return true;
            }
            // 아닐 경우 접두사와 비교를 해서
            // 음수일 경우 low를 한칸 이동하고,
            // 양수일 경우 high를 한칸 이동한다
            else if (words[mid].compareTo(prefix) < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        // 다 돌아도 없을 경우 false값 반환한다
        return false;
    }
}

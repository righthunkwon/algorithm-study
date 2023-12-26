import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	 static ArrayList<Integer>[] arr;
	    static int n;
	    static int[] ans;
	    static int[] first;
	    static int[] time;
	    
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        n = sc.nextInt();
	        arr = new ArrayList[n+1];
	        time = new int[n+1];
	        first = new int[n+1];
	        // 각각 걸리는 시간과 
	        // 선행으로 필요한 것들도 선언
	         for(int i = 1; i <= n; i++) {
	            arr[i] = new ArrayList<>();
	            time[i] = sc.nextInt();
	            first[i] = sc.nextInt();
	            // first의 개수만큼이 선행되어야 하므로
	            // for문을 통해서 arr에 추가
	            ans = new int[n+1]; // ans는 모든 작업 시간 저장	           
	            for(int j = 0; j < first[i]; j++) {
	                arr[sc.nextInt()].add(i);
	            }
	        }
	        
	        // 일단 먼저 큐에있는 시작점을 기준으로
	        // 뻗어있는 곳 모두 작업
	        // 작업 과정중에 그 점이 선행할것이 더 없다면
	        // 그때 큐에 추가	        
	        solve();
	        int result = 0;
	        for(int i = 1; i <= n; i++) {
	            result = Math.max(result, ans[i]);
	        }
	        System.out.println(result);
	    }
	    
	    public static void solve() {	
	    	 Queue<Integer> q = new LinkedList<>();
	         for(int i = 1; i <= n; i++) {
	             if(first[i] == 0) {
	            	 // 먼저 가장 먼저 실행될 곳 찾아서
	            	 // 큐에다가 추가
	                 q.add(i);
	                 ans[i] = time[i];
	             }
	         }
	        while(!q.isEmpty()) {
	        	// 큐에서 하나씩 꺼내서
	        	// 다음으로 이어지는 곳으로 이동
	            int tmp = q.poll();
	            for(int i = 0; i < arr[tmp].size(); i++) {
	                int next = arr[tmp].get(i);
	                // 선행되어야 하는곳 모두 한 후에 
	                // 개수가 0이 되면 추가가능
	                ans[next] = Math.max(ans[tmp] + time[next], ans[next]);
	                first[next]--;
	                if(first[next] == 0) {
	                	q.add(next);
	                }
	            }
	        }
	    }
	}    

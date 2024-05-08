class Solution {
    static String[] animal = {"A","C","F","J","M","N","R","T"};
    static int ans;
    static boolean flag[];
    static String arr[];
    static int N;
    static String[] datas;
    public int solution(int n, String[] data) {
        datas = data; //
        arr = new String[animal.length]; // 배치하는 배열
        // 각자 경우의 수 하나씩 배치해서 경우의 수 구해서 x2?
        // 모든 경우의 수 구해서 만족하는지 확인? bf
        flag = new boolean[animal.length]; // 방문 확인
        ans = 0; // 정답
        N = animal.length;
        solve(0);
        return ans;
    }
    // dfs로 완탐 ㄱㄱ
    public static void solve(int cnt){
        if(cnt == N){
            // 모두 배치 완료하면 만족하는지 확인
            if(find()){
                ans++;
            }
            return;
        }
        
        for(int i =0;i<N;i++){
            // 아직 안나온거면 방문처리 + arr에 넣기
            if(flag[i]){
                continue;
            }
            arr[cnt] = animal[i];
            flag[i] = true;
            solve(cnt+1);
            flag[i] = false;
            
        }
        return;
        
    }
    public static boolean find() {
        String tmp = "";
        for(int i = 0;i<arr.length;i++){
            tmp += arr[i];
        }
        // datas 배열 하나씩 검사
        for(int i = 0 ; i<datas.length;i++){
            String a = datas[i].substring(0,1);
            String b = datas[i].substring(2,3);
            String c = datas[i].substring(3,4);
            int dis = Integer.parseInt(datas[i].substring(4,5));
            // a,b는 동물, c는 부호 , dis는 두개의 떨어져야할 거리
            
            int distance = Math.abs(tmp.indexOf(a) - tmp.indexOf(b)) - 1;
            // 두개 실제로 떨어진 거리
            
			// 일치하지 않을 경우
            if (c.equals(">") && distance <= dis){
				return false;
			}
			else if (c.equals("=") && distance != dis){
				return false;
			}
			else if (c.equals("<") && distance >= dis){
				return false;
			}
		}
		return true;
            
        }
        
}

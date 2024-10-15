class Solution {
    static boolean[][] flag;
    static int answer;
    static int n;
    static int m;
    static String[][] arr;
    public int solution(int m, int n, String[] board) {
        answer = 0;
        this.n = m;
        this.m = n;
        int a = n ;
        n = m;
        m = a;
        // 각 알파벳이 들어온대로 왼쪽 위에서부터 0이 아닌 지점은 2x2지점 나머지 3군데 확인하고
        // 만약 해당된다면 flag 배열에서 true로 바꾸고 마지막에 한번에 전부 0으로 제거한다.
        // 이과정 거치고 나서 왼쪽밑에서부터 0인 지점은 그 위에로 대체하는 과정 거침
        arr = new String[n][m];
        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<m;j++){
                arr[i][j] = board[i].substring(j,j+1);
            }
        }
        
        while(true){
            flag = new boolean[n][m];
            if(solve()){
                // true인 곳이 있다는 것으로 true인곳 제거하면서 count센다
                delete();
            }
            else{
                break;
            }
        }
        
        
        
        return answer;
    }
    public static boolean solve(){
        boolean tmp = false;
        // 만약 하나라도 만족하면 tmp를 true로 바꿔서
        // true가 리턴되면 이 과정 반복
        for(int i = 0 ;i< n-1;i++){
            for(int j = 0;j<m-1;j++){
                String word = arr[i][j];
                // 우선 주변이 같기 확인하기 전에 해당 블록이 활성화되있는 블록인지 확인한다.
                if(word.equals("0")){
                    continue;
                }
                // 3군데가 모두 같다면 true로 바꾸고 flag에서도 true로 전환
                if(word.equals(arr[i+1][j]) && word.equals(arr[i][j+1]) && word.equals(arr[i+1][j+1])){
                    flag[i][j] = true;
                    flag[i+1][j] = true;
                    flag[i][j+1] = true;
                    flag[i+1][j+1] = true;
                    tmp = true;
                }
            }
        }
        return tmp;
        
    }
    public static void delete(){
        // for문을 통해 해당 블록이 true라면
        // 그 블록을 0으로 바꿔주고 count+1 해준다.
        // 이 과정을 모두 마치면 그다음으로 0인 블록 내려주기 진행
        for(int i = 0 ; i < n;i++){
            for(int j = 0;j<m;j++){
                if(flag[i][j]){
                    arr[i][j] = "0";
                    answer++;
                }
            }
        }
        // 이제 위에서부터 0인블록 내려주자
        for(int j=0;j<m;j++){
            a : for(int i = n-1;i>0;i--){
                if(arr[i][j].equals("0")){
                    int tmp = i;
                    boolean none = false;
                    while(tmp >=0){
                        if(arr[tmp][j].equals("0")){
                            tmp --;
                            if(tmp <0){
                                none = true;
                                break;
                            }
                        }
                        else{
                            break;
                        }
            
                    }
                    if(none){
                        break a;
                    }
                    arr[i][j] = arr[tmp][j];
                    arr[tmp][j] = "0";
                }
            }
        }
        
    }
    
}

class Solution {
    public int solution(int n) {
        //모든 경우 조합 후 올바른지 확인하면 시간초과나나?
        n2=n;
        open=0;
        close=0;
        cnt=0;
        dfs("");        
        int answer = cnt;
        return answer;
    }

    public static void dfs(String str){
        if(open>n2||close>n2) return; //더 많은 괄호 사용하면 return
        if(open==n2&&close==n2){//괄호 개수 완성되었다면 올바른 괄혼지 체크해라
            if(check(str))cnt++;
            return;
        }
        open++;
        dfs(str+"{");
        open--;
        close++;
        dfs(str+"}");
        close--;
    }
    
    public static boolean check(String str){//올바른 괄호 체크 메서드
        int chk=0;
        char[] arr=str.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i]=='{'){
                chk++;
            }else chk--;
            if(chk<0) return false;
        }
        return true;
    }
    static int open,close,n2,cnt;
}

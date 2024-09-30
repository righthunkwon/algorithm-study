import java.util.*;

class Solution {
    static String[] arr;
    static HashSet<Integer> hs;
    static boolean[] flag;
    static int ans;
    public int solution(String numbers) {
        ans = 0;
        // 총 7가지의 숫자로 모두 만들 수 있는 가짓수 구해서
        // 해당 숫자가 소수인지 확인
        arr = new String[numbers.length()];
        flag = new boolean[numbers.length()];
        hs = new HashSet<>();
        // 우선 numbers를 배열에 하나씩 다 넣고 1자리 부터 length자리까지 실행
        for(int i = 0 ;i<arr.length;i++){
            arr[i] = numbers.substring(i,i+1);
        }
        // 이제 1자리 숫자부터 진행
        for(int i = 1;i<=arr.length;i++){
            dfs(i,0,"");
        }
        
        return hs.size();
    }
    public static void dfs(int cnt , int index, String word){
        if(index == cnt){
            // 해당 숫자가 소수인지 확인
            solve(Integer.parseInt(word));
            return;
        }
        // dfs를 하면서 숫자 하나씩 조합
        for(int i=0;i<arr.length;i++){
            if(flag[i]){
                continue;
            }
            flag[i] = true;
            dfs(cnt, index+1, word + arr[i]);
            flag[i] = false;
        }
        
    }
    public static void solve(int word){
        if(word < 2){
            return;
        }
        // 2부터 쭉 나눠지는지 확인
        for(int i = 2;i<=(int) Math.sqrt(word);i++){
            if(word%i == 0){
                return;
            }
        }
        hs.add(word);
    }
    
}

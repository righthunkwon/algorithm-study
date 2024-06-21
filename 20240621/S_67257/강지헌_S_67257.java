import java.util.*;

class Solution {
    static long answer = 0;
    static ArrayList<Long> nl = new ArrayList<>();
    static ArrayList<String> ol = new ArrayList<>();
    
    public long solution(String expression) {
        String num = "";
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c=='*' || c=='+' || c=='-'){
                ol.add(c+""); 
                nl.add(Long.parseLong(num));
                num = "";
            }
            else num += c;
        }
        nl.add(Long.parseLong(num));
        dfs(0);
        return answer;
    }
    static String[] op = {"+","-","*"}, pmm = new String[3];
    static boolean[] chk = new boolean[3];
    static void dfs(int d){
        if(d==3){
            sol();
            return;
        }
        for(int i=0; i<3; i++){
            if(chk[i]) continue;
            chk[i] = true; pmm[d] = op[i];
            dfs(d+1);
            chk[i] = false;
        }
    }
    
    static void sol(){
        ArrayList<String> oper = new ArrayList<String>();
        oper.addAll(ol);
        ArrayList<Long> num = new ArrayList<Long>();
        num.addAll(nl);
        for(int i=0; i<3; i++){
            String op = pmm[i];
            for(int j=0; j<oper.size(); j++){
                if(oper.get(j).equals(op)){
                    long res = cal(num.get(j), num.get(j+1), op.charAt(0));
                    num.remove(j+1);
                    num.remove(j);
                    oper.remove(j);
                    num.add(j--, res);
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0)));
    }
    static long cal(long a, long b, char op){
        long res = 0;
        if(op=='*') res = a * b;
        else if(op=='+') res = a + b;
        else if(op=='-') res = a - b;
        return res;
    }
}

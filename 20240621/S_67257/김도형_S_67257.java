import java.util.*;
import java.io.*;

class Solution {
    
    public static ArrayList<Long> nums = new ArrayList<>(); // 숫자 담을 리스트 
	public static ArrayList<String> cals = new ArrayList<>(); // 연산자 담을 리스트 
    
    public long solution(String expression) {
        
        nums = new ArrayList<>();
        cals = new ArrayList<>();
        
        // 연산자 우선순위 경우의 수 6가지
        String[][] priority = {
            {"*", "+", "-"},
            {"*", "-", "+"},
            {"+", "*", "-"},
            {"+", "-", "*"},
            {"-", "*", "+"},
            {"-", "+", "*"}
        };
        
        //일단 숫자랑 연산자 쪼개서 리스트에 담기
        String str = ""; //빈문자열
        for(int i=0;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c=='+'||c=='-'||c=='*'){
                cals.add(c+""); //연산자 리스트에 추가
                nums.add(Long.parseLong(str)); //숫자 리스트에 추가
                str="";//다시 빈 문자열로 초기화
            }else{
                str+=c;
            }
        }
        nums.add(Long.parseLong(str)); //마지막 숫자도 리스트에 넣기
        
        long answer = 0;
        
        // 각 우선순위 경우의 수에 대해 계산
        for (String[] ops : priority) {
            answer = Math.max(answer, Math.abs(calculate(new ArrayList<>(nums), new ArrayList<>(cals), ops)));
        }
  
        return answer;
    }
    
    
    // 주어진 우선순위에 따라 수식 계산
    private long calculate(ArrayList<Long> nums, ArrayList<String> cals, String[] ops) {
        for (String op : ops) {
            for (int i = 0; i < cals.size(); ) {
                if (cals.get(i).equals(op)) {
                    long result = cal(nums.get(i), nums.get(i + 1), op);
                    nums.set(i, result);
                    nums.remove(i + 1);
                    cals.remove(i);
                } else {
                    i++;
                }
            }
        }
        return nums.get(0);
    }
    
    //숫자 2개, 연산자 주어졌을 떄 계산하는 메서드
    public static long cal(long x,long y,String c){
        long a = 0;
        switch(c){
            case "+":
                a=x+y;
                break;
            case "-":
                a=x-y;
                break;
            case "*":
                a=x*y;
                break;
        }
        return a;
    }
}

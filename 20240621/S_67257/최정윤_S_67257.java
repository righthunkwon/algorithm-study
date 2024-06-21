import java.io.*;
import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        //우선순위부터 정하기
        //6개니까 노가다로 정하자
        String[][] arr={
            {"*","+","-"},
            {"*","-","+"},
            {"+","*","-"},
            {"+","-","*"},
            {"-","*","+"},
            {"-","+","*"}
        };
        
        for(int i=0;i<6;i++){ //우선순위 정한 6가지
           List<String> list=new ArrayList(); 
           int idx=0; 
           for(int j=0;j<expression.length();j++){ //원래식 연산자과 숫자로 쪼개기
               if(expression.charAt(j)=='*'||expression.charAt(j)=='-'||expression.charAt(j)=='+'){
                   list.add(expression.substring(idx,j));
                   list.add(expression.substring(j,j+1));
                   idx=j+1;
               }
           }
           list.add(expression.substring(idx)); //맨 마지막 숫자 넣기 ex) tc=1에서는 20
                       
           //우선순위에 따른 식 계산 
           for(int j=0;j<3;j++){
               while(true){
                   int index=list.indexOf(arr[i][j]); //연산자의 위치 확인
                   if(index==-1) break; //-1일 경우 그 연산자 더 이상 없다.
                   long cal=0;
                   long f=Long.parseLong(list.get(index-1));
                   long b=Long.parseLong(list.get(index+1));
                   //연산자 위치 앞 뒤 숫자 계산 
                   if(arr[i][j].equals("*")){
                       cal=f*b;
                   }else if(arr[i][j].equals("-")){
                       cal=f-b;
                   }else{
                       cal=f+b;
                   }
                   //앞 숫자에 새로운 값 교체해서 넣고 뒤에 2개 삭제 
                   list.set(index-1,String.valueOf(cal));
                   list.remove(index+1);
                   list.remove(index);                  
               }
           }
           answer=Math.max(Math.abs(Long.parseLong(list.get(0))),answer);
         
        }
        return answer;
    }
}

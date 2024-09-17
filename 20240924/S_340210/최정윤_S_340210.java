import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] expressions) {
        //n진법 변환 자꾸 까먹어 !!!!!!!
        // 10진수 ->n진수     String n진수 =Integer.toString(10진수 숫자(int),n);
        // n진수 ->10진수     int 10진수 =Integer.parseInt("1010",n);
        boolean[] poss=new boolean[10];
        Arrays.fill(poss,true);
        int x_cnt=0;
        //일단 expressions에 담긴 숫자로 바꿀 수 있는 최대 진수 판별
        h:for(int j=9;j>=2;j--){
            for(int i=0;i<expressions.length;i++){
                if(expressions[i].contains(String.valueOf(j))){
                    for(int k=j;k>=2;k--){
                        poss[k]=false;
                    }  
                    break h;
                }   
            }
        }
        //+,-로 나눠서 생각
        for(int i=0;i<expressions.length;i++){
            if(expressions[i].split("=")[1].trim().equals("X")){
                x_cnt++;
            }else{
                if(expressions[i].contains("+")){
                    String[] arr=expressions[i].split("[+,=]");
                    for(int j=9;j>=2;j--){//j진수로 계산해보고 성립X=> false
                        if(!poss[j])continue;
                        if(Integer.parseInt(arr[0].trim(),j)+Integer.parseInt(arr[1].trim(),j)!=Integer.parseInt(arr[2].trim(),j)) poss[j]=false;
                    }
                }else{
                     String[] arr=expressions[i].split("[-,=]");
                     for(int j=9;j>=2;j--){
                        if(!poss[j])continue; 
                        if(Integer.parseInt(arr[0].trim(),j)-Integer.parseInt(arr[1].trim(),j)!=Integer.parseInt(arr[2].trim(),j)) poss[j]=false;
                    }
                }
                
            }
        }
        // System.out.println(Arrays.toString(poss));
        List<Integer> list=new ArrayList(); //가능한 진수 넣기
        for(int i=2;i<=9;i++){
            if(poss[i])list.add(i);
        }
        String[] answer = new String[x_cnt];
        int idx=0;
        for(int i=0;i<expressions.length;i++){
            if(expressions[i].split("=")[1].trim().equals("X")){
                if(expressions[i].contains("+")){
                    String[] arr=expressions[i].split("[+,=]");
                    String X="";
                    for(Integer n:list){
                        String result=Integer.toString(Integer.parseInt(arr[0].trim(),n)+Integer.parseInt(arr[1].trim(),n),n);
                        if(X.equals("")){
                            X=result;
                        }else{
                            if(!X.equals(result)) X="?";//예전 값이랑 다르면 
                        }
                    }
                    answer[idx]=arr[0]+"+"+arr[1]+"= "+X;
                }else{
                    String[] arr=expressions[i].split("[-,=]");
                    String X="";
                    for(Integer n:list){
                        String result=Integer.toString(Integer.parseInt(arr[0].trim(),n)-Integer.parseInt(arr[1].trim(),n),n);
                        if(X.equals("")){
                            X=result;
                        }else{
                            if(!X.equals(result)) X="?";
                        }
                    }
                    answer[idx]=arr[0]+"-"+arr[1]+"= "+X;
                }
                idx++;
            }
        }
        return answer;
    }
}

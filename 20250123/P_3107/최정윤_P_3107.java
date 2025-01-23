import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        StringBuilder answer=new StringBuilder();
        String[] input= (sc.next()+" ").split(":");
        input[input.length-1]=input[input.length-1].substring(0,input[input.length-1].length()-1);
        int cnt=7;
        for(int i=0;i<input.length;i++){
            if(input[i].length()==0) {
  
    
            		
            	
                for(int j=1;j<=8-input.length+1;j++){
                    answer.append("0000");
                    if(cnt>0){
                        answer.append(":");
                        cnt--;
                    }
                }
                              if(input[i+1].length()==0){
                    //    ㅁㅐㄴㅇㅏㅍ , ㅁㅐㄴ ㄷㅜㅣ
                 answer.append("0000");
                                  if(cnt>0){
                                      answer.append(":");
                                      cnt--;
                                  }
                                  i++;  
                }
            	
            }else if(input[i].length()==4){
                answer.append(input[i]);
                if(cnt>0){
                    answer.append(":");
                    cnt--;
                }
            }else{
                for(int j=0;j<4-input[i].length();j++){
                    answer.append("0");
                }
                answer.append(input[i]);
                if(cnt>0){
                    answer.append(":");
                    cnt--;
                }
            }
        }
        System.out.println(answer.toString());
    }
}
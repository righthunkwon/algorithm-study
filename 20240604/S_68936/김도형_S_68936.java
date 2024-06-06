import java.io.*;
import java.util.*;

class Solution {
    static int zero = 0; //압축 후 0의 개수
    static int one = 0; //압축 후 1의 개수
    public int[] solution(int[][] arr) {
        recursion(arr,arr.length,0,0);
        int[] answer = new int[2];
        answer[0]=zero;
        answer[1]=one;
        return answer;
    }
    
    //x,y는 탐색할 영역 맨 왼쪽 위 좌표
    public void recursion(int[][] arr, int len,int x, int y){      
        boolean flag=false;
  l:   for(int i=y;i<y+len;i++){
            for(int j=x;j<x+len;j++){
                if(arr[i][j]==arr[y][x]){
                    flag=true;                 
                }
                else{
                    flag=false;
                    break l;
                }            
            }
        }
        if(flag){ //해당 부분 다 같으면
            if(arr[y][x]==0) zero++;
            if(arr[y][x]==1) one++;    
            return;
        }
        
        //다 같지 않았을 경우 4등분해서 다시 탐색
        recursion(arr,len/2,x,y);    
        recursion(arr,len/2,x+len/2,y);
        recursion(arr,len/2,x,y+len/2);
        recursion(arr,len/2,x+len/2,y+len/2);  
    }
}

import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] a) {
        //내 기준 왼쪽에서 최솟값, 오른쪽에서 최솟값
        //둘 중 한개는 나보다 커야함
                
        if(a.length<=2) return a.length;
  
        int[] left=new int[a.length];
        int[] right=new int[a.length];
        
        left[0]=a[0];
        for(int i=1;i<a.length;i++){
            left[i]=Math.min(left[i-1],a[i]);
        }
        right[a.length-1]=a[a.length-1];
        for(int i=a.length-2;i>=0;i--){
            right[i]=Math.min(right[i+1],a[i]);
        }
        //제일 끝 왼, 오는 무조건 터트리기 가능
        int answer = 2;
        for(int i=1;i<a.length-1;i++){
            //내 기준, 왼쪽, 오른쪽의 최솟값이 둘다 나보다 작다면 터트리기 불가
            if(left[i-1]<a[i]&&right[i+1]<a[i])continue;
            answer++;
        }
        return answer;
    }
}

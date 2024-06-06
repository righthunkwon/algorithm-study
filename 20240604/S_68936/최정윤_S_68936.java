import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        arr2=arr;
        answer = new int[2];
        dfs(0,0,arr.length);
        return answer;
    }
    public static void dfs(int r,int c, int size){
        if(check(r,c,size,arr2[r][c])){
            answer[arr2[r][c]]++;
            return;
        }
        dfs(r,c,size/2);
        dfs(r+size/2,c,size/2);
        dfs(r,c+size/2,size/2);
        dfs(r+size/2,c+size/2,size/2);
    }
    public static boolean check(int r,int c,int size,int def){
        for(int i=r;i<r+size;i++){
            for(int j=c;j<c+size;j++){
                if(arr2[i][j]!=def) return false;
            }
        }
        return true;
    }
    static int[][] arr2;
    static int[] answer;
}

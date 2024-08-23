import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        //무거운 사람부터 태우되, 최대 2명이니까 가장 가벼운쪽에서 태울수 있으면 태우고
        //못태우면 혼자 태우기
        Arrays.sort(people);
        int l = 0;
        int r = people.length-1;
        while(l<=r){
            if(people[l]+people[r]>limit){
                r--;
                answer++;
            }else{
                r--;
                l++;
                answer++;
            }
        }
        return answer;
    }
}

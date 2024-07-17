import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        //이것도 이모티콘 별로 10~40까지 다 해봐야할듯?!
        sale=new int[]{10,20,30,40};
        users2=users;
        emoticons2=emoticons;
        user=new int[users.length];
        plus=0;
        price=0;
        dfs(0);//이모티콘 idx
        int[] answer = new int[]{plus,price};
        return answer;
    }
    public static void dfs(int emo){
        if(emo==emoticons2.length) {
            cal();
            return;
        }
        
        for(int j=0;j<4;j++){//할인률 dfs 반복
            for(int i=0;i<users2.length;i++){//구매금액 더해놨다가
                if(users2[i][0]<=sale[j]){
                    user[i]+=emoticons2[emo]*(100-sale[j])/100;
               }
            }
            dfs(emo+1);
            for(int i=0;i<users2.length;i++){//구매금액 다시 제자리
                if(users2[i][0]<=sale[j]){
                    user[i]-=emoticons2[emo]*(100-sale[j])/100;
               }
            }
        }
    }
    
    public static void cal(){//최대값 구하는 메소드
        int plus_cnt=0;
        int tot_price=0;

        for(int i=0;i<user.length;i++){
            if(user[i]>=users2[i][1]) {
                plus_cnt++;
            }else{
                tot_price+=user[i];
            }
        }
        if(plus_cnt>plus){
            plus=plus_cnt;
            price=tot_price;
        }else if(plus_cnt==plus&&tot_price>price){
            price=tot_price;
        }
    }
    static int plus,price;
    static int[][] users2;
    static int[] emoticons2,sale,user;
}

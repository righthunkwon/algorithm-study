import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        //배열의 크기가 1~8이니까 시간은 여유 있겠네!
        //다 돌아도 될 듯?
        //for 문으로 하다가 너무 복잡해짐 다음에는 dfs로 해야겠다
        int answer = 0;
        Set<String> ans=new HashSet();
        for(int i=0;i<banned_id.length;i++){
            int length=banned_id[i].length();
            List<String> list=new ArrayList();
            a:for(int j=0;j<user_id.length;j++){
                if(length==user_id[j].length()){
                    for(int k=0;k<length;k++){
                        if(banned_id[i].charAt(k)=='*') continue;
                        if(user_id[j].charAt(k)!=banned_id[i].charAt(k)){
                            continue a;
                        }
                    }
                    list.add(String.valueOf(j));
                }
            } 
            Set<String> newList=new HashSet();//dfs로 할 걸 ..
            for(String str2:list){
                if(ans.size()>0){
                   for(String str:ans){
                      if(!str.contains(str2)) {
                          List<Integer> list2=new ArrayList();
                          for(int k=0;k<str.length();k++){
                              list2.add(Integer.parseInt(str.substring(k,k+1)));
                          }
                          list2.add(Integer.parseInt(str2));
                          Collections.sort(list2);//중복제거를 위해 set에 담고,, 담기전 sort
                          String str3="";
                          for(int k=0;k<list2.size();k++){
                              str3+=list2.get(k);
                          }
                          newList.add(str3);
                      }
                  }
                }
                else{
                    newList.add(str2);
                }
            }
            ans=newList;
        }
        System.out.println(ans.size());
        return ans.size();
    }
}

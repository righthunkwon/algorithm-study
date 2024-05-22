import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String,String> inTime = new HashMap(); //차번호, 들어온 시각
        Map<String,Integer> totTime = new HashMap(); //차번호, 있었던 시간들의 합
        for(int i=0;i<records.length;i++){
            String[] arr=records[i].split(" ");
            if(arr[2].equals("IN")){ //들어오면 map에 넣기
                inTime.put(arr[1],arr[0]);
            }else{ //나가면 map에 있는 시간 꺼내서 시간 계산 후 totTime에 넣기
                String[] startTime=inTime.get(arr[1]).split(":");
                String[] endTime=arr[0].split(":");
                int time=(Integer.parseInt(endTime[0])-Integer.parseInt(startTime[0]))*60+Integer.parseInt(endTime[1])-Integer.parseInt(startTime[1]);
                totTime.put(arr[1],totTime.getOrDefault(arr[1],0)+time);
                inTime.remove(arr[1]); //들어간 것에서 지우기
            }
        }
        for(String notOut:inTime.keySet()){ //들어오기만 하고 나가지 않은 것들 23:59에 나간 것으로 계산
               String[] in= inTime.get(notOut).split(":");
               int time2=(23-Integer.parseInt(in[0]))*60+59-Integer.parseInt(in[1]);
               totTime.put(notOut,totTime.getOrDefault(notOut,0)+time2);
        }
        List<String> list=new ArrayList(totTime.keySet());
        int[] answer = new int[list.size()];
        Collections.sort(list); //차번호 오름차순 정렬
        for(int i=0; i<list.size(); i++) {
            int money=fees[1];
            int total=totTime.get(list.get(i));
            if(total>fees[0]){ //돈 계산
                if((total-fees[0])%fees[2]==0){
                    money+=((total-fees[0])/fees[2])*fees[3];
                }else{
                    money+=((total-fees[0])/fees[2]+1)*fees[3];
                }
            }
            answer[i]=money;
        }

        return answer;
    }
}

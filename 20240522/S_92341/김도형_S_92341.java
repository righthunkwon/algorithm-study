import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int defaultTime = fees[0];
        int defaultCost = fees[1];
        int unitTime = fees[2];
        int unitCost = fees[3];
        
        //차량 상태 저장 
        //carStatus[차량번호][0] = 누적시간(분)
        //carStatus[차량번호][1] = 가장 최근에 입차한 시간
        //carStatus[차량번호][2] -> 0이면 주차장에 없음 , 1이면 주차장에 있음
        int [][] carStatus = new int[10000][3];
        
        //차량별 누적시간(분) 계산
        for(int i = 0;i<records.length;i++){
            String str = records[i];
            System.out.println("str = "+str);
            
            //시간 분단위로 환산
            int time = (str.charAt(0)-'0')*600
                +(str.charAt(1)-'0')*60
                +(str.charAt(3)-'0')*10
                +(str.charAt(4)-'0');
            
            System.out.println("time = "+time);
            //차번호
            int carNum = (str.charAt(6)-'0')*1000
                +(str.charAt(7)-'0')*100
                +(str.charAt(8)-'0')*10
                +(str.charAt(9)-'0');
            System.out.println("carNum = "+carNum);
            
            if(str.charAt(11)=='I'){ //IN 이면
                carStatus[carNum][1]=time; //들어온 시간 기록
                carStatus[carNum][2]=1;
            }else{ //OUT 이면
                carStatus[carNum][2]=0; //나갔다고 기록
                carStatus[carNum][0]+=time-carStatus[carNum][1]; //누적시간 늘려줌
            }

        } // records도는 for문
        
        for(int i=0;i<10000;i++){
            if(carStatus[i][2]==1){ //아직남아있는 차 누적시간 계산
                carStatus[i][2]=0;
                carStatus[i][0]=carStatus[i][0]+1439-carStatus[i][1];
            }
        }
        
        int carCnt=0;
        int tmp[] = new int[1001];
        
        for(int i=0;i<10000;i++){
            if(carStatus[i][0]>0){
                //요금계산
                tmp[carCnt]=defaultCost; //일단 기본요금
                if(carStatus[i][0]>defaultTime){
                    tmp[carCnt]=(int)(defaultCost + Math.ceil((double)(carStatus[i][0]-defaultTime)/unitTime) * unitCost);
                }
                carCnt++; //차량 갯수 카운트
            }else continue;
        }
        System.out.println("1번가격 = "+tmp[0]);
        
        int[] answer = new int[carCnt];
        for(int i=0;i<carCnt;i++){
           answer[i]=tmp[i];
        }

        return answer;
        
    } //main
}

class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        //모르겠어서 블로그 참고  https://velog.io/@bluejii_dev/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EC%95%84%EB%82%A0%EB%A1%9C%EA%B7%B8-%EC%8B%9C%EA%B3%84-250135Java
      
        // 59분에서 정각으로 넘어갈 때는 초침과 분침이 만나지 않는다. 
        // 0시 0분 0초와 12시 0분 0초로 넘어갈 때는 초침과 시침이 만나지 않는다. 
      
        int answer = 0;        
        int bonus=0;
        
        if(h1*3600+m1*60+s1==0 ||h1*3600+m1*60+s1==43200){
            bonus=1;
        }
        return getCount(h2,m2,s2)-getCount(h1,m1,s1)+bonus;
    }
        
    public int getCount(int h1,int m1, int s1){
        
         int total = h1*3600+m1*60+s1;
        
         int m_alram = total*59/3600; //마지막 한바퀴 안만남 
        
         int h_alram = total * 719/43200; //00시와 12시 안만남
 
         int answer = m_alram+h_alram;
 
         if(h1>=12){
             answer--;
         }
        return answer;
    }
}



//원래 접근
// class Solution {
//     public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
//         int answer = 0;
//         //초침이 한바퀴돌때 무조건 시, 분 한번씩 1분에 한번이상은 알람이 울림
//         //두개가 겹치면 1번만 울리고 안겹치면 2번 
//         //시침과 분침이 겹치는 것만 판단하자 
//         //분은 1/10 시는 1/120 초는 6 도 
//         //분이랑 시랑 겹치려면 1/10* n =1/120*n+360*m
//         //n= 360*120/11*정수 초에 두개가 겹친다 
//         //이때 각도는 (360*120/11*정수 *(1/10))%360도로 겹친다 ==6*(360*120/11*정수)%60이여야함
        

             
//         //시작시간을 초로 변환, 끝 시간도 초로 변환
//         int start=h1*60*60+m1 *60+s1;
//         int end=h2*60*60+m2*60+s2;
//         //1분단위 2번 겹친다고 하기 일단
//         int tot=end-start;
//         answer+=(tot/60)*2;
        
//         if(start==0)answer--;
//         if((start>12*60*60)||(end<12*60*60)){}
//         else answer--;
//         //분 빼고 남은 초 
//         double time=tot%60;
//         int st_s=s1*6;
//         double st_h=(h1%12)*30+(m1*60+s1)/120;
//         double st_m=(m1*60+s1)/10;
//         double sum=0;
//         //가로지를 수 있는지 판단하자
//         if(st_h>=st_s){
//             sum=st_h-st_s;
//         }else{
//             sum=360+(st_s-st_h);
//         }
//         if((6-(double)1/120)*time>=sum)answer++;
//         if(st_m>=st_s){
//             sum=st_m-st_s;
//         }else{
//             sum=360-(st_s-st_m);
//         }
        
//         if((6.0-(double)1/10)*time>=sum)answer++;
//         if(tot/60>=1&&h2-h1>=1) answer-=h2-h1+1;
//         return answer;
//     }
// }

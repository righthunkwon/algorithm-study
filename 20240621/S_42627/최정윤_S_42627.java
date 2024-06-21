import java.io.*;
import java.util.*;

class Solution {
    public static class Job {
        int start,t;
        public Job(int start,int t){
            this.start=start;
            this.t=t;
        }
    }
    public int solution(int[][] jobs) {       
        
        //시작 시간 빠른 것부터 하기
        pq = new PriorityQueue(new Comparator<Job>(){
            public int compare(Job j1,Job j2){
                if(j1.start==j2.start){ //이거 안하면 테케 8,18틀림
                    return j1.t-j2.t;
                }
                return j1.start-j2.start;
            }
        });
        
        // 작업 시간 짧은 것부터 하기
        pq2 = new PriorityQueue(new Comparator<Job>(){
            public int compare(Job j1,Job j2){
                return j1.t-j2.t;
            }
        });
        
        for(int i=0;i<jobs.length;i++){
            pq.add(new Job(jobs[i][0],jobs[i][1]));
        }
        int tot=0;
        int curr= 0;
        fin= 0;
        while(!pq.isEmpty()){
            Job job = pq.poll();
            fin= job.start+job.t;
            tot+= job.t;
            same();
            curr=fin;
            while(!pq2.isEmpty()){ //요청들어온 작업하는 동안 누적된 작업이 있다면
                Job job2=pq2.poll();
                fin=curr+job2.t;
                tot+=fin-job2.start;
                same();
                curr=fin;
            }
        }
        int answer = (int)Math.floor(tot/jobs.length);
        return answer;
    }
    static int fin;
    static PriorityQueue<Job> pq,pq2;
    
    public static void same(){//작업이 진행되는 시간동안 요청들어온 작업 pq2에 쌓는 메소드
        while(true){
            if(!pq.isEmpty()&&pq.peek().start<fin){
                   pq2.add(pq.poll());
            }
            else{ 
                return;
            }
        }
    }
}

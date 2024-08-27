class Solution {
    
    public int solution(int n, long l, long r) {
        long answer = 0;
        answer = cal(r,0)-cal(l-1,0);
        return (int)answer;
    }
    
    public static long cal(long x,long total_one){
        if(x/5==0){
            if(x<=2)return x+total_one;
            else return x-1+total_one;
        }
        
        //5의 몇제곱 구간인지 파악
        long p = five(x);
        
        // 해당 구간을 5등분 했을 때 몇 번째에 속하는지 파악
        long part = panel(x, p);

        //3번째 구간이면 더 이상 진행할 필요 없음
        //(두번째 구간까지의 1의 개수 더해주고 리턴)
        if (part == 3) {
            total_one += (part-1)*(Math.pow(4,p-1));
            return total_one;
        } else if(part <=2) {
            total_one += (part-1)*(Math.pow(4,p-1));
            return cal(x-((part-1)*(long)Math.pow(5,p-1)),total_one);
        } else{
            total_one += (part-2)*(Math.pow(4,p-1));
            return cal(x-((part-1)*(long)Math.pow(5,p-1)),total_one);
        } 
    }
    
    // x가 5의 몇제곱 구간인지
    public static long five(long x){
        long tmp = 1;
        long cnt = 0;
        while (tmp < x) {
            tmp *= 5;
            cnt++;
        }
        return cnt;
    }
    
    // 해당 구간을 5등분 했을 때 몇 번째에 속하는지
    public static long panel(long x, long p){
        long length_of_part = (long)Math.pow(5, p - 1);
        return (x - 1) / length_of_part + 1;
    }
    
}

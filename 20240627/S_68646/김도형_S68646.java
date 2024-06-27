class Solution {
    public int solution(int[] a) {
        
        if(a.length==1)return 1; //1개면 무조건 생존
        if(a.length==2)return 2; //2개도 무조건 생존가능
        
        //최후에 남을 수 없는 경우는 풍선 기준 오른쪽 최소,왼쪽 최소 번호가 그 풍선보다 둘다 작을 때다
        //양 끝 풍선은 무조건 생존가능
        
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        
        leftMin[0]=a[0];
        rightMin[a.length-1]=a[a.length-1];
        
        //leftMin 채우기
        for(int i=1;i<a.length-1;i++){
            leftMin[i]=Math.min(leftMin[i-1],a[i]);
        }
        
        //rightMin 채우기
        for(int i=a.length-2;i>=0;i--){
            rightMin[i]=Math.min(rightMin[i+1],a[i]);
        }
        
        //못살아남는 풍선 카운트
        int cnt = 0;
        for(int i=1;i<=a.length-2;i++){
            if(leftMin[i-1]<a[i]&&rightMin[i+1]<a[i])cnt++;
        }
        
        int answer = a.length-cnt; //전체 풍선에서 못 터트리는 풍선 수 빼면 답
        
        return answer;
    }
}

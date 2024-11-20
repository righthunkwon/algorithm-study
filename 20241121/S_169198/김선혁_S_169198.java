class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        // 시작점에서 하나의 목표 공의 위치를 기준으로 각자 거리 계산
        // 4개중 최소값을 기준으로 계산하자
        
        // 4개의 점은 0,두개점의 가운데점 / n, 두개점의 가운데점 / 두개점의 가운데점 , 0 / 두개점의 가운데점 , m
        for(int i = 0;i<balls.length;i++){
            int min = Integer.MAX_VALUE;
            // 4개의 중간점 만들자
            // 우선 가로, 세로 각각의 중간점 구함
            double x = startX-balls[i][0]; // X 거리
            double y = startY-balls[i][1]; // Y 거리
            // 4개의 계산 각각 실행
            double l = Math.pow((startX + balls[i][0]),2) + Math.pow(y,2); // 왼쪽까지 거리
            double r = Math.pow((m - startX) + (m - balls[i][0]),2) + Math.pow(y,2); // 오른쪽 까지 거리
            double d = Math.pow((startY + balls[i][1]),2) + Math.pow(x,2); // 아래쪽까지 거리
            double t = Math.pow((n - startY) + (n - balls[i][1]),2) + Math.pow(x,2); // 위쪽까지 거리
            // 4개의 결과값중 최소값을 저장을 한다.
            // 만약 x또는 y 좌표가 0이게 될경우에는 0인 좌표의 식이 통하지 않아서 3개중에서만 판별하면된다.
            // 
            answer[i] = (int)Math.min(Math.min(l,r),Math.min(d,t));
            if (x == 0){
                if(y > 0){
                    answer[i] = (int)Math.min(Math.min(l,r),t);
                }
                else{
                    answer[i] = (int)Math.min(Math.min(l,r),d);
                }
            }
            else if (y == 0){
                if(x > 0){
                    answer[i] = (int)Math.min(Math.min(d,t),r);
                }
                else{
                    answer[i] = (int)Math.min(Math.min(d,t),l);
                }
            }
            else{
                answer[i] = (int)Math.min(Math.min(l,r),Math.min(d,t));
            }
        }
        
        
        
        return answer;
    }
}

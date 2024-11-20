class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] result = new int[balls.length];
        for (int i = 0 ; i < balls.length; i++){
            double x = startX-balls[i][0], y = startY-balls[i][1];
            double l = Math.pow((startX + balls[i][0]),2) + Math.pow(y,2);
            double r = Math.pow((m - startX) + (m - balls[i][0]),2) + Math.pow(y,2);
            double d = Math.pow((startY + balls[i][1]),2) + Math.pow(x,2);
            double t = Math.pow((n - startY) + (n - balls[i][1]),2) + Math.pow(x,2);
            result[i] = (int)Math.min(Math.min(l,r),Math.min(d,t));
            if(x == 0) {
                if(y > 0) result[i] = (int)Math.min(Math.min(l,r),t);
                else result[i] = (int)Math.min(Math.min(l,r),d);
            }
            else if(y == 0){
                if(x > 0) result[i] = (int)Math.min(Math.min(d,t),r);
                else result[i] = (int)Math.min(Math.min(d,t),l);
            }
            else result[i] = (int)Math.min(Math.min(l,r),Math.min(d,t));
        }
        return result;
    }
}

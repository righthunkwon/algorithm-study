class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        this.rc=rc;
        r=rc.length;
        c=rc[0].length;
        sh=0;
        ro=0;
        for(int i=0;i<operations.length;i++){
            if(operations[i].equals("ShiftRow")){
                if(ro!=0) rotate();
                sh++;
            }else{
                if(sh!=0) shift();
                ro++;
            }
        }
        if(ro!=0)rotate();
        else if(sh!=0) shift();
        int[][] answer = {};
        return answer;
    }
    static int[][] rc;
    static int r,c,sh,ro;
    public static void shift(){
        int[][] rc2=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                rc2[(i+sh)%r][j]=rc[i][j];
            }
        }
        rc=rc2;
        sh=0;
    }
    
    public static void rotate(){
        int[][] rc2=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(((i!=0&&i!=r-1)&&(j>0&&j<c-1))) continue;
                int new_r;
                int new_c;
                if(i==0){
                    new_r=i;
                    new_c=j+ro;
                }else if(i==r-1){
                    new_r=i;
                    new_c=j-ro;
                }else if(j==c-1){
                    new_r=i+ro;
                    new_c=j;
                }else{
                    new_r=i-ro;
                    new_c=j;
                }
                System.out.println("rc"+new_r+new_c);
                while(true){
                    if(new_c>=c){
                        new_r+=new_c-c+1;
                        new_c=c-1;
                    }
                    if(new_r>=r){
                        new_c-=new_r-r+1;
                        new_r=r-1;
                    }
                    if(new_c<0){
                        new_r-=new_c;
                        new_c=0;
                    }
                    if(new_r<0){
                        new_c-=new_r;
                        new_r=0;
                    }
                    if(new_r>=0&&new_c>=0&&new_r<r&&new_c<c) break;
                }
                rc2[new_r][new_c]=rc[i][j];
            }
        }
        rc=rc2;
        ro=0;    
    }
}

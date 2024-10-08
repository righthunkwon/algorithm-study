class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        
        //행렬 초기화
        int [][]arr = new int[rows][columns];
        int num = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                arr[i][j]=++num;
            }
        }
        
        int [] answer = rotate(arr,queries);
        
        return answer;
    }
    
    //회전 시키고 위치 바뀐 가장 작은 숫자 배열에 담는 메서드
    public int[] rotate(int[][]arr,int[][]queries){
        int []ans = new int[queries.length];
        
        int idx = 0; //queries 인덱스
        for(int[]query : queries){
            int x1 = query[0]-1; 
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            int tmp = arr[x1][y1]; //회전할 첫 숫자(가장왼쪽위) 임시로 빼두기
            int minNum = tmp;
            
            //왼쪽열 한칸 위로
            for(int i=x1;i<x2;i++){
                arr[i][y1]=arr[i+1][y1];
                minNum = Math.min(arr[i][y1],minNum);
            }
            
            //아래행 한칸 왼쪽으로
            for(int i=y1;i<y2;i++){
                arr[x2][i]=arr[x2][i+1];
                minNum = Math.min(arr[x2][i],minNum);
            }
            
            //오른쪽열 한칸 아래로
            for(int i=x2;i>x1;i--){
                arr[i][y2]=arr[i-1][y2];
                minNum = Math.min(arr[i][y2],minNum);
            }
            
            //위쪽행 한칸 오른쪽으로
            for(int i=y2;i>y1;i--){
                arr[x1][i]=arr[x1][i-1];
                minNum = Math.min(arr[x1][i],minNum);
            }
            
            arr[x1][y1+1]=tmp; //빼뒀던 숫자 채워주기
            ans[idx++]=minNum;
        }

        return ans;
    }
    
}

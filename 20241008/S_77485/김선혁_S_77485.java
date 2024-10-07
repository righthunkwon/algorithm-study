class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        // 해당 직사각형에서 (x1, y1, x2, y2) 범위의 정수 4개를 기준으로 회전시킴
        // 주어진 index는 2,2로 주어지니깐 실행할때 -1한 범위에서 계산해야함
        
        // 빡구현 해보자
        // 먼저 arr배열에 각 숫자를 넣음
        int[][] arr= new int[rows][columns];
        for(int i= 0 ;i<rows;i++){
            for(int j = 0;j<columns;j++){
                arr[i][j] = i*columns + j + 1;
            }
        }
        // 이제 하나씩 해보자
        // 시계방향 그대로 따라갈라하면 오류뜸... 반대로 오는 방향으로 진행
        for(int i = 0 ;i< queries.length;i++){
            int a = queries[i][0] -1;
            int b = queries[i][1] -1;
            int c = queries[i][2] -1;
            int d = queries[i][3] -1;
            
            int min = arr[a][b];
            int tmp = min;
            // tmp에 현재 숫자 저장해놓고 숫자 옮기는 방식
            // 왼쪽줄부터 회전
            for(int k = a; k < c; k++){
                arr[k][b] = arr[k+1][b];                
                min = Math.min(arr[k][b], min);
            }
            // 아래줄 회전
            for(int k = b;k<d;k++){
                arr[c][k] = arr[c][k+1];
                min = Math.min(arr[c][k] , min);
            }
            // 오른쪽 회전
            for(int k = c; k>a ;k--){
                arr[k][d] = arr[k-1][d];
                min = Math.min(arr[k][d], min);
            }
            // 윗줄 회전
            for(int k = d;k>b;k--){
                arr[a][k] = arr[a][k-1];
                min = Math.min(arr[a][k], min);
            }   
            // 마지막은 왼쪽줄에서 회전한 것을 가져온것으로 바꿔주고 최소값 저장
            arr[a][b+1] = tmp;
            answer[i] = min;
        }
        
        
        
        return answer;
    }
}

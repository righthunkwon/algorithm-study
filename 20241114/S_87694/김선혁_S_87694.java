import java.util.*;

class Solution {
    class node{
        int x;
        int y;
        
        public node(int x, int y){
            this.x=x;
            this.y=y;   
        }
    }
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 각 끝에 있는 좌표들만 따로 저장해서 시작점에서 끝점까지 가는길 찾음
        // 테두리 확인하는 방법은 좌표를 2배 곱해서 확인하는 방법
        int start_x=characterX*2;
        int start_y=characterY*2;
        int end_x=itemX*2;
        int end_y=itemY*2;
        // 각좌표를 두배해서 map에 넣음
        boolean[][] map= new boolean[103][103];
        int ted=0;
        
        for(int[] data:rectangle){
            //1.테두리 포함해서 직사각형 모두 true채우기
            for(int i=data[1]*2;i<=data[3]*2;i++){
              for(int j=data[0]*2;j<=data[2]*2;j++){
                    map[i][j]=true;
                  
              }  
            }
        }
        
        //2.테두리 제외해서 직사각형 내부 모두 false채우기        
        for(int[] data:rectangle){
            for(int i=data[1]*2+1;i<data[3]*2;i++){
              for(int j=data[0]*2+1;j<data[2]*2;j++){
                    map[i][j]=false;
              }  
            }
        }
    
        //bfs 탐색
        Stack<node> stack = new Stack<>();
        
        // 시작점 설정
        node n = new node(start_x,start_y);
        stack.add(n);
        
        List<Integer> result =new ArrayList<>();
        int cnt=0;
        
        while(true){       
            if(stack.isEmpty()){
                result.add(cnt);
                break;
            }
            node temp=stack.pop();
            int x=temp.x;
            int y=temp.y; 
           
            //도착하면 갯수 저장
            if(x==end_x&&y==end_y){
                result.add(cnt);         
            }
            
            //지났으면 지난자리 false               
            map[y][x]=false;
            
            if(map[y+1][x]==true) stack.add(new node(x,y+1));
            if(map[y][x+1]==true) stack.add(new node(x+1,y));
            if(map[y-1][x]==true) stack.add(new node(x,y-1));
            if(map[y][x-1]==true) stack.add(new node(x-1,y));
            
            cnt++;
            
        }
        
        answer=Math.min(result.get(0)/2,result.get(1)/2-result.get(0)/2);      
        return answer;
    }
    
}

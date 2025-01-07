import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        //Integer.MAX_VALUE로 하니까 출력초과뜸 ㅠ
        int[][] arr= new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(arr[i],123456789);
        }
        
        for(int i=0;i<m;i++){
            st=new StringTokenizer(br.readLine());
            int one= Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            //길이 여러개 있을 수도 있다고 했으니까
            arr[one][two]= Math.min(dist,arr[one][two]);
        }
        
        for(int mid=1;mid<=n;mid++){//경유지
            for(int i=1;i<=n;i++){//출발지
                if(i==mid)continue;
                for(int j=1;j<=n;j++){//도착지
                    if(i==j||mid==j)continue;
					//더 작은 값이 있다면 갱신
                    if(arr[i][j]>arr[i][mid]+arr[mid][j]){
                        arr[i][j]= arr[i][mid]+arr[mid][j];
                    }
                }
            }
        }
        
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= n; j++) {
            if (arr[i][j] == 123456789) sb.append(0);
            else sb.append(arr[i][j]);
            sb.append(" ");
        }
        sb.append("\n");
    }
    System.out.println(sb);
    }
}
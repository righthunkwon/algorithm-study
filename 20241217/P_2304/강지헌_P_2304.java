import java.io.*;
import java.util.*;
public class Main {
   public static void main(String[] args) throws IOException {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      int N=Integer.parseInt(br.readLine());
      int[][] arr=new int[N][2];
      for (int i=0;i<N;i++) {
    	 StringTokenizer st=new StringTokenizer(br.readLine());
         arr[i][0]=Integer.parseInt(st.nextToken());
         arr[i][1]=Integer.parseInt(st.nextToken());
      }
      Arrays.sort(arr,(o1,o2)->o1[0]-o2[0]);
      int ans=0;
      for(int i=0;i<N;){
         int j=i+1,max=j;
         while(j<N && arr[i][1]>arr[j][1]) if(arr[max][1]<arr[j++][1]) max=j-1;
         if(j>=N) {
            ans+=arr[i][1];
            if(max<N) ans+=arr[max][1]*(arr[max][0]-arr[i][0]-1);
            i=max;
         }
         else {
            ans+=arr[i][1]*(arr[j][0]-arr[i][0]);
            i=j;
         }
      }
      System.out.println(ans);
   }
}

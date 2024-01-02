import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(System.in);
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a=Integer.parseInt(st.nextToken());
		int b=Integer.parseInt(st.nextToken());
		int[][] map=new int[b+1][a+1];
		st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		Node[] arr=new Node[N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int y=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			arr[i]=new Node(x,y,st.nextToken().charAt(0));
			map[x][y]=i+1;
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			char c=st.nextToken().charAt(0);
			int r=Integer.parseInt(st.nextToken());
			if(c=='F') {
				int dx=arr[t-1].x;
				int dy=arr[t-1].y;
				char dd=arr[t-1].d;
				map[dx][dy]=0;
				for(int j=0;j<r;j++) {
					if(dd=='N') dx++;
					else if(dd=='W') dy--;
					else if(dd=='E') dy++;			
					else if(dd=='S') dx--;
					if(dx<=0 || dx>b || dy<=0 || dy>a) {
						System.out.println("Robot "+t+" crashes into the wall");
						return;
					}
					else if(map[dx][dy]!=0) {
						System.out.println("Robot "+t+" crashes into robot "+map[dx][dy]);
						return;
					}
				}
				map[dx][dy]=t;
				arr[t-1].x=dx;
				arr[t-1].y=dy;
			}
			else if(c=='L') {
				for(int j=0;j<r;j++) {
					char dd=arr[t-1].d;
					if(dd=='N') arr[t-1].d='W';
					else if(dd=='W') arr[t-1].d='S';
					else if(dd=='E') arr[t-1].d='N';
					else if(dd=='S') arr[t-1].d='E';
				}
			}
			else if(c=='R') {
				for(int j=0;j<r%4;j++) {
					char dd=arr[t-1].d;
					if(dd=='N') arr[t-1].d='E';
					else if(dd=='W') arr[t-1].d='N';
					else if(dd=='E') arr[t-1].d='S';
					else if(dd=='S') arr[t-1].d='W';
				}
			}
		}
		System.out.println("OK");
	}
}
class Node{
	int x,y;
	char d;
	Node(int x,int y,char d){
		this.x=x;
		this.y=y;
		this.d=d;
	}
}

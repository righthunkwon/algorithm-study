import java.io.*;
import java.util.*;

public class BOJ_G2_20327_배열_돌리기6 {

	static int [][] arr;
	static int n,r,full_size;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	n = Integer.parseInt(st.nextToken());
    	r = Integer.parseInt(st.nextToken());
    	full_size = (int)Math.pow(2, n); //전체배열 가로 세로 길이
    	arr = new int [full_size][full_size];
    	//배열 입력
    	for(int i=0;i<full_size;i++) {
    		st = new StringTokenizer(br.readLine());
    		for(int j=0;j<full_size;j++) {
    			arr[i][j]=Integer.parseInt(st.nextToken());
    		}
    	}
    	//연산 수행
    	for(int i=0;i<r;i++) {
    		st = new StringTokenizer(br.readLine());
    		int k = Integer.parseInt(st.nextToken()); //k번 연산
    		int l = Integer.parseInt(st.nextToken()); //l단계
    		int part_size = (int)Math.pow(2, l); //부분배열 가로세로 길이
    		cal(k,part_size);
    	}
    	//출력
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<full_size;i++) {
    		for(int j=0;j<full_size;j++) {
    			sb.append(arr[i][j]+" ");
    		}
    		sb.append("\n");
    	}
    	System.out.println(sb.toString());
    	
		
		
	}//main
	
	static void cal(int num, int part_size) {
		if(num==1) {
			cal_one(part_size);
		}else if(num==2) {
			cal_two(part_size);
		}else if(num==3) {
			cal_three(part_size);
		}else if(num==4) {
			cal_four(part_size);
		}else if(num==5) {
			cal_five(part_size);
		}else if(num==6) {
			cal_six(part_size);
		}else if(num==7) {
			cal_seven(part_size);
		}else if(num==8) {
			cal_eight(part_size);
		}
	}
	
	//1번 연산 - 부분배열 상하 반전
	static void cal_one(int part_size) {
		//모든 부분배열에 대해 수행
		for(int i=0;i<full_size;i+=part_size) {
			for(int j=0;j<part_size/2;j++) {
				for(int k=0;k<full_size;k++) {
					//상하반전으로 스왑
					int tmp = arr[i+j][k];
					arr[i+j][k]=arr[i+part_size-1-j][k];
					arr[i+part_size-1-j][k] = tmp;
				}
			}
		}
	}
	
	//2번 연산 - 부분배열 좌우 반전
	static void cal_two(int part_size) {
		//모든 부분배열에 대해 수행
		for(int i=0;i<full_size;i+=part_size) {
			for(int j=0;j<part_size/2;j++) {
				for(int k=0;k<full_size;k++) {
					//상하반전으로 스왑
					int tmp = arr[k][i+j];
					arr[k][i+j]=arr[k][i+part_size-1-j];
					arr[k][i+part_size-1-j] = tmp;
				}
			}
		}
	}
	
	//3번 연산 - 부분배열 오른쪽으로 90도 회전
	static void cal_three(int part_size) {
		int [][] tmp = new int[full_size][full_size];
		//모든 부분 배열을 순회
		for(int i=0;i<full_size;i+=part_size) {
			for(int j=0;j<full_size;j+=part_size) {
				//부분 배열 오른쪽 90도 회전시키기
				for(int k=0;k<part_size;k++) {
					for(int l=0;l<part_size;l++) {
						tmp[i+l][j+part_size-1-k]=arr[i+k][j+l];
					}
				}
			}
		}
		arr = tmp;
	}
	
	//4번 연산 - 부분배열 왼쪽으로 90도 회전
	static void cal_four(int part_size) {
		int [][] tmp = new int[full_size][full_size];
		//모든 부분 배열을 순회
		for(int i=0;i<full_size;i+=part_size) {
			for(int j=0;j<full_size;j+=part_size) {
				//부분 배열 왼쪽 90도 회전시키기
				for(int k=0;k<part_size;k++) {
					for(int l=0;l<part_size;l++) {
						tmp[i+k][j+l]=arr[i+l][j+part_size-1-k];
					}
				}
			}
		}
		arr = tmp;
	}
	
	//5번 연산 - 전체 배열 상하반전 (부분배열을 한 칸으로 생각)
	static void cal_five(int part_size) {
		for(int i=0;i<full_size/2;i++) {
			for(int j=0;j<full_size;j++) {
				int tmp = arr[i][j];
				arr[i][j]=arr[((full_size-i-1)/part_size)*part_size+i%part_size][j];
				arr[((full_size-i-1)/part_size)*part_size+i%part_size][j] = tmp;
			}
		}
	}
	
	//6번 연산 - 전체 배열 좌우반전 (부분배열을 한 칸으로 생각)
	static void cal_six(int part_size) {
		for(int i=0;i<full_size/2;i++) {
			for(int j=0;j<full_size;j++) {
				int tmp = arr[j][i];
				arr[j][i]=arr[j][((full_size-i-1)/part_size)*part_size+i%part_size];
				arr[j][((full_size-i-1)/part_size)*part_size+i%part_size] = tmp;
			}
		}
	}
	
	//7번 연산 - 전체 배열 오른쪽 90도 회전 (부분배열을 한 칸으로 생각)
	static void cal_seven(int part_size) {
		int[][]tmp = new int[full_size][full_size];
		for(int i=0;i<full_size;i+=part_size) {
			for(int j=0;j<full_size;j+=part_size) {
				//부분 배열 오른쪽 90도 회전시키기
				for(int k=0;k<part_size;k++) {
					for(int l=0;l<part_size;l++) {
						tmp[j+k][((full_size-1-i)/part_size)*part_size+l]=arr[i+k][j+l];
					}
				}
			}
		}
		arr = tmp;
	}
	
	//8번 연산 - 전체 배열 왼쪽 90도 회전 (부분배열을 한 칸으로 생각)
	static void cal_eight(int part_size) {
		int[][]tmp = new int[full_size][full_size];
		for(int i=0;i<full_size;i+=part_size) {
			for(int j=0;j<full_size;j+=part_size) {
				//부분 배열 왼쪽 90도 회전시키기
				for(int k=0;k<part_size;k++) {
					for(int l=0;l<part_size;l++) {
						tmp[i+k][j+l]=arr[j+k][((full_size-1-i)/part_size)*part_size+l];
					}
				}
			}
		}
		arr = tmp;
	}
	
	
}

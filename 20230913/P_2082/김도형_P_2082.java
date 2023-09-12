import java.util.Scanner;

public class Main {

	static String zero = "####.##.##.####";
	static String one = "..#..#..#..#..#";
	static String two = "###..#####..###";
	static String three = "###..####..####";
	static String four = "#.##.####..#..#";
	static String five = "####..###..####";
	static String six = "####..####.####";
	static String seven = "###..#..#..#..#";
	static String eight = "####.#####.####";
	static String nine = "####.####..####";  //숫자를 문자열 형태로 받아옴
	
	static String [] arr = {zero,one,two,three,four,five,six,seven,eight,nine};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		StringBuilder sb4 = new StringBuilder();  //1자리씩 입력받기 위한 sb생성
		
		for(int i = 0;i<5;i++) {
			sb1.append(sc.next());
			sb2.append(sc.next());
			sb3.append(sc.next());
			sb4.append(sc.next());  //3개씩 끊어서 입력받기
		}
		
		String a = sb1.toString();
		String b = sb2.toString();
		String c = sb3.toString();
		String d = sb4.toString();   //문자열로 형변환
		
		a = time(a);
		b = time(b);
		c = time(c);
		d = time(d);
		
		System.out.println(a+b+":"+c+d);
		
	}//main
	
	public static String time(String sb) {
		
		String ans = "";
		
		for(int i=0; i<10;i++) {
			
			int check = 0;
			
			for(int j=0;j<15;j++) {
				
				if(sb.charAt(j)=='#' && arr[i].charAt(j)=='.') {
					break;
				}else check++;
				
			}
			if (check==15) {
				ans = Integer.toString(i);
				break;
			}
			
		}

		return ans;
	}

}//class
